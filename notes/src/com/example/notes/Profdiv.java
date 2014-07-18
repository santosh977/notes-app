package com.example.notes;

import java.io.FileNotFoundException;
import java.io.InputStream;

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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class Profdiv extends Activity {
	int count = 0;
	Button submit;
	Button edit;
	EditText name, colg, sem, email, branch;
	private final int sel_pic = 1;
	private ImageView prof;
	public static final String MyPREFERENCES = "MyPrefs";
	public static final String Name = "nameKey";
	public static final String Email = "emailKey";
	public static final String Branch = "brnchKey";
	public static final String Sem = "semKey";
	public static final String Colg = "colgKey";

	SharedPreferences sharedpreferences;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profdiv);

		prof = (ImageView) findViewById(R.id.imageView1);
		submit = (Button) findViewById(R.id.button1);
		edit = (Button) findViewById(R.id.button2);
		name = (EditText) findViewById(R.id.editText1);
		colg = (EditText) findViewById(R.id.editText2);
		email = (EditText) findViewById(R.id.editText3);
		sem = (EditText) findViewById(R.id.editText4);
		branch = (EditText) findViewById(R.id.editText5);

		sharedpreferences = getSharedPreferences(MyPREFERENCES,
				Context.MODE_PRIVATE);

		if (sharedpreferences.contains(Name)) {
			name.setText(sharedpreferences.getString(Name, ""));

		}
		if (sharedpreferences.contains(Branch)) {
			branch.setText(sharedpreferences.getString(Branch, ""));

		}
		if (sharedpreferences.contains(Email)) {
			email.setText(sharedpreferences.getString(Email, ""));

		}
		if (sharedpreferences.contains(Sem)) {
			sem.setText(sharedpreferences.getString(Sem, ""));

		}
		if (sharedpreferences.contains(Colg)) {
			colg.setText(sharedpreferences.getString(Colg, ""));

		}
		name.setEnabled(false);
		colg.setEnabled(false);
		email.setEnabled(false);
		sem.setEnabled(false);
		branch.setEnabled(false);

		edit.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				if (count == 0) {

					edit.setText("SAVE");
					name.setEnabled(true);
					colg.setEnabled(true);
					email.setEnabled(true);
					sem.setEnabled(true);
					branch.setEnabled(true);
					prof.setEnabled(true);
					// name.setSaveEnabled(true);
					prof.setOnClickListener(new OnClickListener() {

						@Override
						public void onClick(View arg0) {

							Intent photoPickerIntent = new Intent(
									Intent.ACTION_PICK);
							photoPickerIntent.setType("image/*");
							startActivityForResult(photoPickerIntent, sel_pic);

						}
					});
					// name.setSaveEnabled(true);
					count = 1;
				} else {

					edit.setText("Edit");
					name.setEnabled(false);
					colg.setEnabled(false);
					email.setEnabled(false);
					sem.setEnabled(false);
					branch.setEnabled(false);
					prof.setEnabled(false);

					String n = name.getText().toString();
					String ph = branch.getText().toString();
					String e = email.getText().toString();
					String s = sem.getText().toString();
					String p = colg.getText().toString();
					Editor editor = sharedpreferences.edit();
					editor.putString(Name, n);
					editor.putString(Branch, ph);
					editor.putString(Email, e);
					editor.putString(Sem, s);
					editor.putString(Colg, p);
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
				// finish();
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