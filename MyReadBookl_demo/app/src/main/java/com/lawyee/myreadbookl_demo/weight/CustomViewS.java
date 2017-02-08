package com.lawyee.myreadbookl_demo.weight;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.View;

/**
 * @Author : YFL  is Creating a porject in YFPHILPS
 * @Email : yufeilong92@163.com
 * @Time :2017/2/8 11:23
 * @Purpose :
 */
public class CustomViewS extends View{

    private Paint paint;
    private Shader mshader;

    public CustomViewS(Context context) {
        super(context);
        paint = new Paint();
    }

    public CustomViewS(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
    }

    public CustomViewS(Context context, AttributeSet attrs, int defStyleAttr) {
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
        int w=getWidth();
        int h= getHeight();
//        mshader = new LinearGradient(0, 0, w, 0,Color.parseColor("#faf84d"),
//                Color.parseColor("#cc423c"), Shader.TileMode.CLAMP);
//        mshader = new LinearGradient(0,0,w,0,new int[]{Color.parseColor("#faf84d"),Color.parseColor("#003449"),
//                Color.parseColor("#808080"),
//                Color.parseColor("#CC423C")},null,Shader.TileMode.CLAMP);
 /*      paint.setShader(mshader);
        canvas.drawRect(0,0,w,h/2,paint);*/
/*        mshader = new RadialGradient(w/2,h/2,w/2, Color.parseColor("#faf84d"),
                Color.parseColor("#CC423C"), Shader.TileMode.CLAMP);*/
      /*  mshader = new RadialGradient(w/2,h/2,w/2,new int[]{Color.parseColor("#00aa00"),Color.parseColor("#880033"),
                Color.parseColor("#F8795A"),
                Color.parseColor("#CC423C")},new float[]{0.0f,0.2f,0.8f,1.0f}, Shader.TileMode.CLAMP);
*/
        mshader = new SweepGradient(w/2,h/2,Color.RED, Color.BLUE);
        paint.setShader(mshader);
        canvas.drawRect(0,0,w,h,paint);

    }
}
