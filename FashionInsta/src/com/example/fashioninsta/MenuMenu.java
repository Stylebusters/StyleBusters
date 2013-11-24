package com.example.fashioninsta;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MenuMenu extends Activity {
	private ImageButton addPictureButton;
	private ImageButton friendsListButton;
	private ImageButton colorCombiButton;
	private ImageButton fashionSpreadButton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu_menu);
		
		//button
		addPictureButton = (ImageButton) findViewById(R.id.addPictureButton);
		friendsListButton = (ImageButton) findViewById(R.id.friendsListButton);
		colorCombiButton = (ImageButton) findViewById(R.id.colorCombiButton);
		fashionSpreadButton = (ImageButton) findViewById(R.id.fashionSpreadButton);
		
				// add friend button click event
		addPictureButton.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View arg0) {				
						Intent i = new Intent(getApplicationContext(), AddFriend.class);
						//i.putExtra("userID",userID);
						startActivity(i);
						//finish();
					}
				});
				
				// friends list button click event
		friendsListButton.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View arg0) {				
						Intent i = new Intent(getApplicationContext(), FriendsList.class);
						//i.putExtra("userID",userID);
						startActivity(i);
						//finish();
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
						//finish();
					}
				});
		
		
	}


}
