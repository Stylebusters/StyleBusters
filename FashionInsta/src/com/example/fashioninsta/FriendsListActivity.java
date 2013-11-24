package com.example.fashioninsta;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;


public class FriendsListActivity extends Activity {
	 
	    // for the first listview of friendslist.xml
	/*public static final String[] nameAdded = new String[] { "Chanel",
	            "Beyonce", "James" };
	 
	    public static final String[] descriptions = new String[] {
	            "added you",
	            "added you", "added you"};
	 
	    public static final Integer[] images = { R.drawable.femalemodel1,
	            R.drawable.femalemodel5, R.drawable.malemodel3};*/
	 
	  
	    
	 // for the second listview of friendslist.xml
	    
	/*public static final String[] friends = new String[] { "Mirranda",
            "Audrey", "Jensen","Gao","Milo" };
 
    public static final String[] desc = new String[] {
            "","","",
            "", ""};
 
    public static final Integer[] images2 = { R.drawable.model1,
            R.drawable.femalemodel2, R.drawable.femalemodel4,R.drawable.malemodel2,R.drawable.malemodel7};*/
	    
	    //Populate 2nd listview
        /* rowItems2 = new ArrayList<RowItem>();
        for (int i = 0; i < friends.length; i++) {
            RowItem item = new RowItem(images2[i], friends[i], desc[i]);
            rowItems2.add(item);
        }
 
        listView2 = (ListView) findViewById(R.id.list2);
       CurrentFriendsListViewAdapter adapter2 = new CurrentFriendsListViewAdapter(this,
                R.layout.currentfriendlistitem_layout, rowItems2);
        listView2.setAdapter(adapter2);
    
	    if (rowItems.size()!=0 && rowItems!=null){
	    	btnDelete= (Button)findViewById(R.id.deleteFriend);
	    	btnDelete.setOnClickListener(new View.OnClickListener() {
				
			@Override
				public void onClick(View v) {
					
					deleteFriend(listView2);
					Toast.makeText(FriendsListActivity.this,"Hello this is clicked", Toast.LENGTH_LONG).show();
				}					
	    	});
	    	
	    	deleteFriend(listView2);
	    }*/
        
