package com.devil.notes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.style.TypefaceSpan;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Signup extends Action {
	// int i;
	Spinner s1, s2, s3, s4, s5, s6, s7, s8;
	String[] country = { "India", "Australia",

	};

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
	String[] semester = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.signup);
		// ---Spinner View---
		s4 = (Spinner) findViewById(R.id.spinner4);
		Typeface myCustomFont = Typeface.createFromAsset(getAssets(),
				"fonts/windsong.ttf");
		// TODO
		// s4.setTypeface(myCustomFont);
		ArrayAdapter<String> adapter7 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, mainstream);
		s4.setAdapter(adapter7);
		s4.setPrompt("Select a Main Stream");

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

		s7 = (Spinner) findViewById(R.id.spinner7);
		ArrayAdapter<String> adapter6 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, semester);
		s7.setAdapter(adapter6);
		s7.setPrompt("Select a Semester");

		s8 = (Spinner) findViewById(R.id.spinner8);
		ArrayAdapter<String> adapter8 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, country);
		s8.setAdapter(adapter8);
		s8.setPrompt("Select a Country");

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
			// DatabaseHandler db = new DatabaseHandler(this);
			/*
			 * public Users(String name, String branch, int year, int semester,
			 * String college, String city, String email, String password) {
			 */
			/*
			 * db.addContact(new Users(((EditText) findViewById(R.id.editText1))
			 * .getText().toString(), ((Spinner)
			 * findViewById(R.id.spinner5)).getSelectedItem() .toString(),
			 * Integer .parseInt((((Spinner) findViewById(R.id.spinner6))
			 * .getSelectedItem()).toString()), Integer .parseInt((((Spinner)
			 * findViewById(R.id.spinner7)) .getSelectedItem()).toString()),
			 * ((Spinner) findViewById(R.id.spinner3)).getSelectedItem()
			 * .toString(), ((Spinner)
			 * findViewById(R.id.spinner2)).getSelectedItem() .toString(),
			 * ((EditText) findViewById(R.id.editText2)).getText() .toString(),
			 * ((EditText) findViewById(R.id.editText9)).getText()
			 * .toString()));
			 */
			String urlquery = "http://wscubetech.org/app/appkit/signup.php";
			urlquery = new String(urlquery
					+ "?userid="
					+ ((EditText) findViewById(R.id.editText2)).getText()
							.toString()
					+ "&password="
					+ ((EditText) findViewById(R.id.editText9)).getText()
							.toString())
					+ "&username="
					+ ((EditText) findViewById(R.id.editText1)).getText()
							.toString()
					+ "&year="
					+ Integer.parseInt((((Spinner) findViewById(R.id.spinner6))
							.getSelectedItem()).toString())
					+ "&semester="
					+ Integer.parseInt((((Spinner) findViewById(R.id.spinner7))
							.getSelectedItem()).toString())
					+ "&college="
					+ ((Spinner) findViewById(R.id.spinner3)).getSelectedItem()
							.toString()
					+ "&city="
					+ ((Spinner) findViewById(R.id.spinner2)).getSelectedItem()
							.toString()
					+ "&state="
					+ ((Spinner) findViewById(R.id.spinner1)).getSelectedItem()
							.toString()
					+ "&branch="
					+ ((Spinner) findViewById(R.id.spinner5)).getSelectedItem()
							.toString()
					+ "&country="
					+ ((Spinner) findViewById(R.id.spinner8)).getSelectedItem()
							.toString();

			QuickJSON jsonResult = new QuickJSON(urlquery);
			jsonResult.execute();
			/*
			 * Thread timer = new Thread() { public boolean finished=false;
			 * public void run() { try { sleep(3000);
			 * 
			 * } catch (Exception e) { e.printStackTrace(); } finally {
			 * finished=true; } } }; timer.start(); while(timer){}
			 * Toast.makeText(getApplicationContext(), jsonResult.jsonStr,
			 * Toast.LENGTH_LONG).show();
			 */startActivity(new Intent(Signup.this, LayerStack.class));
			finish();

		} else {

			Toast toast = new Toast(this);
			toast.setDuration(Toast.LENGTH_LONG);
			toast.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);

			LayoutInflater inflater = getLayoutInflater();
			View apperance = inflater.inflate(R.layout.errortoast,
					(ViewGroup) findViewById(R.id.root));
			toast.setView(apperance);
			toast.show();
			/*
			 * Toast.makeText(getApplicationContext(),
			 * "Confirm and the normal one are not twins.",
			 * Toast.LENGTH_LONG).show();
			 */
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

	public boolean onOptionsItemSelected(MenuItem item) {
		return super.onOptionsItemSelected(item);
	}
}
