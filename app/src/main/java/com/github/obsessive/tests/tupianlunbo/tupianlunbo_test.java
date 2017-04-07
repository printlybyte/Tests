package com.github.obsessive.tests.tupianlunbo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.github.obsessive.tests.R;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

public class tupianlunbo_test extends AppCompatActivity {
    List<Integer> mList = new ArrayList<>();
    List<String> mList2 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tupianlunbo_test);
        mList.add(R.mipmap.bg_verify);
        mList.add(R.mipmap.ic_launcher);
        mList.add(R.mipmap.bg_verify_press);
        mList.add(R.mipmap.ic_launcher);
        mList2.add("1");
        mList2.add("2");
        mList2.add("3");
        mList2.add("4");

        Banner banner = (Banner) findViewById(R.id.banner);
        //设置banner样式
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(mList);
        //设置banner动画效果
        banner.setBannerAnimation(Transformer.DepthPage);
        //设置标题集合（当banner样式有显示title时）
        banner.setBannerTitles(mList2);
        //设置自动轮播，默认为true
        banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(1500);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.CENTER);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                switch (position) {
                    case 1:
                        Toast.makeText(tupianlunbo_test.this, "1", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(tupianlunbo_test.this, "2", Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                }
            }
        });
    }
}
