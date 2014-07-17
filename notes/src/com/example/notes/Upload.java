package com.example.notes;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Upload extends Activity {
	Spinner s1, s2, s3, s4, s5, s6;

	String[] mainstream = { "Engineering", "MBA",

	};
	String[] state = { "raj", "jharkhand", "gujrat", "dehli",

	};
	String[] city = { "jodhpur", "jaipur", "kota", "surat", "ranchi",

	};
	String[] collagename = { "mbm", "iit", "nlu", "jnu",

	};

	String[] branch = { "it", "cse", "me", "ece", "eee",

	};
	String[] year = { "1", "2", "3", "4", "5",

	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.upload);

		// ---Spinner View---
		s4 = (Spinner) findViewById(R.id.spinner4);
		ArrayAdapter<String> adapter7 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, mainstream);
		s4.setAdapter(adapter7);

		s1 = (Spinner) findViewById(R.id.spinner1);
		ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, state);
		s1.setAdapter(adapter2);
		s1.setPrompt("Select a State");

		s2 = (Spinner) findViewById(R.id.spinner2);

		ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, city);
		s2.setAdapter(adapter3);
		s2.setPrompt("Select a City");

		s3 = (Spinner) findViewById(R.id.spinner3);
		ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, collagename);
		s3.setAdapter(adapter1);
		s3.setPrompt("Select a College");

		s5 = (Spinner) findViewById(R.id.spinner5);
		ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, branch);
		s5.setAdapter(adapter4);
		s5.setPrompt("Select a Branch");

		s6 = (Spinner) findViewById(R.id.spinner6);
		ArrayAdapter<String> adapter5 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, year);
		s6.setAdapter(adapter5);
		s6.setPrompt("Select a Year");

	}

	/*
	 * if (((EditText) findViewById(R.id.editText1)) .getText() .toString()
	 * .equals(((EditText) findViewById(R.id.editText2)).getText() .toString()))
	 */
	/*
	 * { DatabaseHandler db = new DatabaseHandler(this); db.addContact(new
	 * Users(((EditText) findViewById(R.id.editText1)) .getText().toString(),
	 * ((Spinner) findViewById(R.id.spinner5)).getSelectedItem() .toString(),
	 * Integer .parseInt((((Spinner) findViewById(R.id.spinner6))
	 * .getSelectedItem()).toString()), Integer .parseInt((((Spinner)
	 * findViewById(R.id.spinner1)) .getSelectedItem()).toString()), ((Spinner)
	 * findViewById(R.id.spinner3)).getSelectedItem() .toString(), ((Spinner)
	 * findViewById(R.id.spinner2)).getSelectedItem() .toString(), ((EditText)
	 * findViewById(R.id.textView1)).getText() .toString(), ((EditText)
	 * findViewById(R.id.editText9)).getText() .toString()));
	 * 
	 * startActivity(new Intent(Upload.this,Profdiv.class)); finish(); }}
	 */

	@SuppressLint("NewApi")
	public void Clik(View view) {
		Intent pickerIntent = new Intent(Intent.ACTION_ATTACH_DATA);
		pickerIntent.setTypeAndNormalize(INPUT_SERVICE);

		/*
		 * Intent intent = new
		 * Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE); File file =
		 * new File(Environment.getExternalStorageDirectory(), "MyPhoto.jpg");
		 * outputFileUri = Uri.fromFile(file);
		 * intent.putExtra(MediaStore.EXTRA_OUTPUT, outputFileUri);
		 * startActivityForResult(intent, TAKE_PICTURE); }
		 * 
		 * // TODO Auto-generated method stub Intent photoPickerIntent = new
		 * Intent( Intent.ACTION_PICK); photoPickerIntent.setType("image/*");
		 * startActivityForResult(photoPickerIntent, sel_pic);
		 */

	}
}
