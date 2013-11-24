package com.example.fashioninsta;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Base_Activity extends Activity{
		
	private Button addPictureButton;
	private Button friendsListButton;
	private Button colorCombiButton;
	private Button fashionSpreadButton;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home_page);
		
		//button
		addPictureButton = (Button) findViewById(R.id.addPictureButton);
		friendsListButton = (Button) findViewById(R.id.friendsListButton);
		colorCombiButton = (Button) findViewById(R.id.colorCombiButton);
		fashionSpreadButton = (Button) findViewById(R.id.fashionSpreadButton);
		
				// add friend button click event
		addPictureButton.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View arg0) {				
						Intent i = new Intent(getApplicationContext(), AddFriend.class);
						//i.putExtra("userID",userID);
						startActivity(i);
						finish();
					}
				});
				
				// friends list button click event
		friendsListButton.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View arg0) {				
						Intent i = new Intent(getApplicationContext(), FriendsList.class);
						//i.putExtra("userID",userID);
						startActivity(i);
						finish();
					}
				});
				
				// color combi button click event
		colorCombiButton.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View arg0) {				
						Intent i = new Intent(getApplicationContext(), ColourCombi.class);
						//i.putExtra("userID",userID);
						startActivity(i);
						finish();
					}
				});
				
				// fashion spread button click event
		fashionSpreadButton.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View arg0) {				
						Intent i = new Intent(getApplicationContext(), FashSpr.class);
						//i.putExtra("userID",userID);
						startActivity(i);
						finish();
					}
				});
		
		
	}

		 
			

		
}


