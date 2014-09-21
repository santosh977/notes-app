package com.devil.notes;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class Forgot extends Action {

	private LinearLayout slidingPanel;
	private boolean isExpanded;
	private DisplayMetrics metrics;
	// private ListView listView;
	private RelativeLayout headerPanel;
	private RelativeLayout menuPanel;
	private int panelWidth;
	private ImageView menuViewButton;

	FrameLayout.LayoutParams menuPanelParameters;
	FrameLayout.LayoutParams slidingPanelParameters;
	LinearLayout.LayoutParams headerPanelParameters;
	LinearLayout.LayoutParams listViewParameters;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.forgot_pswrd);

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
	}

	public void sendEmail(View v) {
		if (!(((EditText) findViewById(R.id.dialogMail)).getText().toString())
				.equals("")) {
			String[] recipients = { (((EditText) findViewById(R.id.dialogMail))
					.getText().toString()) };
			Intent email = new Intent(Intent.ACTION_SEND, Uri.parse("mailto:"));
			// prompts email clients only
			email.setType("message/rfc822");

			email.putExtra(Intent.EXTRA_EMAIL, recipients);
			email.putExtra(Intent.EXTRA_SUBJECT, "Password:");
			email.putExtra(Intent.EXTRA_TEXT, "Password");

			try {
				// the user can choose the email client
				startActivity(Intent.createChooser(email,
						"Choose an email client from..."));

			} catch (android.content.ActivityNotFoundException ex) {
				Toast.makeText(Forgot.this, "No email client installed.",
						Toast.LENGTH_LONG).show();
			}
		} else if (!(((EditText) findViewById(R.id.dialogphoneno)).getText()
				.toString()).equals("")) {
			SmsManager sms = SmsManager.getDefault();
			sms.sendTextMessage((((EditText) findViewById(R.id.dialogphoneno))
					.getText().toString()), null, "Password", null, null);
		} else {
			Toast.makeText(getApplicationContext(), "Empty Boxes...",
					Toast.LENGTH_LONG).show();
		}
	}

	public void SliderClick(View v) {

		switch (v.getId()) {
		case R.id.menu_item_1:
			startActivity(new Intent(getApplicationContext(), Profdiv.class));
			break;
		case R.id.menu_item_2:
			startActivity(new Intent(getApplicationContext(), LayerStack.class));
			break;
		case R.id.menu_item_3:
			startActivity(new Intent(getApplicationContext(), Members.class));
			break;
		case R.id.menu_item_4:
			startActivity(new Intent(getApplicationContext(), scrolltab.class));
			break;
		case R.id.menu_item_7:
			startActivity(new Intent(getApplicationContext(), NewsFeed.class));
			break;
		case R.id.menu_item_10:
			startActivity(new Intent(getApplicationContext(), Members.class));
			break;
		case R.id.menu_item_11:
			startActivity(new Intent(getApplicationContext(), Loginpage.class));
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
