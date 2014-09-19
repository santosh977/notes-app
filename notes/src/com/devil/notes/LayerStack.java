/*  Created by Edward Akoto on 12/31/12.
 *  Email akotoe@aua.ac.ke
 * 	Free for modification and distribution
 */

package com.devil.notes;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class LayerStack extends Action {

	// Declare
	private LinearLayout slidingPanel;
	private boolean isExpanded;
	private DisplayMetrics metrics;
	// private ListView listView;
	private RelativeLayout headerPanel;
	private RelativeLayout menuPanel;
	private int panelWidth;
	private ImageView menuViewButton;
	private ImageView imageView1;

	FrameLayout.LayoutParams menuPanelParameters;
	FrameLayout.LayoutParams slidingPanelParameters;
	LinearLayout.LayoutParams headerPanelParameters;
	LinearLayout.LayoutParams listViewParameters;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_layer_stack);

		// Initialize
		metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);
		panelWidth = (int) ((metrics.widthPixels) * 0.75);

		headerPanel = (RelativeLayout) findViewById(R.id.header);
		headerPanelParameters = (LinearLayout.LayoutParams) headerPanel
				.getLayoutParams();
		headerPanelParameters.width = metrics.widthPixels;
		headerPanel.setLayoutParams(headerPanelParameters);

		menuPanel = (RelativeLayout) findViewById(R.id.menuPanel);
		menuPanelParameters = (FrameLayout.LayoutParams) menuPanel
				.getLayoutParams();
		menuPanelParameters.width = panelWidth;
		menuPanel.setLayoutParams(menuPanelParameters);

		slidingPanel = (LinearLayout) findViewById(R.id.slidingPanel);
		slidingPanelParameters = (FrameLayout.LayoutParams) slidingPanel
				.getLayoutParams();
		slidingPanelParameters.width = metrics.widthPixels;
		slidingPanel.setLayoutParams(slidingPanelParameters);

		/*
		 * listView = (ListView) findViewById(R.id.list); listViewParameters =
		 * (LinearLayout.LayoutParams) listView.getLayoutParams();
		 * listViewParameters.width = metrics.widthPixels;
		 * listView.setLayoutParams(listViewParameters);
		 */

		// Slide the Panel
		menuViewButton = (ImageView) findViewById(R.id.menuViewButton);
		menuViewButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				if (!isExpanded) {
					isExpanded = true;

					// Expand
					new ExpandAnimation(slidingPanel, panelWidth,
							Animation.RELATIVE_TO_SELF, 0.0f,
							Animation.RELATIVE_TO_SELF, 0.75f, 0, 0.0f, 0, 0.0f);
				} else {
					isExpanded = false;

					// Collapse
					new CollapseAnimation(slidingPanel, panelWidth,
							TranslateAnimation.RELATIVE_TO_SELF, 0.75f,
							TranslateAnimation.RELATIVE_TO_SELF, 0.0f, 0, 0.0f,
							0, 0.0f);

				}
			}
		});
		imageView1 = (ImageView) findViewById(R.id.imageView1);
		imageView1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				startActivity(new Intent(getApplicationContext(), Search.class));

			}
		});

	}

	public void imageSelect(View v) {
		switch (v.getId()) {
		case R.id.notes:
			startActivity(new Intent(getApplicationContext(), scrolltab.class));
			break;
		case R.id.asquz:
			startActivity(new Intent(getApplicationContext(), scrolltab.class));
			break;
		case R.id.tnp1:
			startActivity(new Intent(getApplicationContext(), Members.class));
			break;
		case R.id.clg12:
			startActivity(new Intent(getApplicationContext(), Clges.class));
			break;
		/*
		 * case R.id.cht: startActivity(new Intent(getApplicationContext(),
		 * Chatroom.class)); break;
		 */
		case R.id.newsfeed:
			startActivity(new Intent(getApplicationContext(), NewsFeed.class));
			break;
		/*
		 * case R.id.notes: startActivity(new
		 * Intent(getApplicationContext(),Note.class)); break;
		 */

		default:

			Toast.makeText(getApplicationContext(), "TODO", Toast.LENGTH_LONG)
					.show();
		}
	}

	public void SliderClick(View v) {
		switch (v.getId()) {
		case R.id.menu_item_2:
			startActivity(new Intent(getApplicationContext(), LayerStack.class));
			break;
		case R.id.menu_item_1:
			startActivity(new Intent(getApplicationContext(), Profdiv.class));
			break;
		case R.id.menu_item_4:
			startActivity(new Intent(getApplicationContext(), NewNotes.class));
			break;
		case R.id.menu_item_6:
			startActivity(new Intent(getApplicationContext(), CustomGrid.class));
			break;
		case R.id.menu_item_7:// NewsFeed
			startActivity(new Intent(getApplicationContext(), NewsFeed.class));
			break;
		case R.id.menu_item_10:
			startActivity(new Intent(getApplicationContext(), Clges.class));
			break;
		case R.id.menu_item_11:
			startActivity(new Intent(getApplicationContext(), Members.class));
			break;

		case R.id.menu_item_13:
			startActivity(new Intent(getApplicationContext(), Loginpage.class));
			finish();
			break;

		default:
			Toast.makeText(getApplicationContext(), "TODO", Toast.LENGTH_LONG)
					.show();
			break;
		}
	}
	 public boolean onOptionsItemSelected(MenuItem item)
	    {   return super.onOptionsItemSelected(item);  
	    }    
}
