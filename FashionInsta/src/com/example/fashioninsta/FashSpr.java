package com.example.fashioninsta;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.support.v7.app.ActionBar.Tab;


public class FashSpr extends ActionBarActivity {
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		ActionBar actionBar = getSupportActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);


		Tab tab1 = actionBar.newTab();
		tab1.setText("TimeLine");
		tab1.setTabListener(new TabListener<Timeline>(this, "timeline", Timeline.class));
		actionBar.addTab(tab1);

		Tab tab2 = actionBar.newTab();
		tab2.setText("My Shares");
		tab2.setTabListener(new TabListener<MyShares>(this, "myshares", MyShares.class));
		actionBar.addTab(tab2);

		
	

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
	
	
	
	public static class TabListener<T extends Fragment> implements ActionBar.TabListener{

		private final ActionBarActivity myActivity;
		private final String myTag;
		private final Class<T> myClass;

		public TabListener(ActionBarActivity activity, String tag, Class<T> cls) {
			myActivity = activity;
			myTag = tag;
			myClass = cls;
		}

		@Override
		public void onTabSelected(Tab tab, FragmentTransaction ft) {

			Fragment myFragment = myActivity.getSupportFragmentManager().findFragmentByTag(myTag);

			// Check if the fragment is already initialized
			if (myFragment == null) {
				// If not, instantiate and add it to the activity
				myFragment = Fragment.instantiate(myActivity, myClass.getName());
				ft.replace(android.R.id.content, myFragment, myTag);
			} else {
				// If it exists, simply attach it in order to show it
				ft.attach(myFragment);
			}

		}

			@Override
			public void onTabUnselected(Tab tab, FragmentTransaction ft) {
	
				Fragment myFragment = myActivity.getSupportFragmentManager().findFragmentByTag(myTag);
	
				if (myFragment != null) {
					// Detach the fragment, because another one is being attached
					ft.detach(myFragment);
				}
	
			}
	
			@Override
			public void onTabReselected(Tab tab, FragmentTransaction ft) {
				// TODO Auto-generated method stub
	
			}
	
		}
}


