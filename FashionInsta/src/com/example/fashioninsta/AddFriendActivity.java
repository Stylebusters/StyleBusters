package com.example.fashioninsta;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class AddFriendActivity extends Activity {


	private EditText inputEmail;
	private Button addButton;
	private ImageButton addPictureButton;
	private ImageButton friendsListButton;
	private ImageButton colorCombiButton;
	private ImageButton fashionSpreadButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addfriend);
      //button
		addPictureButton = (ImageButton) findViewById(R.id.addPictureButton);
		friendsListButton = (ImageButton) findViewById(R.id.friendsListButton);
		colorCombiButton = (ImageButton) findViewById(R.id.colorCombiButton);
		fashionSpreadButton = (ImageButton) findViewById(R.id.fashionSpreadButton);
		
				// add picture button click event
		addPictureButton.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View arg0) {				
						Intent i = new Intent(getApplicationContext(), AddPicture.class);
						//i.putExtra("userID",userID);
						startActivity(i);
						//finish();
					}
				});
				
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
        inputEmail = (EditText) findViewById(R.id.email);
		addButton = (Button) findViewById(R.id.addFriend);
		
		addButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String email = inputEmail.getText().toString().trim();
				int charAt=email.indexOf("@");
				
				if (charAt==-1){
					Toast.makeText(AddFriendActivity.this, "Incorrect Username/Password", Toast.LENGTH_SHORT).show();
				} else{
					String subString=email.substring(0,charAt);
					String notice="Your invite has been sent to "+subString;
					Toast.makeText(AddFriendActivity.this, notice, Toast.LENGTH_SHORT).show();
					Intent i = new Intent(getApplicationContext(), FriendsListActivity.class);
					startActivity(i);
					finish();
				}
			}
		});
    }


   @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.homefaq, menu);
        return true;
    }
    
    public void onClick_Back(View v) {
		  Intent i = new Intent(getApplicationContext(), FriendsListActivity.class);
			startActivity(i);
			finish();
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

