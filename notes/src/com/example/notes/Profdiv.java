package com.example.notes;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;



public class Profdiv extends Activity {
	int count = 0;
	Button submit;
	Button edit;
	EditText name,  email;
	
	private SharedPreferences prefs;
	private String prefName = "spinner_value"; 
	int id=0;
	
	private final int sel_pic = 1;
	private ImageView prof;
	public static final String MyPREFERENCES = "MyPrefs";
	public static final String Name = "nameKey";
	public static final String Email = "emailKey";
	

	SharedPreferences sharedpreferences;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		final Spinner colg,sem,branch,year;
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profdiv);
		 prof = (ImageView) findViewById(R.id.imageView1);
		 submit = (Button) findViewById(R.id.button1);
	     edit = (Button) findViewById(R.id.button2);
		 name = (EditText) findViewById(R.id.editText1);
		 email = (EditText) findViewById(R.id.editText3);
			
		 colg=(Spinner) findViewById(R.id.spinner1);
		 sem=(Spinner) findViewById(R.id.spinner2);
		 branch=(Spinner) findViewById(R.id.spinner3);
		 year=(Spinner) findViewById(R.id.spinner4);
		final List<String> college=new ArrayList<String>();
		college.add("jecrc");
		college.add("mit");
		college.add("iit");
		college.add("jiet");
		college.add("nlu");
		final List<String> semester=new ArrayList<String>();
		 semester.add(" 1");
		 semester.add(" 2");
		 semester.add(" 3");
		 semester.add(" 4");
		 semester.add(" 5");
		final List<String> brnch=new ArrayList<String>();
		brnch.add("it");
		brnch.add("cse");
		brnch.add("me");
		brnch.add("eee 4");
		brnch.add("ece 5");
		final List<String> yr=new ArrayList<String>();
		yr.add(" 1");
		yr.add(" 2");
		yr.add(" 3");
		yr.add("4");
		yr.add(" 5");
	   
		sharedpreferences = getSharedPreferences(MyPREFERENCES,
				Context.MODE_PRIVATE);
		ArrayAdapter<String> list= new ArrayAdapter<String>(this,
        		android.R.layout.simple_list_item_1,college);
		list.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        colg.setAdapter(list);
        prefs = getSharedPreferences(prefName, MODE_PRIVATE);
        id=prefs.getInt("last_val",0);
        colg.setSelection(id);
       
        colg.setOnItemSelectedListener(new OnItemSelectedListener() {
 
		public void onItemSelected(AdapterView<?> arg0, View arg1,
				int pos, long arg3) {
			prefs = getSharedPreferences(prefName, MODE_PRIVATE);
			SharedPreferences.Editor editor = prefs.edit();
		
		
		 	editor.putInt("last_val", pos);
		    editor.commit();
		
			/*Toast.makeText(getBaseContext(), colg.getSelectedItem().toString(),
				Toast.LENGTH_SHORT).show();*/
		}
 
		public void onNothingSelected(AdapterView<?> arg0) {
				}
	});
        
        sharedpreferences = getSharedPreferences(MyPREFERENCES,
				Context.MODE_PRIVATE);
		ArrayAdapter<String> listt= new ArrayAdapter<String>(this,
        		android.R.layout.simple_list_item_1,brnch);
		listt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        branch.setAdapter(listt);
        prefs = getSharedPreferences(prefName, MODE_PRIVATE);
        id=prefs.getInt("last_val2",0);
        branch.setSelection(id);
       
        branch.setOnItemSelectedListener(new OnItemSelectedListener() {
 
		public void onItemSelected(AdapterView<?> arg0, View arg1,
				int pos, long arg3) {
			prefs = getSharedPreferences(prefName, MODE_PRIVATE);
			SharedPreferences.Editor editor = prefs.edit();
		
		
		 	editor.putInt("last_val2", pos);
		    editor.commit();
		
			/*Toast.makeText(getBaseContext(), branch.getSelectedItem().toString(),
				Toast.LENGTH_SHORT).show();*/
		}
 
		public void onNothingSelected(AdapterView<?> arg0) {
				}
	});
        
       
        sharedpreferences = getSharedPreferences(MyPREFERENCES,
				Context.MODE_PRIVATE);
		ArrayAdapter<String> list3= new ArrayAdapter<String>(this,
        		android.R.layout.simple_list_item_1,yr);
		list3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        year.setAdapter(list3);
        prefs = getSharedPreferences(prefName, MODE_PRIVATE);
        id=prefs.getInt("last_val3",0);
        year.setSelection(id);
       
        year.setOnItemSelectedListener(new OnItemSelectedListener() {
 
		public void onItemSelected(AdapterView<?> arg0, View arg1,
				int pos, long arg3) {
			prefs = getSharedPreferences(prefName, MODE_PRIVATE);
			SharedPreferences.Editor editor = prefs.edit();
		
		
		 	editor.putInt("last_val3", pos);
		    editor.commit();
		
			/*Toast.makeText(getBaseContext(), branch.getSelectedItem().toString(),
				Toast.LENGTH_SHORT).show();*/
		}
 
		public void onNothingSelected(AdapterView<?> arg0) {
				}
	});
        
       
        sharedpreferences = getSharedPreferences(MyPREFERENCES,
				Context.MODE_PRIVATE);
		ArrayAdapter<String> list4= new ArrayAdapter<String>(this,
        		android.R.layout.simple_list_item_1,semester);
		list4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sem.setAdapter(list4);
        prefs = getSharedPreferences(prefName, MODE_PRIVATE);
        id=prefs.getInt("last_val4",0);
        sem.setSelection(id);
       
        sem.setOnItemSelectedListener(new OnItemSelectedListener() {
 
		public void onItemSelected(AdapterView<?> arg0, View arg1,
				int pos, long arg3) {
			prefs = getSharedPreferences(prefName, MODE_PRIVATE);
			SharedPreferences.Editor editor = prefs.edit();
		
		
		 	editor.putInt("last_val4", pos);
		    editor.commit();
		
			/*Toast.makeText(getBaseContext(), branch.getSelectedItem().toString(),
				Toast.LENGTH_SHORT).show();*/
		}
 
		public void onNothingSelected(AdapterView<?> arg0) {
				}
	});
        
       
        
        
    
 
        if (sharedpreferences.contains(Name)) {
			name.setText(sharedpreferences.getString(Name, ""));

		}
	
		if (sharedpreferences.contains(Email)) {
			email.setText(sharedpreferences.getString(Email, ""));

		}
	
		name.setEnabled(false);
		email.setEnabled(false);
		colg.setEnabled(false);
		sem.setEnabled(false);
		branch.setEnabled(false);
		year.setEnabled(false);

		
		
		edit.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				if (count == 0) {

					edit.setText("SAVE");
					name.setEnabled(true);
					email.setEnabled(true);
					colg.setEnabled(true);
					sem.setEnabled(true);
					branch.setEnabled(true);
					year.setEnabled(true);
					
					prof.setEnabled(true);
					
					prof.setOnClickListener(new OnClickListener() {

						@Override
						public void onClick(View arg0) {

							
							Intent photoPickerIntent = new Intent(
									Intent.ACTION_PICK);
							photoPickerIntent.setType("image/*");
							startActivityForResult(photoPickerIntent, sel_pic);

						}
					});
					
					count = 1;
				} else {

					edit.setText("Edit");
					name.setEnabled(false);
					email.setEnabled(false);
					colg.setEnabled(false);
					sem.setEnabled(false);
					branch.setEnabled(false);
					year.setEnabled(false);

					
					prof.setEnabled(false);

					String n = name.getText().toString();
				
					String e = email.getText().toString();
					
					Editor editor = sharedpreferences.edit();
					editor.putString(Name, n);
					
					editor.putString(Email, e);
					
					editor.commit();

					count = 0;
				}
			}
		});
		submit.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
			
				Intent abc = new Intent(getApplicationContext(),
						Submitnotes.class);
				abc.putExtra("x", 1);
				startActivity(abc);
		
			}
		});

	}
	


	@Override
	protected void onActivityResult(int requestCode, int resultCode,
			Intent imageReturnedIntent) {
		super.onActivityResult(requestCode, resultCode, imageReturnedIntent);

		switch (requestCode) {
		case sel_pic:
			if (resultCode == RESULT_OK) {
				try {
					final Uri imageUri = imageReturnedIntent.getData();
					final InputStream imageStream = getContentResolver()
							.openInputStream(imageUri);
					final Bitmap selectedImage = BitmapFactory
							.decodeStream(imageStream);
					prof.setImageBitmap(selectedImage);

				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}

			}
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return true;
	}

}
