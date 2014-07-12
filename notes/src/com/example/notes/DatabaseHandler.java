package com.example.notes;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {

	// All Static variables
	// Database Version
	private static final int DATABASE_VERSION = 1;

	// Database Name
	private static final String DATABASE_NAME = "usersManager";

	// Contacts table name
	private static final String TABLE_CONTACTS = "users";

	// Contacts Table Columns names
	private static final String KEY_NAME = "name";
	private static final String KEY_BRANCH = "branch";
	private static final String KEY_YEAR = "year";
	private static final String KEY_SEMESTER = "semester";
	private static final String KEY_COLLEGE = "college";
	private static final String KEY_CITY = "city";
	private static final String KEY_EMAIL = "email";
	private static final String KEY_PASSWORD = "password";

	public DatabaseHandler(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	// Creating Tables
	@Override
	public void onCreate(SQLiteDatabase db) {
		String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "("
				+ KEY_NAME + " TEXT," + KEY_BRANCH + " TEXT," + KEY_YEAR
				+ " INTEGER," + KEY_SEMESTER + " INTEGER," + KEY_COLLEGE
				+ " TEXT," + KEY_CITY + " TEXT," + KEY_EMAIL + " TEXT,"
				+ KEY_PASSWORD + " TEXT" + ")";
		db.execSQL(CREATE_CONTACTS_TABLE);
	}

	// Upgrading database
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// Drop older table if existed
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);

		// Create tables again
		onCreate(db);
	}

	/**
	 * All CRUD(Create, Read, Update, Delete) Operations
	 */

	// Adding new contact
	void addContact(Users users) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_NAME, users.getName()); // Name
		values.put(KEY_BRANCH, users.getBranch()); // Name
		values.put(KEY_YEAR, users.getYear()); // Name
		values.put(KEY_SEMESTER, users.getSemester());
		values.put(KEY_COLLEGE, users.getCollege()); // Name
		values.put(KEY_CITY, users.getCity()); // Name
		values.put(KEY_EMAIL, users.getEmail()); // Name
		values.put(KEY_PASSWORD, users.getPassword()); // Name

		// Inserting Row
		db.insert(TABLE_CONTACTS, null, values);
		db.close(); // Closing database connection
	}

	// Getting single contact
	Users getContact(int id) {
		SQLiteDatabase db = this.getReadableDatabase();

		Cursor cursor = db.query(TABLE_CONTACTS, new String[] { KEY_NAME,
				KEY_BRANCH, KEY_YEAR, KEY_SEMESTER, KEY_COLLEGE, KEY_CITY,
				KEY_EMAIL, KEY_PASSWORD }, KEY_NAME + "=?",
				new String[] { String.valueOf(id) }, null, null, null, null);
		if (cursor != null)
			cursor.moveToFirst();

		Users contact = new Users(cursor.getString(0), cursor.getString(1),
				Integer.parseInt(cursor.getString(2)), Integer.parseInt(cursor
						.getString(3)), cursor.getString(4),
				cursor.getString(5), cursor.getString(6), cursor.getString(7));
		// return contact
		return contact;
	}

	// Getting All Contacts
	public List<Users> getAllContacts() {
		List<Users> contactList = new ArrayList<Users>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS;

		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				Users contact = new Users();
				contact.setName(cursor.getString(0));
				contact.setBranch(cursor.getString(1));
				contact.setYear(Integer.parseInt(cursor.getString(2)));
				contact.setSemester(Integer.parseInt(cursor.getString(3)));
				contact.setCollege(cursor.getString(4));
				contact.setCity(cursor.getString(5));
				contact.setEmail(cursor.getString(6));
				contact.setPassword(cursor.getString(7));
				// Adding contact to list
				contactList.add(contact);
			} while (cursor.moveToNext());
		}

		// return contact list
		return contactList;
	}

	// Updating single contact
	public int updateContact(Users users) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_NAME, users.getName()); // Name
		values.put(KEY_BRANCH, users.getBranch()); // Name
		values.put(KEY_YEAR, users.getYear()); // Name
		values.put(KEY_SEMESTER, users.getSemester());
		values.put(KEY_COLLEGE, users.getCollege()); // Name
		values.put(KEY_CITY, users.getCity()); // Name
		values.put(KEY_EMAIL, users.getEmail()); // Name
		values.put(KEY_PASSWORD, users.getPassword());
		// updating row

		return db.update(TABLE_CONTACTS, values, KEY_NAME + " = ?",
				new String[] { String.valueOf(users.getName()) });
	}

	// Deleting single contact
	public void deleteContact(Users contact) {
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(TABLE_CONTACTS, KEY_NAME + " = ?",
				new String[] { String.valueOf(contact.getName()) });
		db.close();
		// TODO
	}

	// Getting contacts Count
	public int getContactsCount() {
		String countQuery = "SELECT  * FROM " + TABLE_CONTACTS;
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(countQuery, null);
		cursor.close();

		// return count
		return cursor.getCount();
	}

}