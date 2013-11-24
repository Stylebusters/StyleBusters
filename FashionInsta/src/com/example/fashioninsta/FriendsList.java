package com.example.fashioninsta;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;// to comment out for custom.
import android.widget.ArrayAdapter;// to comment out for custom.
import android.widget.ListView;


public class FriendsList extends ListActivity {

	String[] items={"Rhonda","Ong Li", "Yesser", "Alan","Brian","Catherine","Darren","Enrique","Florence","Greta","Howard","Indinna","Johnny","Karl","Leon","Monique","Naria","Otto","Placebo"};
	// TO add dynamically from user db.

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_main);
		//TextView myList=(TextView)findViewById(android.R.id.list);
		setListAdapter(new ArrayAdapter(this,R.layout.activity_friends_list,items));// FOR CUSTOM: new MyArrayAdapter(this, Android_logos));
		ListView listView = getListView();
		listView.setTextFilterEnabled(true);

		/*listView.setOnItemClickListener(new OnItemClickListener() {
			//public void onItemClick(@SuppressWarnings("rawtypes") AdapterView parent, View view, int position, long id) {

			    // When clicked, show a toast with the TextView text
			    //Toast.makeText(getApplicationContext(),	((TextView) view).getText(), Toast.LENGTH_SHORT).show();
			//}
		});*/

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	/*@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {

		String selectedValue = (String) getListAdapter().getItem(position);
		Toast.makeText(this, selectedValue, Toast.LENGTH_SHORT).show();
	}*/
}



