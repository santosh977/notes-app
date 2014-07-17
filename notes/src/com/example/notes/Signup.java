package com.example.notes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Signup extends Activity {
	// int i;
	Spinner s1, s2, s3, s4, s5, s6, s7;

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
	String[] semester = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",

	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.signup);
		// ---Spinner View---
		s4 = (Spinner) findViewById(R.id.spinner4);
		ArrayAdapter<String> adapter7 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, mainstream);
		s4.setAdapter(adapter7);

		s4.setOnItemSelectedListener(new OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// int index = s4.getSelectedItemPosition();
				/*
				 * Toast.makeText(getBaseContext(), "You have selected item : "
				 * + mainstream[index], Toast.LENGTH_SHORT).show();
				 */
			}

			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});

		s1 = (Spinner) findViewById(R.id.spinner1);
		ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, state);
		s1.setAdapter(adapter2);

		s1.setOnItemSelectedListener(new OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// int index = s1.getSelectedItemPosition();
				/*
				 * Toast.makeText(getBaseContext(), "You have selected item : "
				 * + state[index], Toast.LENGTH_SHORT).show();
				 */
			}

			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});
		s2 = (Spinner) findViewById(R.id.spinner2);
		ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, city);
		s2.setAdapter(adapter3);

		s2.setOnItemSelectedListener(new OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// int index = s2.getSelectedItemPosition();
				/*
				 * Toast.makeText(getBaseContext(), "You have selected item : "
				 * + city[index], Toast.LENGTH_SHORT).show();
				 */
			}

			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});
		s3 = (Spinner) findViewById(R.id.spinner3);
		ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, collagename);
		s3.setAdapter(adapter1);

		s3.setOnItemSelectedListener(new OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// int index = s3.getSelectedItemPosition();
				/*
				 * Toast.makeText(getBaseContext(), "You have selected item : "
				 * + collagename[index], Toast.LENGTH_SHORT).show();
				 */
			}

			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});

		s5 = (Spinner) findViewById(R.id.spinner5);
		ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, branch);
		s5.setAdapter(adapter4);

		s5.setOnItemSelectedListener(new OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// int index = s5.getSelectedItemPosition();
				/*
				 * Toast.makeText(getBaseContext(), "You have selected item : "
				 * + branch[index], Toast.LENGTH_SHORT).show();
				 */
			}

			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});
		s6 = (Spinner) findViewById(R.id.spinner6);
		ArrayAdapter<String> adapter5 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, year);
		s6.setAdapter(adapter5);

		s6.setOnItemSelectedListener(new OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// int index = s6.getSelectedItemPosition();
				/*
				 * Toast.makeText(getBaseContext(), "You have selected item : "
				 * + year[index], Toast.LENGTH_SHORT).show();
				 */
			}

			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});
		s7 = (Spinner) findViewById(R.id.spinner7);
		ArrayAdapter<String> adapter6 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, semester);
		s7.setAdapter(adapter6);

		s7.setOnItemSelectedListener(new OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// int index = s7.getSelectedItemPosition();
				/*
				 * Toast.makeText(getBaseContext(), "You have selected item : "
				 * + semester[index], Toast.LENGTH_SHORT).show();
				 */
			}

			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});

	}

	// Hashmap for ListView
	ArrayList<HashMap<String, String>> contactList;

	/**
	 * Async task class to get json by making HTTP call
	 * */
	private class GetContacts extends AsyncTask<Void, Void, Void> {
		// boolean finished;
		String url;
		private ProgressDialog pDialog;
		String jsonStr;

		// JSON Node names
		private static final String TAG_CONTACTS = "Tstudy_users";
		// private static final String TAG_ID = "id";
		private static final String TAG_NAME = "name";
		/*
		 * private static final String TAG_EMAIL = "userid"; private static
		 * final String TAG_ADDRESS = "address"; private static final String
		 * TAG_GENDER = "gender"; private static final String TAG_PHONE =
		 * "phone"; private static final String TAG_PHONE_MOBILE = "mobile";
		 * private static final String TAG_PHONE_HOME = "home"; private static
		 * final String TAG_PHONE_OFFICE = "office";
		 */
		// contacts JSONArray
		JSONArray contacts = null;

		public GetContacts(String url_arg) {
			url = url_arg;
		}

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			// finished = false;
			// Showing progress dialog
			pDialog = new ProgressDialog(Signup.this);
			pDialog.setMessage("Please wait...");
			// pDialog.setCancelable(false);
			pDialog.show();
			// finally finished();

		}

		@Override
		protected Void doInBackground(Void... arg0) {
			// Creating service handler class instance
			ServiceHandler sh = new ServiceHandler();

			// Making a request to url and getting response
			jsonStr = sh.makeServiceCall(url, ServiceHandler.GET);

			Log.d("Response: ", "> " + jsonStr);

			if (jsonStr != null) {
				try {
					JSONObject jsonObj = new JSONObject(jsonStr);

					// contacts=new JSONArray(jsonStr);

					// Getting JSON Array node
					contacts = jsonObj.getJSONArray(TAG_CONTACTS);

					// looping through All Contacts
					for (int i = 0; i < contacts.length(); i++) {
						JSONObject c = contacts.getJSONObject(i);

						/* String id = c.getString(TAG_ID); */
						String name = c.getString(TAG_NAME);
						// String email = c.getString(TAG_EMAIL);
						// String address = c.getString(TAG_ADDRESS);
						// String gender = c.getString(TAG_GENDER);

						// Phone node is JSON Object
						/*
						 * JSONObject phone = c.getJSONObject(TAG_PHONE); String
						 * mobile = phone.getString(TAG_PHONE_MOBILE); String
						 * home = phone.getString(TAG_PHONE_HOME); String office
						 * = phone.getString(TAG_PHONE_OFFICE);
						 */
						// tmp hashmap for single contact
						HashMap<String, String> contact = new HashMap<String, String>();

						// adding each child node to HashMap key => value
						// contact.put(TAG_ID, id);
						contact.put(TAG_NAME, name);

						// contact.put(TAG_EMAIL, email);
						// contact.put(TAG_PHONE_MOBILE, mobile);

						// adding contact to contact list
						contactList.add(contact);
					}
				} catch (JSONException e) {
					e.printStackTrace();
				}
			} else {
				Log.e("ServiceHandler", "Couldn't get any data from the url");
			}

			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			super.onPostExecute(result);
			// finished = true;
			// Dismiss the progress dialog
			if (pDialog.isShowing())
				pDialog.dismiss();
			/**
			 * Updating parsed JSON data into ListView
			 * */
			/*
			 * Toast.makeText(Loginpage1.this, "Results are back....",
			 * Toast.LENGTH_LONG).show();
			 */
			startActivity(new Intent(Signup.this, LayerStack.class));
			finish();
		}

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
							.toString();

			GetContacts jsonResult = new GetContacts(urlquery);
			jsonResult.execute();

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
