package com.example.fashioninsta;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;

import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class ListViewAdapter extends BaseAdapter{

	Context context;
	String[] username;
	String[] date;
	String[] description;
	int[] photos;
	int[] fashy;
	int[] tacky;
	LayoutInflater inflater;
	ImageButton fashybutton;
	ImageButton tackybutton;
	
	
	public ListViewAdapter(Context context, String[] username, String[] date, String[] description, int[] photos, int[] fashy, int[] tacky){
		this.context = context;
		this.username = username;
		this.description = description;
		this.date = date;
		this.photos = photos;
		this.fashy = fashy;
		this.tacky = tacky;
	}
	
	@Override
    public int getCount() {
        return photos.length;
    }
 
    @Override
    public Object getItem(int position) {
        return null;
    }
 
    @Override
    public long getItemId(int position) {
        return 0;
    }
 
    public View getView(int position, View convertView, ViewGroup parent) {
 
        // Declare Variables
        TextView txtusername;
        TextView txtdate;
        TextView txtdescription;
        TextView txtfashy;
        TextView txttacky;
        ImageView imgphotos;
 
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
 
        final View itemView = inflater.inflate(R.layout.fashionspread, parent, false);
 
        // Locate the TextViews in listview_item.xml
        txtusername = (TextView) itemView.findViewById(R.id.username);
        txtdate = (TextView) itemView.findViewById(R.id.date);
        txtdescription = (TextView) itemView.findViewById(R.id.description);
        txtfashy = (TextView) itemView.findViewById(R.id.fashy);
        txttacky = (TextView) itemView.findViewById(R.id.tacky);
        
        
        // Locate the ImageView in listview_item.xml
        imgphotos = (ImageView) itemView.findViewById(R.id.photos);
 
        // Capture position and set to the TextViews
        txtusername.setText(username[position]);
        txtdate.setText(date[position]);
        txtdescription.setText(description[position]);
        txtfashy.setText(String.valueOf(fashy[position]));
        txttacky.setText(String.valueOf(tacky[position]));
 
        // Capture position and set to the ImageView
        imgphotos.setImageResource(photos[position]);
        
       
	        fashybutton = (ImageButton) itemView.findViewById(R.id.fashyic);
			fashybutton.setOnClickListener(new OnClickListener(){
				   @Override
				   public void onClick(View v) {
					   TextView fashytextview = (TextView) itemView.findViewById(R.id.fashy);
					   int num = Integer.valueOf(fashytextview.getText().toString());
					   num++;
					   fashytextview.setText(String.valueOf(num));
				   };
				   
				
			});
			
			fashybutton = (ImageButton) itemView.findViewById(R.id.tackyic);
			fashybutton.setOnClickListener(new OnClickListener(){
				   @Override
				   public void onClick(View v) {
					   TextView fashytextview = (TextView) itemView.findViewById(R.id.tacky);
					   int num = Integer.valueOf(fashytextview.getText().toString());
					   num++;
					   fashytextview.setText(String.valueOf(num));
				   };
				   
				
			});
			
			
	        return itemView;
        }
    
}
