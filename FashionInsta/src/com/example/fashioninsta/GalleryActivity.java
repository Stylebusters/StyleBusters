package com.example.fashioninsta;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.Toast;

public class GalleryActivity extends Activity {

	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Intent intent = getIntent();
		//Bundle extras = intent.getExtras(); 

		Bitmap bitmap = (Bitmap) intent.getParcelableExtra("topimage");
		
		Bitmap bitmap1 = (Bitmap) intent.getParcelableExtra("bottomimage");
		//Bundle extras = getIntent().getExtras();
		//Bitmap bmp = (Bitmap) extras.getParcelable("imagebitmap");
		if(bitmap == null){
			Toast.makeText(this,"is null", Toast.LENGTH_LONG).show();
		}
		/*Drawable drawable1 = (Drawable)new BitmapDrawable(bitmap);
		Drawable drawable2 = (Drawable)new BitmapDrawable(bitmap1);
		Drawable[] layers = new Drawable[2];
		layers[0] = drawable1;
		layers[1]= drawable2;
		LayerDrawable ld = new LayerDrawable(layers);*/
		/*ImageView image = (ImageView) findViewById(R.id.galleryimage);
		image.setImageBitmap(bitmap);
		setContentView(R.layout.gallery);*/
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.gallery, menu);
		return true;
	}

}
