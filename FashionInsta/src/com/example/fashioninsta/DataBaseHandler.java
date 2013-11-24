package com.example.fashioninsta;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHandler extends SQLiteOpenHelper {

	// All Static variables
	// Database Version
	private static final int DATABASE_VERSION = 1;

	// Database Name
	private static final String DATABASE_NAME = "imagedb";

	// Contacts table name
	private static final String TABLE_IMAGE = "images";

	// Contacts Table Columns names
	private static final String KEY_ID = "id";
	private static final String KEY_DATE = "date";
	private static final String KEY_DESC = "desc";
	private static final String KEY_IMAGE = "image";

	public DataBaseHandler(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	// Creating Tables
	@Override
	public void onCreate(SQLiteDatabase db) {
		String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_IMAGE + "("
				+ KEY_ID + " INTEGER PRIMARY KEY," + KEY_DATE + " TEXT," + KEY_DESC + " TEXT,"
				+ KEY_IMAGE + " BLOB" + ")";
		db.execSQL(CREATE_CONTACTS_TABLE);
	}

	// Upgrading database
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// Drop older table if existed
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_IMAGE);

		// Create tables again
		onCreate(db);
	}

	/**
	 * All CRUD(Create, Read, Update, Delete) Operations
	 */

	public// Adding new contact
	void addImage(Image image) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_DATE, image._date); // date
		values.put(KEY_DESC, image._desc); // date
		values.put(KEY_IMAGE, image._image); // img

		// Inserting Row
		db.insert(TABLE_IMAGE, null, values);
		db.close(); // Closing database connection
	}

	// Getting single contact
	Image getImage(int id) {
		SQLiteDatabase db = this.getReadableDatabase();

		Cursor cursor = db.query(TABLE_IMAGE, new String[] { KEY_ID,
				KEY_DATE, KEY_DESC, KEY_IMAGE }, KEY_ID + "=?",
				new String[] { String.valueOf(id) }, null, null, null, null);
		if (cursor != null)
			cursor.moveToFirst();

		Image image = new Image(Integer.parseInt(cursor.getString(0)),
				cursor.getString(1),cursor.getString(2), cursor.getBlob(1));

		// return contact
		return image;

	}

	// Getting All Contacts
	public List<Image> getAllImages() {
		List<Image> contactList = new ArrayList<Image>();
		// Select All Query
		String selectQuery = "SELECT  * FROM contacts ORDER BY name";

		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);
		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				Image contact = new Image();
				contact.setID(Integer.parseInt(cursor.getString(0)));
				contact.setDate(cursor.getString(1));
				contact.setDesc(cursor.getString(2));
				contact.setImage(cursor.getBlob(2));
				// Adding contact to list
				contactList.add(contact);
			} while (cursor.moveToNext());
		}
		// close inserting data from database
		db.close();
		// return contact list
		return contactList;

	}

	// Updating single contact
	public int updateImage(Image image) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_DATE, image.getDate());
		values.put(KEY_DESC, image.getDesc());
		values.put(KEY_IMAGE, image.getImage());

		// updating row
		return db.update(TABLE_IMAGE, values, KEY_ID + " = ?",
				new String[] { String.valueOf(image.getID()) });

	}

	// Deleting single contact
	public void deleteContact(Image image) {
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(TABLE_IMAGE, KEY_ID + " = ?",
				new String[] { String.valueOf(image.getID()) });
		db.close();
	}

	// Getting contacts Count
	public int getContactsCount() {
		String countQuery = "SELECT  * FROM " + TABLE_IMAGE;
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(countQuery, null);
		cursor.close();

		// return count
		return cursor.getCount();
	}

}
