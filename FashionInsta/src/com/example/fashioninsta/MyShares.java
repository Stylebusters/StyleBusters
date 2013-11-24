package com.example.fashioninsta;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

public class MyShares extends Fragment{

	ListViewAdapter adapter;
	String[] username;
	String[] date;
	String[] description;
	int[] photos;
	int[] fashy;
	int[] tacky;
	
	private ImageButton addPictureButton;
	private ImageButton friendsListButton;
	private ImageButton colorCombiButton;
	private ImageButton fashionSpreadButton;
	
	@Override
	public void onStart() {
		super.onStart();
		initControls();
	}
	   
	public void initControls(){
	    // Use an existing ListAdapter that will map an array
	    // of strings to TextViews
	  //button
	  		addPictureButton = (ImageButton) getView().findViewById(R.id.addPictureButton);
	  		friendsListButton = (ImageButton) getView().findViewById(R.id.friendsListButton);
	  		colorCombiButton = (ImageButton) getView().findViewById(R.id.colorCombiButton);
	  		fashionSpreadButton = (ImageButton) getView().findViewById(R.id.fashionSpreadButton);
	  		
	  				// add picture button click event
	  		addPictureButton.setOnClickListener(new View.OnClickListener() {
	  					@Override
	  					public void onClick(View arg0) {				
	  						Intent i = new Intent(getActivity(), AddPicture.class);
	  						//i.putExtra("userID",userID);
	  						getActivity().startActivity(i);
	  						//finish();
	  					}
	  				});
	  				
	  				// friends list button click event
	  		friendsListButton.setOnClickListener(new View.OnClickListener() {
	  					@Override
	  					public void onClick(View arg0) {				
	  						Intent i = new Intent(getActivity(), FriendsListActivity.class);
	  						//i.putExtra("userID",userID);
	  						getActivity().startActivity(i);
	  						//finish();
	  					}
	  				});
	  				
	  				// color combi button click event
	  		colorCombiButton.setOnClickListener(new View.OnClickListener() {
	  					@Override
	  					public void onClick(View arg0) {				
	  						Intent i = new Intent(getActivity(), ColorPickerActivity.class);
	  						//i.putExtra("userID",userID);
	  						getActivity().startActivity(i);
	  						//finish();
	  					}
	  				});
	  				
	  				// fashion spread button click event
	  		fashionSpreadButton.setOnClickListener(new View.OnClickListener() {
	  					@Override
	  					public void onClick(View arg0) {				
	  						Intent i = new Intent(getActivity(), FashSpr.class);
	  						//i.putExtra("userID",userID);
	  						getActivity().startActivity(i);
	  						//finish();
	  					}
	  				});
	  		
	  		
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

		View myFragmentView = inflater.inflate(R.layout.myshares, container, false);
	
		username = new String[] {"Gucci Tan", "Gucci Tan", "Gucci Tan"};
		date = new String[] {"19 Sept 2013", "17 Sept 2013", "16 Sept 2013"};
		description = new String[] {"Wore this dress to Chanel's party today!", "First time wearing outfit from my haul", "My outfit of the day xD"};
		fashy = new int[] {7, 2, 5};
		tacky = new int[] {0, 1, 2};
		photos = new int[]{R.drawable.guccitan1, R.drawable.user1, R.drawable.guccitan3};
		ListView listview = (ListView)myFragmentView.findViewById(android.R.id.list);
		adapter = new ListViewAdapter(inflater.getContext(), username, date, description, photos, fashy, tacky );
		listview.setAdapter(adapter);
		return myFragmentView;
	}



		
}