	ListView listView;
	List<RowItem> rowItems;
    ListView listView2;
    List<RowItem> rowItems2;
    Button btnDelete;
    CurrentFriendsListViewAdapter cfAdapter;
    WaitingFriendsListViewAdapter wfAdapter;
    ArrayList<String> arr_currentFriends= new ArrayList<String>();
    ArrayList<String> arr_waitingFriends= new ArrayList<String>();
    AlertDialog.Builder alertDialogBuilder;
    ArrayList<Bitmap> arr_bitmaps= new ArrayList<Bitmap>();
    
  
	    /** Called when the activity is first created. */
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_friendslist);
	 
	      //Populate 1st listview
	        /*rowItems = new ArrayList<RowItem>();
	        for (int i = 0; i < nameAdded.length; i++) {
	            RowItem item = new RowItem(images[i], nameAdded[i], descriptions[i]);
	            rowItems.add(item);
	        }
	 
	        listView = (ListView) findViewById(R.id.list1);
	        CustomListViewAdapter adapter = new CustomListViewAdapter(this,
	                R.layout.item_layout, rowItems);
	        listView.setAdapter(adapter);*/
	        //listView.setOnItemClickListener(this);
	        
	        listView = (ListView) findViewById(R.id.list1);
	        
	        ArrayList<Bitmap> arr_bitmaps1= new ArrayList<Bitmap>();
	        arr_bitmaps1.add(BitmapFactory.decodeResource(getResources(),  R.drawable.femalemodel1));
	        arr_bitmaps1.add(BitmapFactory.decodeResource(getResources(),  R.drawable.femalemodel5));
	        arr_bitmaps1.add(BitmapFactory.decodeResource(getResources(),  R.drawable.malemodel3));
	        //arr_bitmaps1.add(BitmapFactory.decodeResource(getResources(),  R.drawable.femalemodel6));
	        
	        arr_waitingFriends.add("Chanel");
	        arr_waitingFriends.add("Beyonce");
	        arr_waitingFriends.add("James");
	        //arr_waitingFriends.add("Kate");
	        
	        wfAdapter= new WaitingFriendsListViewAdapter(FriendsListActivity.this, arr_bitmaps1, arr_waitingFriends);
	        listView.setAdapter(wfAdapter);
	        
	        //2nd listview
	        listView2 = (ListView) findViewById(R.id.list2);
	        
	        ArrayList<Bitmap> arr_bitmaps= new ArrayList<Bitmap>();
	        arr_bitmaps.add(BitmapFactory.decodeResource(getResources(),  R.drawable.model1));
	        arr_bitmaps.add(BitmapFactory.decodeResource(getResources(),  R.drawable.femalemodel2));
	        arr_bitmaps.add(BitmapFactory.decodeResource(getResources(),  R.drawable.femalemodel4));
	        arr_bitmaps.add(BitmapFactory.decodeResource(getResources(),  R.drawable.malemodel2));
	        arr_bitmaps.add(BitmapFactory.decodeResource(getResources(),  R.drawable.malemodel7));
	        arr_bitmaps.add(BitmapFactory.decodeResource(getResources(),  R.drawable.lydia));
	        
	        arr_currentFriends.add("Mirranda");
	        arr_currentFriends.add("Audrey");
	        arr_currentFriends.add("Jensen");
	        arr_currentFriends.add("Gao");
	        arr_currentFriends.add("Milo");
	        arr_currentFriends.add("Lydia");
	        
	        cfAdapter= new CurrentFriendsListViewAdapter(FriendsListActivity.this, arr_bitmaps, arr_currentFriends);
	        listView2.setAdapter(cfAdapter);
	        
	    }
	        
	      public class WaitingFriendsListViewAdapter extends BaseAdapter	    {
	    	    
		    	public String title[];
		    	public String description[];
		    	ArrayList<String> arr_calllog_name = new ArrayList<String>();
		    	public Activity context;
		    	ArrayList<Bitmap> imageId; 

		    	public LayoutInflater inflater;
		    	
		    	public WaitingFriendsListViewAdapter (Activity context, ArrayList<Bitmap> arr_bitmaps, ArrayList<String> arr_calllog_name) {
		    		this.imageId = arr_bitmaps;
		    		this.context = context;
		    		this.arr_calllog_name = arr_calllog_name;
		    	
		    	    this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		    	}
		    	
		    	public ArrayList<Bitmap> getImageId() {
		    	    return imageId;
		    	}
		    	public void setImageId(ArrayList<Bitmap> imageId) {
		    	    this.imageId = imageId;
		    	}


		    	
				    
		    	@Override
		    	public int getCount() {
		    		// TODO Auto-generated method stub
		    		return arr_calllog_name.size();
		    	}

		    	@Override
		    	public Object getItem(int position) {
		    		// TODO Auto-generated method stub
		    		return null;
		    	}

		    	@Override
		    	public long getItemId(int position) {
		    		// TODO Auto-generated method stub
		    		return 0;
		    	}

		    	public class ViewHolder
		    	{
		    		ImageView image;
		    		TextView txtName;
		    		TextView txtDesc;
		    		Button btnA;
		    		Button btnD;
		    		RelativeLayout row;
		    	}

		    	@Override
		    	public View getView(final int position, View convertView, ViewGroup parent) {
		    		// TODO Auto-generated method stub

		    		final ViewHolder holder;
		    		if(convertView==null)
		    		{
		    			holder = new ViewHolder();
		    			convertView = inflater.inflate(R.layout.item_layout, null);
		    			
		    			holder.image = (ImageView) convertView.findViewById(R.id.item_icon);
		    			holder.txtName = (TextView) convertView.findViewById(R.id.nameAdded);
		    			holder.txtDesc = (TextView) convertView.findViewById(R.id.addedDesc);
		    			holder.btnA = (Button) convertView.findViewById(R.id.accept);
		    			holder.btnD = (Button) convertView.findViewById(R.id.decline);
		    			holder.row = (RelativeLayout) convertView.findViewById(R.id.lineRowItem);
		    			convertView.setTag(holder);
		    		}
		    		else
		    			holder=(ViewHolder)convertView.getTag();

		    		holder.image.setImageBitmap(getImageId().get(position));
		    		holder.txtName.setText(arr_calllog_name.get(position));
		    		
		    		holder.btnA.setOnClickListener(new View.OnClickListener() {

						@Override
						public void onClick(View v) {
							// TODO Auto-generated method stub
							alertDialogBuilder = new AlertDialog.Builder(FriendsListActivity.this);
			           	 	alertDialogBuilder.setTitle("Accept Friend Invitation");
			           	 	alertDialogBuilder.setMessage("Do you want to accept friend request from "+holder.txtName.getText()+" ?");
			           	 	alertDialogBuilder.setPositiveButton("Yes",new DialogInterface.OnClickListener() {
			           			public void onClick(DialogInterface dialog,int id) {
			           				arr_currentFriends.add(holder.txtName.getText().toString());
			           				arr_bitmaps.add(BitmapFactory.decodeResource(getResources(), R.drawable.femalemodel1 ));//  holder.image.getDrawable()
								 	cfAdapter.notifyDataSetChanged();
								 	arr_waitingFriends.remove(position);
								 	wfAdapter.notifyDataSetChanged();
								 	Toast.makeText(getApplicationContext(), holder.txtName.getText()+" has been added to your Friends List.", Toast.LENGTH_SHORT).show();
			          				}
			          			  });
			          			alertDialogBuilder.setNegativeButton("No",new DialogInterface.OnClickListener() {
			          				public void onClick(DialogInterface dialog,int id) {
			          						dialog.cancel();
			          				}
			          			});
			          	 
			          			AlertDialog alertDialog = alertDialogBuilder.create();
			          			alertDialog.show();
			     
							
						}
					});
		    		
		    		holder.btnD.setOnClickListener(new View.OnClickListener() {

						@Override
						public void onClick(View v) {
							// TODO Auto-generated method stub
							alertDialogBuilder = new AlertDialog.Builder(FriendsListActivity.this);
			           	 	alertDialogBuilder.setTitle("Decline Friend Invitation");
			           	 	alertDialogBuilder.setMessage("Are you sure you want to decline "+holder.txtName.getText()+"'s Invitation ?");
			           	 	alertDialogBuilder.setPositiveButton("Yes",new DialogInterface.OnClickListener() {
			           			public void onClick(DialogInterface dialog,int id) {
			           				//arr_bitmaps.remove(getImageId());
			           				arr_waitingFriends.remove(position);
								 	wfAdapter.notifyDataSetChanged();
								 	Toast.makeText(getApplicationContext(), "You have declined "+ holder.txtName.getText()+"'s Friend Invitation.", Toast.LENGTH_SHORT).show();
			          				}
			          			  });
			          			alertDialogBuilder.setNegativeButton("No",new DialogInterface.OnClickListener() {
			          				public void onClick(DialogInterface dialog,int id) {
			          						dialog.cancel();
			          				}
			          			});
			          	 
			          			AlertDialog alertDialog = alertDialogBuilder.create();
			          			alertDialog.show();
			     
							
						}
						
					});
		    		
		    		holder.row.setOnClickListener(new View.OnClickListener() {
						
						@Override
						public void onClick(View v) {
						 	Toast.makeText(getApplicationContext(), holder.txtName.getText()+" is waiting for you to accept his/ her friend invitation!", Toast.LENGTH_SHORT).show();
						}
					});
		    		
		    		return convertView;
		    		
		    	
		    		
		    	}
	        }
	     
	        
	        /*-------------------------------------For CurrentFriendsListView (listview2)------------------------*/
	        
	     
	   	
	    
	  //if you want to add functionality to your objects in the rows, you need to do it in your adapter class.
		//Now we are going to let the user delete a row from the list buy clicking on the button (ld. lent)
		 
	    public class CurrentFriendsListViewAdapter extends BaseAdapter	    {
	    
	    	public String title[];
	    	public String description[];
	    	ArrayList<String> arr_calllog_name = new ArrayList<String>();
	    	public Activity context;
	    	ArrayList<Bitmap> imageId; 

	    	public LayoutInflater inflater;
	    	
	    	public CurrentFriendsListViewAdapter (Activity context, ArrayList<Bitmap> arr_bitmaps, ArrayList<String> arr_calllog_name) {
	    		this.imageId = arr_bitmaps;
	    		this.context = context;
	    		this.arr_calllog_name = arr_calllog_name;
	    	
	    	    this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	    	}
	    	
	    	public ArrayList<Bitmap> getImageId() {
	    	    return imageId;
	    	}
	    	public void setImageId(ArrayList<Bitmap> imageId) {
	    	    this.imageId = imageId;
	    	}


	    	
			    
	    	@Override
	    	public int getCount() {
	    		// TODO Auto-generated method stub
	    		return arr_calllog_name.size();
	    	}

	    	@Override
	    	public Object getItem(int position) {
	    		// TODO Auto-generated method stub
	    		return null;
	    	}

	    	@Override
	    	public long getItemId(int position) {
	    		// TODO Auto-generated method stub
	    		return 0;
	    	}

	    	public class ViewHolder
	    	{
	    		ImageView image;
	    		TextView txtName;
	    		Button btn;
	    		RelativeLayout row;
	    	}

	    	@Override
	    	public View getView(final int position, View convertView, ViewGroup parent) {
	    		// TODO Auto-generated method stub

	    		final ViewHolder holder;
	    		if(convertView==null)
	    		{
	    			holder = new ViewHolder();
	    			convertView = inflater.inflate(R.layout.currentfriendlistitem_layout, null);
	    			
	    			holder.image = (ImageView) convertView.findViewById(R.id.item_icon);
	    			holder.txtName = (TextView) convertView.findViewById(R.id.nameAdded);
	    			holder.btn = (Button) convertView.findViewById(R.id.deleteFriend);
	    			holder.row = (RelativeLayout) convertView.findViewById(R.id.lineItem);
	    			convertView.setTag(holder);
	    		}
	    		else
	    			holder=(ViewHolder)convertView.getTag();

	    		holder.image.setImageBitmap(getImageId().get(position));
	    		holder.txtName.setText(arr_calllog_name.get(position));
	    		
	    		holder.btn.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						alertDialogBuilder = new AlertDialog.Builder(FriendsListActivity.this);
		           	 	alertDialogBuilder.setTitle("Delete this Friend");
		           	 	alertDialogBuilder.setMessage("Are you sure you want to delete "+holder.txtName.getText()+" ?");
		           	 	alertDialogBuilder.setPositiveButton("Yes",new DialogInterface.OnClickListener() {
		           			public void onClick(DialogInterface dialog,int id) {
		           				//arr_bitmaps.remove(getImageId());
		           				arr_currentFriends.remove(position);
							 	cfAdapter.notifyDataSetChanged();
							 	Toast.makeText(getApplicationContext(), "You have deleted "+ holder.txtName.getText()+" from your Friends List.", Toast.LENGTH_SHORT).show();
		          				}
		          			  });
		          			alertDialogBuilder.setNegativeButton("No",new DialogInterface.OnClickListener() {
		          				public void onClick(DialogInterface dialog,int id) {
		          						dialog.cancel();
		          				}
		          			});
		          	 
		          			AlertDialog alertDialog = alertDialogBuilder.create();
		          			alertDialog.show();
		     
						
					}
					
	    			   
				/*	@Override
					public void onClick(View v) {
					 	arr_currentFriends.remove(position);
					 	cfAdapter.notifyDataSetChanged();
					 	Toast.makeText(getApplicationContext(), "You have deleted row No. "+ position, Toast.LENGTH_SHORT).show();
					}*/
				});
	    		
	    		holder.row.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
					 	Toast.makeText(getApplicationContext(), holder.txtName.getText(), Toast.LENGTH_SHORT).show();
					}
				});
	    		
	    		return convertView;
	    		
	    	
	    		
	    	}
	    }
	    
	    
	    /*------------------------------------------------------------------*/
	    /*public void deleteFriend(View v){
	    	RowItem itemToDelete= (RowItem)v.getTag();// get the rowitem itself from the listview
	    	rowItems2.remove(itemToDelete);
	    }*/
	    
	  
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
	  
	  public void onClick_ToAddFriendPage(View v) {
		  Intent i = new Intent(getApplicationContext(), AddFriendActivity.class);
			startActivity(i);
			finish();
	  }
}

