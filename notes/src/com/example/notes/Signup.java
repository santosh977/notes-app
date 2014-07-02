package com.example.notes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Signup extends Activity {
	//int i;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.signup);}
		public void Function1(View v) {
			startActivity(new Intent(Signup.this,Homepage.class));
			
		     }    
	}
		

