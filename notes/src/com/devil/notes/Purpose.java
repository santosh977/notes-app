package com.devil.notes;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.TextureView;

public class Purpose extends Action {
     TextureView tv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_purpose);
		/*TextView tv = (TextView) findViewById(R.id.textView1);
		Typeface face = Typeface.createFromAsset(getAssets(),
		            "fonts/epimodem.ttf");
		tv.setTypeface(face);
*/
	}
	public boolean onOptionsItemSelected(MenuItem item)
    {   return super.onOptionsItemSelected(item);  
    }  
}
