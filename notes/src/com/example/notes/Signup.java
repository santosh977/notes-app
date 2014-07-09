package com.example.notes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Signup extends Activity {
	// int i;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.signup);
	}

	public void Function2(View v) {
		// Toast.makeText(getApplicationContext(),((EditText)findViewById(R.id.editText9)).getText().toString(),
		// Toast.LENGTH_LONG).show();
		if (!isValidPassword(((EditText) findViewById(R.id.editText9))
				.getText().toString())) {
			Toast.makeText(getApplicationContext(),
					"Password is not length-correct.", Toast.LENGTH_LONG)
					.show();
		} else if (!isValidEmail(((EditText) findViewById(R.id.editText2))
				.getText().toString())) {
			Toast.makeText(getApplicationContext(),
					"Email is no-good. (something@something.com)",
					Toast.LENGTH_LONG).show();
		} else if (((EditText) findViewById(R.id.editText9))
				.getText()
				.toString()
				.equals(((EditText) findViewById(R.id.editText10)).getText()
						.toString())) {
			DatabaseHandler db = new DatabaseHandler(this);
			db.addContact(new Users(((EditText) findViewById(R.id.editText1))
					.getText().toString(),
					((EditText) findViewById(R.id.editText6)).getText()
							.toString(),
					Integer.parseInt((((EditText) findViewById(R.id.editText7))
							.getText()).toString()),
					Integer.parseInt((((EditText) findViewById(R.id.editText8))
							.getText()).toString()),
					((EditText) findViewById(R.id.editText3)).getText()
							.toString(),
					((EditText) findViewById(R.id.editText5)).getText()
							.toString(),
					((EditText) findViewById(R.id.editText2)).getText()
							.toString(),
					((EditText) findViewById(R.id.editText9)).getText()
							.toString()));
			startActivity(new Intent(Signup.this, Homepage1.class));
			finish();
		} else {
			Toast.makeText(getApplicationContext(),
					"Confirm and the normal one are not twins.",
					Toast.LENGTH_LONG).show();
		}
	}

	// validating email id
	private boolean isValidEmail(String email) {
		String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}

	// validating password with retype password
	private boolean isValidPassword(String pass) {
		if (pass != null && pass.length() >= 8 && pass.length() <= 20) {
			return true;
		}
		return false;
	}
}
