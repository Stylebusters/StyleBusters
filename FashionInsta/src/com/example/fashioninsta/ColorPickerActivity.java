package com.example.fashioninsta;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ColorPickerActivity extends Activity implements ColorPickerDialog.OnColorChangedListener {
	/** Called when the activity is first created. */
	private Paint mPaint; 
	Button colorbutton;
	ImageButton imagechangebutton;
	ImageButton imagechangebutton1;
	ImageButton imagebottomchange;
	ImageButton saveimagebutton;
	ImageButton gallerybutton;
	ImageView clothesimage;
	private int[] image;
	int imageview;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_color);
		mPaint = new Paint();
		image = new int[] {R.drawable.tshirtfinal, R.drawable.strapfinal, R.drawable.skirt1, R.drawable.shortpants, R.drawable.longpants};
		// on button click
		//ColorPickerView(Context c, OnColorChangedListener l, int color, int defaultColor)


		gallerybutton = (ImageButton) findViewById(R.id.gallery);
		gallerybutton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				Context context = v.getContext();
				Intent intent = new Intent(context, GalleryActivity.class);
				context.startActivity(intent);
			}

		});


		saveimagebutton = (ImageButton) findViewById(R.id.saveimage);
		saveimagebutton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				//Bundle extras = new Bundle();
				ImageView imageView1 = (ImageView) findViewById(R.id.topimage);
				imageView1.buildDrawingCache();
				Bitmap bitmap1 = imageView1.getDrawingCache();

				Intent intent = new Intent(v.getContext(), GalleryActivity.class);
				intent.putExtra("topimage", bitmap1);
				
				Intent i = new Intent(v.getContext(), GalleryActivity.class);
				//Bundle b = new Bundle();
				//b.putExtra("topimage", bitmap1);
				//i.putExtras(b);
				

				ImageView imageView2 = (ImageView) findViewById(R.id.bottomimage);
				imageView2.buildDrawingCache();
				Bitmap bitmap2 = imageView2.getDrawingCache();

				Intent intent2 = new Intent(v.getContext(), GalleryActivity.class);
				//intent.putExtra("bottomimage", bitmap2);

				if(bitmap1== null){
					Toast.makeText(v.getContext(),"bitmap1 null", Toast.LENGTH_LONG).show();
				}else if(bitmap2 == null){
					Toast.makeText(v.getContext(),"bitmap2 null", Toast.LENGTH_LONG).show();
				}else{
				Toast.makeText(v.getContext(),"Image has been saved", Toast.LENGTH_LONG).show();
				}

			}

		});

		imagechangebutton = (ImageButton) findViewById(R.id.tshirt);
		imagechangebutton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				imageview= R.id.topimage;
				ImageView nextimage = (ImageView) findViewById(imageview);
				nextimage.setImageResource(image[0]);
			}

		});



		imagechangebutton1 = (ImageButton) findViewById(R.id.strap);
		imagechangebutton1.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {

				imageview= R.id.topimage;
				ImageView nextimage = (ImageView) findViewById(imageview);
				nextimage.setImageResource(image[1]);
				// Drawable myDrawable = getResources().getDrawable(image[1]);
				// Bitmap anImage = ((BitmapDrawable) myDrawable).getBitmap();
			}

		});

		imagebottomchange = (ImageButton) findViewById(R.id.skirt);
		imagebottomchange.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				imageview= R.id.bottomimage;
				ImageView nextimage = (ImageView) findViewById(imageview);
				nextimage.setImageResource(image[2]);
			}

		});

		imagebottomchange = (ImageButton) findViewById(R.id.shortpants);
		imagebottomchange.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				imageview= R.id.bottomimage;
				ImageView nextimage = (ImageView) findViewById(imageview);
				nextimage.setImageResource(image[3]);
			}

		});

		imagebottomchange = (ImageButton) findViewById(R.id.longpants);
		imagebottomchange.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				imageview= R.id.bottomimage;
				ImageView nextimage = (ImageView) findViewById(imageview);
				nextimage.setImageResource(image[4]);
			}

		});

		clothesimage = (ImageView) findViewById(R.id.topimage);
		clothesimage.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				imageview= R.id.topimage;
				new ColorPickerDialog(ColorPickerActivity.this, ColorPickerActivity.this,"", Color.WHITE).show();

			}

		});

		clothesimage = (ImageView) findViewById(R.id.bottomimage);
		clothesimage.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				imageview= R.id.bottomimage;
				new ColorPickerDialog(ColorPickerActivity.this, ColorPickerActivity.this,"", Color.WHITE).show();

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


	@Override  
	public void colorChanged(String str,int color) {    
		ColorPickerActivity.this.findViewById(imageview).setBackgroundColor(color);  
	}  

	Activity activity;  

	public void getColor(View v) {  
		new ColorPickerDialog(activity, this, "", Color.BLACK).show();   
	}  
}  

