package com.devil.notes;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.util.Log;

/**
 * Async task class to get json by making HTTP call
 * */
public class QuickJSON extends AsyncTask<Void, Void, Void> {
	// boolean finished;
	String url;
	// private ProgressDialog pDialog;
	public String jsonStr;

	// Hashmap for ListView
	ArrayList<HashMap<String, String>> contactList;
	// JSON Node names
	public String TABLE_NAME = "study_users";
	// private static final String TAG_ID = "id";
	public String TAG1 = "name";
	/*
	 * private static final String TAG_EMAIL = "userid"; private static final
	 * String TAG_ADDRESS = "address"; private static final String TAG_GENDER =
	 * "gender"; private static final String TAG_PHONE = "phone"; private static
	 * final String TAG_PHONE_MOBILE = "mobile"; private static final String
	 * TAG_PHONE_HOME = "home"; private static final String TAG_PHONE_OFFICE =
	 * "office";
	 */
	// contacts JSONArray
	JSONArray contacts = null;

	public QuickJSON(String url_arg) {
		url = url_arg;
	}

	@Override
	protected void onPreExecute() {
		super.onPreExecute();
		// finished = false;
		// Showing progress dialog
		// pDialog = new ProgressDialog(Signup.this);
		// pDialog.setMessage("Please wait...");
		// pDialog.setCancelable(false);
		// pDialog.show();
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
				// JSONObject jsonObj = new
				// JSONObject(jsonStr.substring(jsonStr.indexOf("{"),
				// jsonStr.lastIndexOf("}") + 1));

				// contacts=new JSONArray(jsonStr);

				// Getting JSON Array node
				contacts = jsonObj.getJSONArray(TABLE_NAME);

				// looping through All Contacts
				for (int i = 0; i < contacts.length(); i++) {
					JSONObject c = contacts.getJSONObject(i);

					/* String id = c.getString(TAG_ID); */
					String name = c.getString(TAG1);
					// String email = c.getString(TAG_EMAIL);
					// String address = c.getString(TAG_ADDRESS);
					// String gender = c.getString(TAG_GENDER);

					// Phone node is JSON Object
					/*
					 * JSONObject phone = c.getJSONObject(TAG_PHONE); String
					 * mobile = phone.getString(TAG_PHONE_MOBILE); String home =
					 * phone.getString(TAG_PHONE_HOME); String office =
					 * phone.getString(TAG_PHONE_OFFICE);
					 */
					// tmp hashmap for single contact
					HashMap<String, String> contact = new HashMap<String, String>();

					// adding each child node to HashMap key => value
					// contact.put(TAG_ID, id);
					contact.put(TAG1, name);

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
		// if (pDialog.isShowing())
		// pDialog.dismiss();
		/**
		 * Updating parsed JSON data into ListView
		 * */
		/*
		 * Toast.makeText(Loginpage1.this, "Results are back....",
		 * Toast.LENGTH_LONG).show();
		 */
	}

}