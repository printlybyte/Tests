package com.github.obsessive.tests.luyin;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.github.obsessive.tests.R;
import com.github.obsessive.tests.eventbuss.event_tests;

import java.util.Timer;
import java.util.TimerTask;

import static com.github.obsessive.tests.luyin.RecordView.MODEL_PLAY;

public class luyin_test extends AppCompatActivity  implements View.OnTouchListener,View.OnClickListener {
    private RecordView mRecorfView;
    private Button button;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            int db = (int) (Math.random()*100);
            mRecorfView.setVolume(db);
        }
    };
    private int nowModel = RecordView.MODEL_RECORD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luyin_test);
        button= (Button) findViewById(R.id.button3);
        findViewById(R.id.button).setOnTouchListener(this);
        mRecorfView = (RecordView) findViewById(R.id.recordView);
        mRecorfView.setCountdownTime(9);
        mRecorfView.setModel(RecordView.MODEL_RECORD);
        findViewById(R.id.button2).setOnClickListener(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),event_tests.class);
                startActivity(intent);
            }
        });
    }
    private TimerTask timeTask;
    private Timer timeTimer = new Timer(true);

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            mRecorfView.start();
            timeTimer.schedule(timeTask = new TimerTask() {
                public void run() {
                    Message msg = new Message();
                    msg.what = 1;
                    handler.sendMessage(msg);
                }
            }, 20, 20);
            mRecorfView.setOnCountDownListener(new RecordView.OnCountDownListener() {
                @Override
                public void onCountDown() {
                    Toast.makeText(luyin_test.this,"计时结束啦~~",Toast.LENGTH_SHORT).show();
                }
            });
        }else if(event.getAction() == MotionEvent.ACTION_UP){
            mRecorfView.cancel();
        }
        return false;
    }

    @Override
    public void onClick(View v) {
        if(nowModel == MODEL_PLAY){
            mRecorfView.setModel(RecordView.MODEL_RECORD);
            nowModel = RecordView.MODEL_RECORD;
        }else{
            mRecorfView.setModel(MODEL_PLAY);
            nowModel = MODEL_PLAY;
        }
    }
}
