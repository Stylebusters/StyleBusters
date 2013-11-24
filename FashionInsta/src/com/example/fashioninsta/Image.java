package com.example.fashioninsta;

public class Image {

	// private variables
	int _id;
	String _date;
	String _desc;
	byte[] _image;

	// Empty constructor
	public Image() {

	}

	// constructor
	public Image(int keyId, String date, String desc, byte[] image) {
		this._id = keyId;
		this._date = date;
		this._desc = desc;
		this._image = image;

	}

	// constructor
	public Image(String contactID, String date, String desc, byte[] image) {
		this._date = date;
		this._desc = desc;
		this._image = image;

	}

	// constructor
	public Image(String date, String desc, byte[] image) {
		this._date = date;
		this._desc = desc;
		this._image = image;
	}

	// getting ID
	public int getID() {
		return this._id;
	}

	// setting id
	public void setID(int keyId) {
		this._id = keyId;
	}

	// getting name
	public String getDate() {
		return this._date;
	}

	// setting name
	public void setDate(String date) {
		this._date = date;
	}
	
	// getting name
	public String getDesc() {
		return this._desc;
	}

	// setting name
	public void setDesc(String desc) {
		this._desc = desc;
	}

	// getting phone number
	public byte[] getImage() {
		return this._image;
	}

	// setting phone number
	public void setImage(byte[] image) {
		this._image = image;
	}
}
