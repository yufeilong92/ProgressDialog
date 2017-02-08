package com.lawyee.myreadbookl_demo.weight;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;

import com.lawyee.myreadbookl_demo.R;

/**
 * @Author : YFL  is Creating a porject in YFPHILPS
 * @Email : yufeilong92@163.com
 * @Time :2017/2/8 10:47
 * @Purpose :
 */
public class CustomView extends View {

    private BitmapShader shader;
    private Paint paint;

    public CustomView(Context context) {
        super(context);
        paint = new Paint();
    }

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
    }

    public CustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint = new Paint();
        paint.setAntiAlias(true);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(400,400);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int w= getWidth();
        int h=getHeight();

        int radius=w<=h?w/2:h/2;



        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.a);

//     1
  Bitmap result = Bitmap.createScaledBitmap(bitmap, w, h, false);

        shader = new BitmapShader(result, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);

        paint.setTextSize(40.0f);
        paint.setColor(Color.RED);
        paint.setTypeface(Typeface.DEFAULT);
        paint.setShader(shader);
//     1
        canvas.drawCircle(w/2,h/2,radius,paint);
//      canvas.drawText("小妞",0,h/2,paint);
    }
}
