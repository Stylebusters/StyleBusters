package com.example.fashioninsta;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class ColorCombiView extends View{

	Paint paint1;
   
	public ColorCombiView(Context context) {
        super(context);
        init();
    }   
    public ColorCombiView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    public void init() {
        paint1 = new Paint();
        paint1.setColor(Color.RED); 
    }       
    protected void onDraw(Canvas canvas) {
        //super.onDraw(canvas);         
        canvas.drawCircle(50, 50, 25, paint1);
        this.draw(canvas);  
    }
}
