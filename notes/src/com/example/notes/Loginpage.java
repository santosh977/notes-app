package com.example.notes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher.ViewFactory;

public class Loginpage extends Activity {
	ImageSwitcher is;

	Button btnbk, btnfr, b, b1,btnn2;
	Animation in, out;

	// ,btnStart,btnStop

	private static final int[] imageIDs = { R.drawable.asquz, R.drawable.tnp1,
			R.drawable.bns, R.drawable.newsfeed, R.drawable.clg12,
			R.drawable.cht,

	};
	int len = imageIDs.length;
	int indexCount = -1;

	Handler handle = new Handler();

	Runnable r = new Runnable() {

		@Override
		public void run() {
			try {
				indexCount++;
				if (indexCount == len) {
					indexCount = 0;

				}

				is.setBackgroundResource(imageIDs[indexCount]);

			} finally {
				handle.postDelayed(this, 1000);
			}

		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.loginpage);

		is = (ImageSwitcher) findViewById(R.id.is);
		// btnPrev=(Button)findViewById(R.id.btnPrev);
		// btnNext=(Button)findViewById(R.id.btnNext);
		// btnStart=(Button)findViewById(R.id.btnStart);
		// btnStop=(Button)findViewById(R.id.btnStop);
		btnbk = (Button) findViewById(R.id.btnbk);
		btnfr = (Button) findViewById(R.id.btnfr);
		b = (Button) findViewById(R.id.BtnLogin);
		b1 = (Button) findViewById(R.id.BtnSignup);
		btnn2 = (Button) findViewById(R.id.btnn2);
		
		b.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(Loginpage.this, Loginpage1.class));
			}
		});

		btnn2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(Loginpage.this, LayerStack.class));

			}
		});
       
		
		
		b1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(Loginpage.this, Signup.class));

			}
		});
		((Button) findViewById(R.id.button1))
				.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View arg0) {

						startActivity(new Intent(Loginpage.this,
								NotesActivity.class));
					}
				});
		/*
		 * btnbk.setBackgroundResource(R.drawable.bkarrow);
		 * btnfr.setBackgroundResource(R.drawable.arrow);
		 */
		is.setFactory(new ViewFactory() {

			@Override
			public View makeView() {
				ImageView iv = new ImageView(getApplicationContext());

				return iv;
			}
		});

		in = AnimationUtils.loadAnimation(getApplicationContext(),
				android.R.anim.slide_in_left);
		out = AnimationUtils.loadAnimation(getApplicationContext(),
				android.R.anim.slide_out_right);
		is.setInAnimation(in);
		is.setOutAnimation(out);
		is.setBackgroundResource(imageIDs[0]);
		handle.postDelayed(r, 1000);

		/*
		 * btnStart.setOnClickListener(new OnClickListener() {
		 * 
		 * 
		 * 
		 * 
		 * @Override public void onClick(View arg0) { handle.postDelayed(r,
		 * 4000);
		 * 
		 * } });
		 * 
		 * 
		 * 
		 * btnStop.setOnClickListener(new OnClickListener() {
		 * 
		 * @Override public void onClick(View arg0) { handle.removeCallbacks(r);
		 * 
		 * } });
		 */
		
		btnfr.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				indexCount++;
				if (indexCount == len)
					indexCount = 0;

				is.setBackgroundResource(imageIDs[indexCount]);

			}
		});

		btnbk.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				if (indexCount > 0)
					indexCount--;
				else
					indexCount = (len - 1);

				is.setBackgroundResource(imageIDs[indexCount]);

			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	public void Fun(View v) {
		startActivity(new Intent(Loginpage.this, Clges.class));

	}
}

/*
 * @Override protected void onCreate(Bundle savedInstanceState) {
 * super.onCreate(savedInstanceState); setContentView(R.layout.loginpage);}
 */
/*
 * public void Function1(View v) { startActivity(new
 * Intent(Loginpage.this,Homepage1.class)); } public void onClick(View v) {
 * startActivity(new Intent(Loginpage.this,Signup.class));
 * 
 * }
 */
/*
 * public void imageSelect(View v) { switch(v.getId()) { case R.id.imageView0:
 * startActivity(new Intent(getApplicationContext(),NotesActivity.class));
 * break; case R.id.imageView2: startActivity(new
 * Intent(getApplicationContext(),Members.class)); break;
 * default:Toast.makeText(getApplicationContext(),
 * "TODO",Toast.LENGTH_LONG).show(); } }
 */

// }

/*
 * Button b=(Button)findViewById(R.id.button1); Button
 * b1=(Button)findViewById(R.id.button2);} public void Function1(View v) {
 * startActivity(new Intent(Loginpage.this,Homepage.class));} //}
 * b.setOnClickListener(new OnClickListener() {
 * 
 * @Override public void onClick(View v) { startActivity(new
 * Intent(Loginpage.this,Homepage.class));
 * 
 * } }); }
 */

