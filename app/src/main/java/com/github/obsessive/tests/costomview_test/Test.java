package com.github.obsessive.tests.costomview_test;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.github.obsessive.tests.R;
import com.github.obsessive.tests.eventbuss.MessageEvent;
import com.github.obsessive.tests.sheji_moshhi.Servicesss;

import org.greenrobot.eventbus.EventBus;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Test extends AppCompatActivity {
    ExecutorService executorService;
    private ImageView mImageCosTset;
   String imageUrl="http://ubmcmm.baidustatic.com/media/v1/0f0005r3Sn4W7C6nKpTj40.gif";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        initView();


    }

    public void send_info(View view) {
        Intent i=new Intent(this,Servicesss.class);
        startService(i);
//        start_thread();
//        start_thread2();
//        start_thread3();
//        start_thread4();
    }

    private void initView() {
        mImageCosTset = (ImageView) findViewById(R.id.image_cos_tset);
        Glide.with(getApplicationContext()).load(imageUrl).placeholder(R.mipmap.ic_launcher).error(R.mipmap.bg_view1).into(mImageCosTset);

         executorService=Executors.newSingleThreadExecutor();

    }
            private  void start_thread(){
                executorService.submit(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < 100; i++) {
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            Log.i("qwe","这是啥"+i);
                        }
                    }
                });
            }
    private  void start_thread2(){
                executorService.submit(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < 100; i++) {
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            Log.i("qwe","这是啥2"+i);
                        }
                    }
                });
            }private  void start_thread3(){
                executorService.submit(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < 100; i++) {
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            Log.i("qwe","这是啥3"+i);
                        }
                    }
                });
            }private  void start_thread4() {
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Log.i("qwe", "这是啥4" + i);
                }
            }
        });
    }

}
