package com.github.obsessive.tests.AdapterViewFileper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterViewFlipper;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;

import com.github.obsessive.tests.R;

public class ViewFileper_test extends AppCompatActivity implements View.OnClickListener{
    private int[] Images = {R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher};
    private AdapterViewFlipper adapterViewFlipper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_fileper_test);
        initView();
    }
    private  void initView(){
        adapterViewFlipper = (AdapterViewFlipper) findViewById(R.id.adapterviewfllipper);
        Button button1 = (Button) findViewById(R.id.Button51);
        Button button2 = (Button) findViewById(R.id.Button52);
        Button button3 = (Button) findViewById(R.id.Button53);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        BaseAdapter baseAdapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return Images.length;
            }
            @Override
            public Object getItem(int position) {
                return position;
            }
            @Override
            public long getItemId(int position) {
                return position;
            }
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                ImageView imageView = new ImageView(ViewFileper_test.this);
                imageView.setImageResource(Images[position]);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

                return imageView;
            }
        };
        adapterViewFlipper.setAdapter(baseAdapter);
    }
    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.Button51:
                adapterViewFlipper.stopFlipping();
                adapterViewFlipper.showPrevious();
                break;
            case R.id.Button52:
                adapterViewFlipper.startFlipping();
                break;
            case R.id.Button53:
                adapterViewFlipper.stopFlipping();
                adapterViewFlipper.showNext();
                break;
        }
    }

}
