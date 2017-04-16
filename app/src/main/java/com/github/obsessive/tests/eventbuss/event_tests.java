package com.github.obsessive.tests.eventbuss;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.github.obsessive.tests.R;
import com.github.obsessive.tests.costomview_test.Test;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class event_tests extends AppCompatActivity implements View.OnClickListener {

    int aee[] = {4, 5, 55, 5, 5, 52, 51};
    /**
     * 点我
     */

    Thread thread1, thread2;
    private Button mEvsBtnTest;
    private TextView mEvsTxtTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_tests);

        initView();

    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }


    private void initView() {
        mEvsBtnTest = (Button) findViewById(R.id.evs_btn_test);
        mEvsBtnTest.setOnClickListener(this);
        mEvsTxtTest = (TextView) findViewById(R.id.evs_txt_test);
        mEvsTxtTest.setOnClickListener(this);
        mEvsTxtTest.setText("点我");



    }

        public void asa(){}
    public void getNum(int b) {

        for (int i = b; i < 10; i++) {
            b = i + 1;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Log.i("qweq", "" + b);
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.evs_btn_test:
                EventBus.getDefault().post(new MessageEvent("this wao "));
                break;
            case R.id.evs_txt_test:
                int ayy[] = getArray(aee);

                for (int i = 0; i < ayy.length; i++) {
                    Log.i("qwea", " " + ayy[i] + " ");
                }
                break;
        }
    }

    private int[] getArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        return arr;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void ONonMoonEvent(MessageEvent messageEvent) {
        Toast.makeText(this, "" + messageEvent.getMessage() + "AA", Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
