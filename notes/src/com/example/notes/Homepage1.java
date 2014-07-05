package com.example.notes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class  Homepage1 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.homepage1);}
		public void Function5(View v) {
			startActivity(new Intent(Homepage1.this,Note.class));
			
		     }
		
     }

	


