package com.example.fashioninsta;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Calendar;


import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.format.DateFormat;
import android.text.format.Time;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class AddPicture extends Activity {
	//static final int DATE_DIALOG_ID = 0;
	
	private TextView tvDisplayDate;
	private DatePicker dpResult;
	private Button btnChangeDate;

	private int year;
	private int month;
	private int day;
	
	private ImageButton addPictureButton;
	private ImageButton friendsListButton;
	private ImageButton colorCombiButton;
	private ImageButton fashionSpreadButton;
	
	private static final int SELECT_PICTURE = 1;
	 
    private String selectedImagePath;
    private ImageView img;
    private TextView descrip;
    
    protected static TextView textView;
    String DB_NAME = Environment.getExternalStorageDirectory() + "/fashion.db";
    String TABLE_NAME = "mytable";
    
	static final int DATE_DIALOG_ID = 999;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_picture);
	
		
		setCurrentDateOnView();
		addListenerOnButton();
		
		img = (ImageView)findViewById(R.id.ImageView01);
		
		//button
		addPictureButton = (ImageButton) findViewById(R.id.addPictureButton);
		friendsListButton = (ImageButton) findViewById(R.id.friendsListButton);
		colorCombiButton = (ImageButton) findViewById(R.id.colorCombiButton);
		fashionSpreadButton = (ImageButton) findViewById(R.id.fashionSpreadButton);
		addPictureButton.setBackgroundColor(Color.GRAY);
				// add friend button click event
		/*addPictureButton.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View arg0) {				
						Intent i = new Intent(getApplicationContext(), AddPicture.class);
						//i.putExtra("userID",userID);
						startActivity(i);
						//finish();
					}
				});
				*/
		
				// friends list button click event
		friendsListButton.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View arg0) {				
						Intent i = new Intent(getApplicationContext(), FriendsListActivity.class);
						//i.putExtra("userID",userID);
						startActivity(i);
						//finish();
					}
				});
				
				// color combi button click event
		colorCombiButton.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View arg0) {				
						Intent i = new Intent(getApplicationContext(), ColorPickerActivity.class);
						//i.putExtra("userID",userID);
						startActivity(i);
						//finish();
					}
				});
				
				// fashion spread button click event
		fashionSpreadButton.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View arg0) {				
						Intent i = new Intent(getApplicationContext(), FashSpr.class);
						//i.putExtra("userID",userID);
						startActivity(i);
						//finish();
					}
				});
		
		
		
		
	}

	public void addImage(View v){
		//createTable();
        //saveInDB();
        //readFromDB();
		Toast.makeText(AddPicture.this, "Your picture has been added.", Toast.LENGTH_LONG).show();
		Intent i;
		i = new Intent(getApplicationContext(), HomePage.class);
		startActivity(i);
	}
	
	
	// display current date
		public void setCurrentDateOnView() {

			tvDisplayDate = (TextView) findViewById(R.id.dop);
		//	dpResult = (DatePicker) findViewById(R.id.datePicker1);

			final Calendar c = Calendar.getInstance();
			year = c.get(Calendar.YEAR);
			month = c.get(Calendar.MONTH);
			day = c.get(Calendar.DAY_OF_MONTH);

			// set current date into textview
			tvDisplayDate.setText(new StringBuilder()
					// Month is 0 based, just add 1
					.append(day).append("-").append(month + 1).append("-")
					.append(year).append(" "));

			// set current date into datepicker
			//dpResult.init(year, month, day, null);

		}

		public void addListenerOnButton() {

			btnChangeDate = (Button) findViewById(R.id.pickDate);

			btnChangeDate.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {

					showDialog(DATE_DIALOG_ID);

				}

			});

		}
		
		@Override
		protected Dialog onCreateDialog(int id) {
			switch (id) {
			case DATE_DIALOG_ID:
				// set date picker as current date
				return new DatePickerDialog(this, datePickerListener, year, month,
						day);
			}
			return null;
		}

		private DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener() {

			// when dialog box is closed, below method will be called.
			public void onDateSet(DatePicker view, int selectedYear,
					int selectedMonth, int selectedDay) {
				year = selectedYear;
				month = selectedMonth;
				day = selectedDay;

				// set selected date into textview
				tvDisplayDate.setText(new StringBuilder().append(day)
						.append("-").append(month + 1).append("-").append(year)
						.append(" "));

				// set selected date into datepicker also
				//dpResult.init(year, month, day, null);

			}
		};
	
		public void choosePicture(View v){
			//Intent pickPhoto = new Intent(Intent.ACTION_PICK);
			//pickPhoto.setType("image/*");
			//startActivityForResult(pickPhoto, TAKE_AVATAR_GALLERY_REQUEST);
			//startActivity(pickPhoto);
			
			 Intent intent = new Intent();
             intent.setType("image/*");
             intent.setAction(Intent.ACTION_GET_CONTENT);
             startActivityForResult(Intent.createChooser(intent,"Select Picture"), SELECT_PICTURE);
		}
		
		 public void onActivityResult(int requestCode, int resultCode, Intent data) {
		        if (resultCode == RESULT_OK) {
		            if (requestCode == SELECT_PICTURE) {
		                Uri selectedImageUri = data.getData();
		                selectedImagePath = getPath(selectedImageUri);
		                System.out.println("Image Path : " + selectedImagePath);
		                img.setImageURI(selectedImageUri);
		            }
		        }
		    }
		 
		    public String getPath(Uri uri) {
		        String[] projection = { MediaStore.Images.Media.DATA };
		        Cursor cursor = managedQuery(uri, projection, null, null, null);
		        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
		        cursor.moveToFirst();
		        return cursor.getString(column_index);
		    }
		    
		    void createTable() {
		        SQLiteDatabase myDb = openOrCreateDatabase(DB_NAME,
		                Context.MODE_PRIVATE, null);
		        String MySQL = "create table if not exists "
		                + TABLE_NAME
		                + " (_id INTEGER primary key autoincrement, date TEXT not null, desc TEXT not null, image BLOB);";
		        myDb.execSQL(MySQL);
		        myDb.close();
		    }
		 
		    void saveInDB() {
		        SQLiteDatabase myDb = openOrCreateDatabase(DB_NAME,
		                Context.MODE_PRIVATE, null);
		        byte[] byteImage1 = null;
		        String s = myDb.getPath();
		 
		        myDb.execSQL("delete from " + TABLE_NAME);          // clearing the table
		        ContentValues newValues = new ContentValues();
		        
		        String date = (String) tvDisplayDate.getText();
		        descrip = (TextView) findViewById(R.id.desc);
		        String desc = (String) descrip.getText();
		        newValues.put("date", date);
		        newValues.put("desc", desc);
		        
		        try {
		            FileInputStream instream = new FileInputStream(selectedImagePath);
		            BufferedInputStream bif = new BufferedInputStream(instream);
		            byteImage1 = new byte[bif.available()];
		            bif.read(byteImage1);
		            newValues.put("image", byteImage1);
		            long ret = myDb.insert(TABLE_NAME, null, newValues);
		            if (ret < 0)
		                textView.append("Error");
		        } catch (IOException e) {
		            textView.append("Error Exception : " + e.getMessage());
		        }
		        myDb.close();
		        textView.append("\n Saving Details \n Date : " + date);
		        textView.append("\n Desc : " + desc);
		        textView.append("\n Image Size : " + byteImage1.length + " KB");
		        textView.append("\n Saved in DB : " + s + "\n");
		        Toast.makeText(this.getBaseContext(),
		                "Image Saved in DB successfully.", Toast.LENGTH_SHORT).show();
		    }
	
		    void readFromDB() {
		        byte[] byteImage2 = null;
		        SQLiteDatabase myDb;
		        myDb = openOrCreateDatabase(DB_NAME, Context.MODE_PRIVATE, null);
		        Cursor cur = myDb.query(TABLE_NAME, null, null, null, null, null, null);
		        cur.moveToFirst();
		        while (cur.isAfterLast() == false) {
		            textView.append("\n Reading Details \n Date : " + cur.getString(1));
		            cur.moveToNext();
		            textView.append("\n Desc : " + cur.getString(2));
		            cur.moveToNext();
		        }
		 
		        // /////Read data from blob field////////////////////
		        cur.moveToFirst();
		        byteImage2 = cur.getBlob(cur.getColumnIndex("image"));
		       // setImage(byteImage2);
		        cur.close();
		        myDb.close();
		        Toast.makeText(this.getBaseContext(),
		                "Image read from DB successfully.", Toast.LENGTH_SHORT).show();
		        Toast.makeText(this.getBaseContext(),
		                "If your image is big, please scrolldown to see the result.",
		                Toast.LENGTH_SHORT).show();
		    }
		    
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.homefaq, menu);
		return true;
	}
	
	public boolean onOptionsItemSelected(MenuItem item){
		Intent i;
		switch (item.getItemId())
		{
		case R.id.action_home:
			i = new Intent(getApplicationContext(), HomePage.class);
			startActivity(i);
			return true;
			
		case R.id.action_faq:
			i = new Intent(getApplicationContext(), FAQ.class);
			startActivity(i);
			return true;
		
		default:
			return super.onOptionsItemSelected(item);
		}
		
	}

}
