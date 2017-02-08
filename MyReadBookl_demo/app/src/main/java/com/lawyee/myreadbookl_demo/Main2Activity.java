package com.lawyee.myreadbookl_demo;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;

public class Main2Activity extends AppCompatActivity {

    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initData();
    }

    private void initData() {
        Progress("下载数据中", "请稍等......");
    }
    private void Progress(String title ,String message){

        mProgressDialog = new ProgressDialog(this);
        updateThread thread= new updateThread();
        mProgressDialog.setProgressStyle(mProgressDialog.STYLE_HORIZONTAL);
        mProgressDialog.setMessage(message);
        mProgressDialog.setTitle(title);
        mProgressDialog.setProgress(0);
        mProgressDialog.setMax(100);
        mProgressDialog.show();
        thread.start();
    }

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            // TODO Auto-generated method stub
            if(msg.what>=100){
                mProgressDialog.cancel();
            }
            mProgressDialog.setProgress(msg.what);
            super.handleMessage(msg);
        }

    };

    class updateThread extends Thread{
        public void run(){
            handler.sendEmptyMessage(0);
            try {
                updateThread.sleep(1000);
                handler.sendEmptyMessage(10);
                updateThread.sleep(1000);
                handler.sendEmptyMessage(20);
                updateThread.sleep(1000);
                handler.sendEmptyMessage(30);
                updateThread.sleep(1000);
                handler.sendEmptyMessage(40);
                updateThread.sleep(1000);
                handler.sendEmptyMessage(50);
                updateThread.sleep(1000);
                handler.sendEmptyMessage(60);
                updateThread.sleep(1000);
                handler.sendEmptyMessage(70);
                updateThread.sleep(1000);
                handler.sendEmptyMessage(80);
                updateThread.sleep(1000);
                handler.sendEmptyMessage(100);
                updateThread.sleep(1000);

            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
    };
}