package com.devil.notes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class Loginpage1 extends Action{
	// View rootView;
	// String editMailString = "";
	// String editpassString = "";
	// String dialogMailString = "";
	private EditText email, pass;
	Button login;

	// private static String url = "http://api.androidhive.info/contacts/";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.loginpage1);
		CheckBox checkBox = (CheckBox) findViewById(R.id.chkAutosave);
		checkBox.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				if (((CheckBox) v).isChecked())
					Toast.makeText(getBaseContext(), "CheckBox is checked",
							Toast.LENGTH_LONG).show();
				else
					Toast.makeText(getBaseContext(), "CheckBox is unchecked",
							Toast.LENGTH_LONG).show();
			}
		});
		// new GetContacts().execute();
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
		private static final String TAG_CONTACTS = "study_users";
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
			pDialog = new ProgressDialog(Loginpage1.this);
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
			ResultGet();
		}

	}

	public void ResultGet() {
		HashMap<String, String> contact = new HashMap<String, String>();
		if (contactList.size() == 0) {
			Toast.makeText(getApplicationContext(),
					"Wrong Data or Server error.", Toast.LENGTH_LONG).show();
			return;
		}
		contact = contactList.get(0);
		if (contact.get("name").equals("null")) {
			Toast.makeText(getApplicationContext(), "Wrong Email or Password",
					Toast.LENGTH_LONG).show();
		} else {

			Intent abc = new Intent(getApplicationContext(), LayerStack.class);
			abc.putExtra("x", 1);
			startActivity(abc);
			finish();
		}
	}

	public void Function8(View v) {

		email = (EditText) findViewById(R.id.EditMail);
		pass = (EditText) findViewById(R.id.Editpass);
		login = (Button) findViewById(R.id.BtnLogin);
		// DatabaseHandler db = new DatabaseHandler(this);
		// List<Users> users = db.getAllContacts();
		final String Email = email.getText().toString();
		final String Pass = pass.getText().toString();

		if (!isValidEmail(Email)) {
			email.setError("Invalid Email");
			return;
		}
		if (!isValidPassword(Pass)) {
			pass.setError("Invalid Password");
			return;
		}
		// String log = "\n\n Name: " + cn.getName() + " ,Password: " +
		// cn.getPassword();
		// Writing Contacts to log
		// Log.d("Name: ", log);
		contactList = new ArrayList<HashMap<String, String>>();
		// Calling async task to get json
		String urlquery = "http://wscubetech.org/app/appkit/login.php";
		urlquery = new String(
				urlquery
						+ "?userid="
						+ (((EditText) findViewById(R.id.EditMail)).getText())
								.toString()
						+ "&upass="
						+ (((EditText) findViewById(R.id.Editpass)).getText())
								.toString());

		GetContacts jsonResult = new GetContacts(urlquery);
		jsonResult.execute();

		// while(!jsonResult.finished){}
		// ResultGet();
	}

	// Toast.makeText(getApplicationContext(),(((EditText)findViewById(R.id.Editpass)).getText()).toString(),
	// Toast.LENGTH_LONG).show();

	public void Function9(View v) {
		startActivity(new Intent(Loginpage1.this, Signup.class));
		finish();
	}

	public void Function10(View v) {
		startActivity(new Intent(Loginpage1.this, Forgot.class));

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

		/*
		 * if (true) return true;
		 */
		if (pass != null && pass.length() >= 8 && pass.length() <= 20) {
			return true;
		}
		return false;
	}
	 /*@Override
	 public boolean onCreateOptionsMenu(Menu menu) {
	  getMenuInflater().inflate(R.menu.main, menu);
	  return true;
	 }
	 @Override
	 public boolean onOptionsItemSelected(MenuItem item) {

	  
	   return super.onOptionsItemSelected(item);
	 }*/
	 public boolean onOptionsItemSelected(MenuItem item)
	    {   return super.onOptionsItemSelected(item);  
	    }    
}
