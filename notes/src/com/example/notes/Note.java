package com.example.notes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Note extends Activity {
	//int i;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.note);}
	public void Search(View v) {
		startActivity(new Intent(Note.this,Search.class));
		
	     }
	public void Upload(View v) {
		startActivity(new Intent(Note.this,Upload.class));
		
	     }
	public void Switchprofile(View v) {
		startActivity(new Intent(Note.this,Profdiv.class));
		
	     }
	
		     }    
	
		
