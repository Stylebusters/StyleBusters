package com.example.fashioninsta;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
 
public class CustomListViewAdapter extends ArrayAdapter<RowItem> {
 
    Context context;
    ArrayList<Bitmap> arr_bitmaps;
    ArrayList<String> friendsAddedYou;
 
    public CustomListViewAdapter(Context context, int resourceId,
            List<RowItem> items) {
        super(context, resourceId, items);
        this.context = context;
    }
    
    /*public CustomListViewAdapter(Context context, ArrayList<Bitmap> arr_bitmaps, ArrayList<String> friendsAddedYou) {
    	
        this.arr_bitmaps=arr_bitmaps;
        this.friendsAddedYou=friendsAddedYou;
        this.context = context;
    }*/
 
    /*private view holder class*/
    private class ViewHolder {
        ImageView imageView;
        TextView txtName;
        TextView txtDesc;
    }
 
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        RowItem rowItem = getItem(position);
 
        LayoutInflater mInflater = (LayoutInflater) context
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_layout, null);
            holder = new ViewHolder();
            holder.txtName = (TextView) convertView.findViewById(R.id.nameAdded);
            holder.txtDesc = (TextView) convertView.findViewById(R.id.addedDesc);
            holder.imageView = (ImageView) convertView.findViewById(R.id.item_icon);
            convertView.setTag(holder);
        } else
            holder = (ViewHolder) convertView.getTag();
 
       holder.txtDesc.setText(rowItem.getDesc());
        holder.txtName.setText(rowItem.getTitle());
        holder.imageView.setImageResource(rowItem.getImageId());
 
        return convertView;
    }
}