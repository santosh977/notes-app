package com.example.notes;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.TranslateAnimation;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class NotesFragment extends ListFragment {

	private QuickReturnListView mListView;
	private View mHeader;
	private TextView mQuickReturnView;
	private View mPlaceHolder;

	private int mCachedVerticalScrollRange;
	private int mQuickReturnHeight;

	private static final int STATE_ONSCREEN = 0;
	private static final int STATE_OFFSCREEN = 1;
	private static final int STATE_RETURNING = 2;
	private int mState = STATE_ONSCREEN;
	private int mScrollY;
	private int mMinRawY = 0;

	private TranslateAnimation anim;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Toast.makeText(getApplicationContext(),"Quiz",
		// Toast.LENGTH_LONG).show();

		View view = inflater.inflate(R.layout.fragment, null);
		mHeader = inflater.inflate(R.layout.header, null);
		mQuickReturnView = (TextView) view.findViewById(R.id.sticky);
		mPlaceHolder = mHeader.findViewById(R.id.placeholder);
		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		mListView = (QuickReturnListView) getListView();

		mQuickReturnView.setText("Notes");
		mListView.addHeaderView(mHeader);
		List<String> listitems = new ArrayList<String>();
		listitems.add(">> Add Notes <<");
		listitems.add(">> Search <<");
		listitems.add(">> Switch to profile <<");
		NotesDatabaseHandler db = new NotesDatabaseHandler(getActivity()
				.getApplicationContext());
		List<NotesData> users = db.getAllContacts();
		for (NotesData cn : users) {
			listitems.add(cn.getNotes());
		}

		ArrayAdapter<String> adpnew = new ArrayAdapter<String>(getActivity(),
				R.layout.list_item, R.id.text1, listitems);
		setListAdapter(adpnew);

		// Toast.makeText(getActivity(), "Check", Toast.LENGTH_LONG).show();

		mListView.getViewTreeObserver().addOnGlobalLayoutListener(
				new ViewTreeObserver.OnGlobalLayoutListener() {
					@Override
					public void onGlobalLayout() {
						mQuickReturnHeight = mQuickReturnView.getHeight();
						mListView.computeScrollY();
						mCachedVerticalScrollRange = mListView.getListHeight();
					}
				});

		mListView.setOnScrollListener(new OnScrollListener() {
			@SuppressLint("NewApi")
			@Override
			public void onScroll(AbsListView view, int firstVisibleItem,
					int visibleItemCount, int totalItemCount) {

				mScrollY = 0;
				int translationY = 0;

				if (mListView.scrollYIsComputed()) {
					mScrollY = mListView.getComputedScrollY();
				}

				int rawY = mPlaceHolder.getTop()
						- Math.min(
								mCachedVerticalScrollRange
										- mListView.getHeight(), mScrollY);

				switch (mState) {
				case STATE_OFFSCREEN:
					if (rawY <= mMinRawY) {
						mMinRawY = rawY;
					} else {
						mState = STATE_RETURNING;
					}
					translationY = rawY;
					break;

				case STATE_ONSCREEN:
					if (rawY < -mQuickReturnHeight) {
						mState = STATE_OFFSCREEN;
						mMinRawY = rawY;
					}
					translationY = rawY;
					break;

				case STATE_RETURNING:
					translationY = (rawY - mMinRawY) - mQuickReturnHeight;
					if (translationY > 0) {
						translationY = 0;
						mMinRawY = rawY - mQuickReturnHeight;
					}

					if (rawY > 0) {
						mState = STATE_ONSCREEN;
						translationY = rawY;
					}

					if (translationY < -mQuickReturnHeight) {
						mState = STATE_OFFSCREEN;
						mMinRawY = rawY;
					}
					break;
				}

				/** this can be used if the build is below honeycomb **/
				if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.HONEYCOMB) {
					anim = new TranslateAnimation(0, 0, translationY,
							translationY);
					anim.setFillAfter(true);
					anim.setDuration(0);
					mQuickReturnView.startAnimation(anim);
				} else {
					mQuickReturnView.setTranslationY(translationY);
				}

			}

			@Override
			public void onScrollStateChanged(AbsListView view, int scrollState) {
			}
		});
		OnItemClickListener listSelect = new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				if (arg2 == 1) {
					startActivity(new Intent(getActivity()
							.getApplicationContext(), NewNotes.class));
					getActivity().finish();
				}

			}
		};

		mListView.setOnItemClickListener(listSelect);
	}
}