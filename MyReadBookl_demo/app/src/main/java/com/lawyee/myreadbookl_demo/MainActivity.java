package com.lawyee.myreadbookl_demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.lawyee.myreadbookl_demo.weight.CustomView;
import com.lawyee.myreadbookl_demo.weight.CustomViewS;
import com.lawyee.myreadbookl_demo.weight.CustomsView;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{

    private CustomView mCustomView;
    private LinearLayout mActivityMain;
    private CustomViewS mShowProgress;
    private CustomsView mProgressCirle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mCustomView = (CustomView) findViewById(R.id.CustomView);
        mActivityMain = (LinearLayout) findViewById(R.id.activity_main);

        mCustomView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });

        mShowProgress = (CustomViewS) findViewById(R.id.showProgress);
        mShowProgress.setOnClickListener(this);
        mProgressCirle = (CustomsView) findViewById(R.id.progressCirle);
        mProgressCirle.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch(view.getId())
        { case R.id.CustomView :
             startActivity(new Intent(MainActivity.this,Main2Activity.class));
              break;
         case R.id.progressCirle:
              startActivity(new Intent(MainActivity.this,Main3Activity.class));
            break;
         case R.id.showProgress:
              startActivity(new Intent(MainActivity.this,Main4Activity.class));
            break;
          default:
              break;
        }
    }
}
