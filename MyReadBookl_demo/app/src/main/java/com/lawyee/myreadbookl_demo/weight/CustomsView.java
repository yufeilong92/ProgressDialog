package com.lawyee.myreadbookl_demo.weight;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposeShader;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

import com.lawyee.myreadbookl_demo.R;

/**
 * @Author : YFL  is Creating a porject in YFPHILPS
 * @Email : yufeilong92@163.com
 * @Time :2017/2/8 11:40
 * @Purpose :
 */
public class CustomsView extends View {

    private Paint mPaint;

    public CustomsView(Context context) {
        super(context);
        mPaint = new Paint();
    }

    public CustomsView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();

    }

    public CustomsView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(400,400);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int w = getWidth();
        int h = getHeight();
        int radius = w <= h ? w/2 : h/2;


        Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.a);
        Bitmap result = Bitmap.createScaledBitmap(bmp,w,h,false);
        //1. 编写1个BitmapShader.
        BitmapShader bitmapShader = new BitmapShader(result, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);

        //2. 编写1个RadiasGradient。
        RadialGradient radialGradient = new RadialGradient(radius,radius,radius, Color.BLACK,Color.TRANSPARENT, Shader.TileMode.CLAMP);
        //3. 将它们进行混合产生新的Shader.
        ComposeShader composeShader = new ComposeShader(bitmapShader,radialGradient,new PorterDuffXfermode(PorterDuff.Mode.DST_IN));

        mPaint.setShader(composeShader);
        //4. 以新的Shader绘制一个圆。
        canvas.drawCircle(w/2,h/2,radius,mPaint);
    }
}
