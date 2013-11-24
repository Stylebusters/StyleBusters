package com.example.fashioninsta;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

public class Friends_List extends Activity {

	ListView listView;
	private ImageButton addPictureButton;
	private ImageButton friendsListButton;
	private ImageButton colorCombiButton;
	private ImageButton fashionSpreadButton;
	private Button addFButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.friends__list);
	
		listView = (ListView) findViewById(R.id.listFriends);
	
		String[] friends = this.getResources().getStringArray(R.array.friendArray);
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.list_view_row, R.id.listText,friends);
		listView.setAdapter(adapter);
		//button
				addPictureButton = (ImageButton) findViewById(R.id.addPictureButton);
				friendsListButton = (ImageButton) findViewById(R.id.friendsListButton);
				colorCombiButton = (ImageButton) findViewById(R.id.colorCombiButton);
				fashionSpreadButton = (ImageButton) findViewById(R.id.fashionSpreadButton);
				addFButton = (Button) findViewById(R.id.addFButton);
				
				//add friend
				addFButton.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent i = new Intent(getApplicationContext(), AddFriend.class);
						startActivity(i);
						
					}
				});
				
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
		friendsListButton.setBackgroundColor(Color.GRAY);
			/*	// friends list button click event
		friendsListButton.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View arg0) {				
						Intent i = new Intent(getApplicationContext(), Friends_List.class);
						//i.putExtra("userID",userID);
						startActivity(i);
						//finish();
					}
				});*/
				
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
