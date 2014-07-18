package com.example.notes;

import java.util.ArrayList;
import java.util.List;

import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

@SuppressWarnings("deprecation")
public class scrolltab extends TabActivity implements TabHost.TabContentFactory {

	TextView txt;
	TextView txtcount;
	// int count=0;
	ImageView img;
	Button btn;

	ArrayList<String> arr = new ArrayList<String>();
	ArrayList<String> arr1 = new ArrayList<String>();
	ArrayList<Integer> arr2 = new ArrayList<Integer>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.scrolltab);

		arr.add(">> Add a Note <<");
		arr1.add("Try tapping :)");
		NotesDatabaseHandler db = new NotesDatabaseHandler(
				getApplicationContext());
		List<NotesData> users = db.getAllContacts();
		for (NotesData cn : users) {
			arr.add(cn.getName());
			arr1.add(cn.getNotes());
		}
		// arr.add(">>Delete<<");
		arr2.add(R.drawable.add);
		arr2.add(R.drawable.textnote);

		final TabHost tabHost = getTabHost();
		/*
		 * for (int i=1; i <= 6; i++) { String name = "Tab " + i;
		 * tabHost.addTab(tabHost.newTabSpec(name) .setIndicator(name)
		 * .setContent(this));}
		 */

		String TabName;
		TabName = new String("Notes");
		tabHost.addTab(tabHost.newTabSpec(TabName).setIndicator(TabName)
				.setContent(this));
		TabName = new String("Assignments");
		tabHost.addTab(tabHost.newTabSpec(TabName).setIndicator(TabName)
				.setContent(this));
		TabName = new String("Quizzes");
		tabHost.addTab(tabHost.newTabSpec(TabName).setIndicator(TabName)
				.setContent(this));
		TabName = new String("Projects");
		tabHost.addTab(tabHost.newTabSpec(TabName).setIndicator(TabName)
				.setContent(this));

	}

	public View createTabContent(String tag) {

		// switch(Integer.parseInt(tag.substring(4,tag.length())))
		if (tag.equals("Notes")) {
			ListView lv;
			lv = (ListView) findViewById(R.id.listView1);
			lv.setAdapter(new IconicAdapter(this));
			return lv;
		}/*
		 * else if (tag.equals("Search")) { startActivity(new
		 * Intent(getApplicationContext(), Search.class)); finish(); final
		 * TextView tv = new TextView(this); tv.setText(tag + " is Loading...");
		 * // lv.setAdapter(null); return tv; }
		 */
		// break;
		else {
			final TextView tv = new TextView(this);
			tv.setText("Content for tab with tag " + tag);
			// lv.setAdapter(null);
			return tv;
			// break;
		}

	}

	private class IconicAdapter extends ArrayAdapter<String> {

		public IconicAdapter(Context context) {
			super(context, R.layout.list, R.id.textView1, arr);

		}

		public View getView(int position, View view, ViewGroup parent) {
			View list = super.getView(position, view, parent);

			img = (ImageView) list.findViewById(R.id.imageView1);
			txt = (TextView) list.findViewById(R.id.textView2);
			txtcount = (TextView) list.findViewById(R.id.textView3);
			btn = (Button) list.findViewById(R.id.button1);

			// txtcount.setText(String.valueOf(count));
			txtcount.setText(String.valueOf(position));
			txt.setText(arr1.get(position));
			// count++;
			if (position == 0) {
				img.setImageDrawable(getResources().getDrawable(arr2.get(0)));
				btn.setText("Add");
				// btn.setVisibility(View.INVISIBLE);
			} else {
				img.setImageDrawable(getResources().getDrawable(arr2.get(1)));
				btn.setText("Delete");
			}
			// img.setImageResource(arr2.get(position));

			OnClickListener NotesListButtonClick = new OnClickListener() {

				@Override
				public void onClick(View v) {
					if (v.getId() == R.id.button1) {
						Toast.makeText(getApplicationContext(), v.toString(),
								Toast.LENGTH_LONG).show();
						int position = Integer.parseInt((((TextView) v
								.findViewById(R.id.textView3)).getText())
								.toString());
						position = position;
						if (position != 0) {
							NotesDatabaseHandler db = new NotesDatabaseHandler(
									getApplicationContext());
							List<NotesData> users = db.getAllContacts();
							/*
							 * Toast.makeText(getApplicationContext(),users.get(1
							 * ).getNotes(), Toast.LENGTH_LONG).show();
							 */

							// db.deleteContact(users.get(position - 1));
							db.deleteContact(users.get(0));
							startActivity(new Intent(getApplicationContext(),
									scrolltab.class));
							finish();
						}
					} else {
						int position = Integer.parseInt(((TextView) v
								.findViewById(R.id.textView3)).getText()
								.toString());
						if (position == 0) {
							startActivity(new Intent(getApplicationContext(),
									NewNotes.class));
							finish();
						} else {
							Toast.makeText(getApplicationContext(), "TODO",
									Toast.LENGTH_LONG).show();
						}
					}
				}
			};
			btn.setOnClickListener(NotesListButtonClick);
			list.setOnClickListener(NotesListButtonClick);
			return list;
		}
	}
}