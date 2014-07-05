package com.example.notes;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class Members extends Activity {
TextView tv;
String names;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.members);
		names=  "\n Santosh" +
				"\n Divyavrat" +
				"\n Nikhar" +
				"\n Gunnu" +
				"\n forgot_the_name" +
				"\n Sapna";
		tv=(TextView)findViewById(R.id.textView1);
		tv.setText(names);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.members, menu);
		return true;
	}

}
