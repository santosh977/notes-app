package com.example.notes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Loginpage1 extends Activity {
	View rootView;
	String editMailString = "";
	String editpassString = "";
	String dialogMailString = "";
	private EditText email, pass;
	Button login;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.loginpage1);
	}

	public void Function8(View v) {
		boolean founduser = false;
		email = (EditText) findViewById(R.id.EditMail);
		pass = (EditText) findViewById(R.id.Editpass);
		login = (Button) findViewById(R.id.BtnLogin);
		DatabaseHandler db = new DatabaseHandler(this);
		List<Users> users = db.getAllContacts();
		final String Email = email.getText().toString();
		final String Pass = pass.getText().toString();
		if (!isValidEmail(Email)) {
			email.setError("Invalid Email");
		}
		if (!isValidPassword(Pass)) {
			pass.setError("Invalid Password");
		} else {
			for (Users cn : users) {
				// String log = "\n\n Name: " + cn.getName() + " ,Password: " +
				// cn.getPassword();
				// Writing Contacts to log
				// Log.d("Name: ", log);
				if (cn.getPassword().equals(
						(((EditText) findViewById(R.id.Editpass)).getText())
								.toString())
						&& cn.getEmail().equals(
								(((EditText) findViewById(R.id.EditMail))
										.getText()).toString())) {
					founduser = true;
					Intent abc = new Intent(getApplicationContext(),
							Homepage1.class);
					abc.putExtra("x", 1);
					startActivity(abc);
					finish();
				}
			}
			if (!founduser)
				Toast.makeText(getApplicationContext(),
						"Wrong Email or Password", Toast.LENGTH_LONG).show();
			// finish();
		}

		// Toast.makeText(getApplicationContext(),(((EditText)findViewById(R.id.Editpass)).getText()).toString(),
		// Toast.LENGTH_LONG).show();

	}

	public void Function9(View v) {
		startActivity(new Intent(Loginpage1.this, Signup.class));

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
