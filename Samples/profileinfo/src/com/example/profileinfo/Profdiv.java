package com.example.profileinfo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Profdiv extends Activity {
	int count=0;
	Button submit;
	Button edit;
	EditText name,colg,sem,email,branch;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profdiv);
		submit=(Button)findViewById(R.id.button1);
		edit=(Button)findViewById(R.id.button2);
		name=(EditText)findViewById(R.id.editText1);
		colg=(EditText)findViewById(R.id.editText2);
		email=(EditText)findViewById(R.id.editText3);
		sem=(EditText)findViewById(R.id.editText4);
		branch=(EditText)findViewById(R.id.editText5);
		
		name.setEnabled(false);
		colg.setEnabled(false);
		email.setEnabled(false);
		sem.setEnabled(false);
		branch.setEnabled(false);
		
		edit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(count==0)
				{
				
					name.setEnabled(true);
					colg.setEnabled(true);
					email.setEnabled(true);
					sem.setEnabled(true);
					branch.setEnabled(true);
					count=1;
				}
				else{
						name.setEnabled(false);
						colg.setEnabled(false);
						email.setEnabled(false);
						sem.setEnabled(false);
						branch.setEnabled(false);
						count=0;
				}}});
		submit.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0)
			{
				// TODO Auto-generated method stub
				Intent abc= new Intent(getApplicationContext(), Submitnotes.class);
				abc.putExtra("x", 1);
				startActivity(abc);
				finish();
			}
	   });
		
	}
	
 
@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.profdiv, menu);
		return true;
	}

}
