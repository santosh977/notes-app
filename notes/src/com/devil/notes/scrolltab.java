package com.devil.notes;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

class PicNote {

	PicNote(String image2, int id2) {
		imgname = image2;
		id = id2;
		downloadstatus = 0;
	}

	public String getImgname() {
		return imgname;
	}

	public void setImgname(String imgname) {
		this.imgname = imgname;
	}

	String imgname;
	int id;
	int downloadstatus;

	/*
	 * 0=unknown 1=queued to download 2=error in downloading 3=downloaded
	 */

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}

@SuppressWarnings("deprecation")
public class scrolltab extends TabActivity implements TabHost.TabContentFactory {

	TextView txt;
	TextView txtcount;
	TextView timebox;
	// int count=0;
	ImageView img;
	/* Button btn; */

	ArrayList<String> Heading = new ArrayList<String>();
	ArrayList<String> TextData = new ArrayList<String>();
	ArrayList<String> Time = new ArrayList<String>();
	ArrayList<Integer> arr2 = new ArrayList<Integer>();
	ArrayList<PicNote> arr_pics = new ArrayList<PicNote>();
	IconicAdapter iconic_notes;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.scrolltab);

		Heading.add(">> Add a Note <<");
		TextData.add("Try tapping :)");
		Time.add("Tap It !!");
		/*
		 * NotesDatabaseHandler db = new NotesDatabaseHandler(
		 * getApplicationContext()); List<NotesData> users =
		 * db.getAllContacts(); for (NotesData cn : users) {
		 * arr.add(cn.getName()); arr1.add(cn.getNotes()); }
		 */

		contactList = new ArrayList<HashMap<String, String>>();
		// Calling async task to get json
		String urlquery = "http://wscubetech.org/app/appkit/download.php";
		urlquery = new String(urlquery);

		GetContacts jsonResult = new GetContacts(urlquery);
		jsonResult.execute();

		// arr.add(">>Delete<<");
		arr2.add(R.drawable.add);
		arr2.add(R.drawable.textnote);

		final TabHost tabHost = getTabHost();
		/*
		 * for (int i=1; i <= 6; i++) { String name = "Tab " + i;
		 * tabHost.addTab(tabHost.newTabSpec(name) .setIndicator(name)
		 * .setContent(this));}
		 */

		String TabName;
		TabName = new String("Notes");
		tabHost.addTab(tabHost.newTabSpec(TabName).setIndicator(TabName)
				.setContent(this));
		TabName = new String("Assignments");
		tabHost.addTab(tabHost.newTabSpec(TabName).setIndicator(TabName)
				.setContent(this));
		TabName = new String("Quizzes");
		tabHost.addTab(tabHost.newTabSpec(TabName).setIndicator(TabName)
				.setContent(this));
		TabName = new String("Projects");
		tabHost.addTab(tabHost.newTabSpec(TabName).setIndicator(TabName)
				.setContent(this));
	}

	// Hashmap for ListView
	ArrayList<HashMap<String, String>> contactList;

	/**
	 * Async task class to get json by making HTTP call
	 * */
	private class GetContacts extends AsyncTask<Void, Void, Void> {
		// boolean finished;
		String url;
		// private ProgressDialog pDialog;
		String jsonStr;

		// JSON Node names
		private static final String TAG_CONTACTS = "study_material";
		// private static final String TAG_ID = "id";
		private static final String TAG_NAME = "sm_file";
		private static final String TAG_TIME = "sm_datetime";
		/*
		 * private static final String TAG_ADDRESS = "address"; private static
		 * final String TAG_GENDER = "gender"; private static final String
		 * TAG_PHONE = "phone"; private static final String TAG_PHONE_MOBILE =
		 * "mobile"; private static final String TAG_PHONE_HOME = "home";
		 * private static final String TAG_PHONE_OFFICE = "office";
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
			// pDialog = new ProgressDialog(scrolltab.this);
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

					// contacts=new JSONArray(jsonStr);

					// Getting JSON Array node
					contacts = jsonObj.getJSONArray(TAG_CONTACTS);

					// looping through All Contacts
					for (int i = 0; i < contacts.length(); i++) {
						JSONObject c = contacts.getJSONObject(i);
						String name = c.getString(TAG_NAME);
						Time.add(c.getString(TAG_TIME));
						/* String id = c.getString(TAG_ID); */
						if (c.getString("sm_type").equals("raw")) {
							Heading.add("raw");
							TextData.add(name);

						} else if (c.getString("sm_type").equals("pic")) {
							Heading.add("Picture");
							TextData.add(name);
							// byte[] completeImage;
							// completeImage=
							// Base64.decode(name,Base64.DEFAULT);
							// Bitmap bitmap =
							// BitmapFactory.decodeByteArray(completeImage , 0,
							// completeImage.length);
							arr_pics.add(new PicNote(name, i -1));

						}
						// tmp hashmap for single contact
						HashMap<String, String> contact = new HashMap<String, String>();

						// adding each child node to HashMap key => value
						// contact.put(TAG_ID, id);
						contact.put(TAG_NAME, name);

						// contact.put(TAG_EMAIL, email);
						// contact.put(TAG_PHONE_MOBILE, mobile);

						// adding contact to contact list
						contactList.add(contact);

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
			 * Toast.makeText(scrolltab.this, "Results are back....",
			 * Toast.LENGTH_LONG).show();
			 */

			ResultGet();
			iconic_notes.notifyDataSetChanged();
		}

	}

	public void ResultGet() {
		// HashMap<String, String> contact = new HashMap<String, String>();
		if (contactList.size() == 0) {
			Toast.makeText(getApplicationContext(),
					"Wrong Data or Server error.", Toast.LENGTH_LONG).show();

			return;
		}
	}

	public View createTabContent(String tag) {

		// switch(Integer.parseInt(tag.substring(4,tag.length())))
		if (tag.equals("Notes")) {
			ListView lv;
			lv = (ListView) findViewById(R.id.listView1);
			iconic_notes = new IconicAdapter(this);
			lv.setAdapter(iconic_notes);
			return lv;
		}/*
		 * else if (tag.equals("Search")) { startActivity(new
		 * Intent(getApplicationContext(), Search.class)); finish(); final
		 * TextView tv = new TextView(this); tv.setText(tag + " is Loading...");
		 * // lv.setAdapter(null); return tv; }
		 */
		// break;
		else {
			final TextView tv = new TextView(this);
			tv.setText("Content for tab with tag " + tag);
			// lv.setAdapter(null);
			return tv;
			// break;
		}

	}

	private class IconicAdapter extends ArrayAdapter<String> {

		Downld thumbdn;
		Context c;

		public IconicAdapter(Context context) {
			super(context, R.layout.list, R.id.textView1, Heading);
			c = context;
		}

		public View getView(int position, View view, ViewGroup parent) {
			View list = super.getView(position, view, parent);

			img = (ImageView) list.findViewById(R.id.imageView1);
			txt = (TextView) list.findViewById(R.id.textView2);
			txtcount = (TextView) list.findViewById(R.id.textView3);
			timebox = (TextView) list.findViewById(R.id.textView7);
			// btn = (Button) list.findViewById(R.id.button1);

			// txtcount.setText(String.valueOf(count));
			txtcount.setText(String.valueOf(position));
			txt.setText(TextData.get(position));
			timebox.setText(Time.get(position));
			// count++;
			if (position == 0) {
				img.setImageDrawable(getResources().getDrawable(arr2.get(0)));
				// btn.setText("Add");
				// btn.setVisibility(View.INVISIBLE);
			} else {
				int i;
				boolean found_id = false;
				for (i = 0; i < arr_pics.size(); i++) {
					if (position == arr_pics.get(i).getId()) {
						found_id = true;
						break;
					}
				}

				if (!found_id)
					img.setImageDrawable(getResources()
							.getDrawable(arr2.get(1)));

				else {
					String fname = arr_pics.get(i).getImgname();
					/*
					 * Toast.makeText(getApplicationContext(),fname,
					 * Toast.LENGTH_LONG).show();
					 */
					String filePath = new String(Environment
							.getExternalStorageDirectory().getAbsolutePath()
							+ "/NotesStation/");

					Bitmap bitmap;
					boolean directfound = false;
					File file = null;
					try {
						file = new File(filePath + "thumb/" + fname);
						if (file.exists() && file.length() != 0) {
							directfound = true;
							filePath += "thumb/";
						} else {
							thumbdn = new Downld(
									"http://wscubetech.org/app/updown/" + fname+"-thumb",
									filePath + "thumb/", fname, scrolltab.this);
							if (thumbdn.success && file.length() != 0)
								filePath += "thumb/";
							else {
								file = new File(filePath + fname);
								if (file.exists() && file.length() != 0) {
									directfound = true;
									/*try {
										OutputStream outStream = null;
										File th_file = new File(filePath + fname+"-thumb");
										outStream = new FileOutputStream(th_file);
										bitmap = BitmapFactory.decodeFile(filePath + fname);
										bitmap.compress(Bitmap.CompressFormat.PNG, 100, outStream);
										outStream.flush();
										outStream.close();
									} catch (Exception e) {
										Toast.makeText(getApplicationContext(), e.toString(),
												Toast.LENGTH_LONG).show();
									}*/									
								} else {
									thumbdn = new Downld(
											"http://wscubetech.org/app/updown/"
													+ fname, filePath, fname,
											scrolltab.this);
								}
							}
						}
						if ((thumbdn != null && thumbdn.success) || directfound) {
							bitmap = BitmapFactory.decodeFile(filePath + fname);
						} else {
							bitmap = BitmapFactory.decodeResource(
									c.getResources(), R.drawable.error);
						}
					} catch (Exception e) {
						e.printStackTrace();
						Toast.makeText(getApplicationContext(),
								"Exception:" + e.toString(), Toast.LENGTH_LONG)
								.show();
						bitmap = BitmapFactory.decodeResource(c.getResources(),
								R.drawable.error);
					}
					img.setImageBitmap(bitmap);
					/*
					 * Toast.makeText(getApplicationContext(), fname + ":" +
					 * String.valueOf(file.length()), Toast.LENGTH_LONG).show();
					 */
				}
				// btn.setText("Delete");
			}
			// img.setImageResource(arr2.get(position));
			OnClickListener NotesListButtonClick = new OnClickListener() {

				@Override
				public void onClick(View v) {
					/*
					 * if (v.getId() == R.id.button1) {
					 * Toast.makeText(getApplicationContext(), v.toString(),
					 * Toast.LENGTH_LONG).show(); int position =
					 * Integer.parseInt((((TextView) v
					 * .findViewById(R.id.textView3)).getText()) .toString());
					 * //position = position; if (position != 0) {
					 * //NotesDatabaseHandler db = new NotesDatabaseHandler(
					 * getApplicationContext()); //List<NotesData> users =
					 * db.getAllContacts();
					 * 
					 * Toast.makeText(getApplicationContext(),users.get(1
					 * ).getNotes(), Toast.LENGTH_LONG).show();
					 * 
					 * 
					 * // db.deleteContact(users.get(position - 1));
					 * //db.deleteContact(users.get(0)); startActivity(new
					 * Intent(getApplicationContext(), scrolltab.class));
					 * finish(); } } else {
					 */
					int position = Integer
							.parseInt(((TextView) v
									.findViewById(R.id.textView3)).getText()
									.toString());
					if (position == 0) {
						startActivity(new Intent(getApplicationContext(),
								NewNotes.class));
						finish();
					} else {
						if (v.getId() == R.id.imageView2) {
							if (arr_pics.get(position).downloadstatus != 1) {
								String fname = arr_pics.get(position)
										.getImgname();
								String filePath = new String(Environment
										.getExternalStorageDirectory()
										.getAbsolutePath()
										+ "/NotesStation/");
								File dfile = new File(filePath, fname);
								if (dfile.exists()) {
									if (dfile.length() != 0) {
										arr_pics.get(position).downloadstatus = 3;
										Toast.makeText(getApplicationContext(),
												"Already Downloaded",
												Toast.LENGTH_LONG).show();
									}
								} else
									arr_pics.get(position).downloadstatus = 2;
							}

							else
								arr_pics.get(position).downloadstatus = 1;

						} else {
							Toast.makeText(getApplicationContext(), "TODO",
									Toast.LENGTH_LONG).show();
						}

					}
				}
			};
			// btn.setOnClickListener(NotesListButtonClick);
			list.setOnClickListener(NotesListButtonClick);
			return list;
		}
	}
}