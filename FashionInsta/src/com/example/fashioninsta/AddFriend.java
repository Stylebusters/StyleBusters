package com.example.fashioninsta;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class AddFriend extends Base_Activity {
	private ImageButton addPictureButton;
	private ImageButton friendsListButton;
	private ImageButton colorCombiButton;
	private ImageButton fashionSpreadButton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_friend);
		
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
								Intent i = new Intent(getApplicationContext(), Friends_List.class);
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

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
	
	@Override
	public void onStart(){
		super.onStart();
	}
	
	@Override
	public void onPause(){
		super.onPause();
	}

	@Override
	public void onResume(){
		super.onResume();
	}

	@Override
	public void onStop(){
		super.onStop();
	}
	
	@Override
	public void onDestroy(){
		super.onDestroy();
	}

}
