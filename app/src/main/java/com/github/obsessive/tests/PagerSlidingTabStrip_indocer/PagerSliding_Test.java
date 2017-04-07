package com.github.obsessive.tests.PagerSlidingTabStrip_indocer;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.github.obsessive.tests.R;

import java.util.ArrayList;
import java.util.List;

public class PagerSliding_Test extends AppCompatActivity {
    private TabLayout tab_FindFragment_title;                            //定义TabLayout
    private ViewPager vp_FindFragment_pager;                             //定义viewPager
    private FragmentPagerAdapter fAdapter;                               //定义adapter

    private List<Fragment> list_fragment;                                //定义要装fragment的列表
    private List<String> list_title;                                     //tab名称列表

    private BlankFragment hotRecommendFragment;              //热门推荐fragment
    private BlankFragment2 hotCollectionFragment;            //热门收藏fragment
    private BlankFragment3 hotMonthFragment;                      //本月热榜fragment
    private BlankFragment4 blankFragment4;                      //本月热榜fragment
    private BlankFragment5 blankFragment5;                      //本月热榜fragment
    private BlankFragment6 blankFragment6;                      //本月热榜fragment
    private BlankFragment7 blankFragment7;                      //本月热榜fragment

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager_sliding__test);
        initControls();
    }

    private void initControls() {

        tab_FindFragment_title = (TabLayout) findViewById(R.id.tab_FindFragment_title);
        vp_FindFragment_pager = (ViewPager) findViewById(R.id.vp_FindFragment_pager);

        //初始化各fragment
        hotRecommendFragment = new BlankFragment();
        hotCollectionFragment = new BlankFragment2();
        hotMonthFragment = new BlankFragment3();
        blankFragment4 = new BlankFragment4();
        blankFragment5 = new BlankFragment5();
        blankFragment6 = new BlankFragment6();
        blankFragment7 = new BlankFragment7();

        //将fragment装进列表中
        list_fragment = new ArrayList<>();
        list_fragment.add(hotRecommendFragment);
        list_fragment.add(hotCollectionFragment);
        list_fragment.add(hotMonthFragment);
        list_fragment.add(blankFragment4);
        list_fragment.add(blankFragment5);
        list_fragment.add(blankFragment6);
        list_fragment.add(blankFragment7);

        //将名称加载tab名字列表，正常情况下，我们应该在values/arrays.xml中进行定义然后调用
        list_title = new ArrayList<>();
        list_title.add("热门推荐");
        list_title.add("热门收藏");
        list_title.add("本月热榜");
        list_title.add("本月热榜");
        list_title.add("本月热榜");
        list_title.add("本月热榜");
        list_title.add("本月热榜");

        //设置TabLayout的模式
        tab_FindFragment_title.setTabMode(TabLayout.MODE_SCROLLABLE);
        //为TabLayout添加tab名称
        tab_FindFragment_title.addTab(tab_FindFragment_title.newTab().setText(list_title.get(0)));
        tab_FindFragment_title.addTab(tab_FindFragment_title.newTab().setText(list_title.get(1)));
        tab_FindFragment_title.addTab(tab_FindFragment_title.newTab().setText(list_title.get(2)));
        tab_FindFragment_title.addTab(tab_FindFragment_title.newTab().setText(list_title.get(3)));
        tab_FindFragment_title.addTab(tab_FindFragment_title.newTab().setText(list_title.get(4)));
        tab_FindFragment_title.addTab(tab_FindFragment_title.newTab().setText(list_title.get(5)));
        tab_FindFragment_title.addTab(tab_FindFragment_title.newTab().setText(list_title.get(6)));

        fAdapter = new Find_tab_Adapter(PagerSliding_Test.this.getSupportFragmentManager(), list_fragment, list_title);

        //viewpager加载adapter
        vp_FindFragment_pager.setAdapter(fAdapter);
        //tab_FindFragment_title.setViewPager(vp_FindFragment_pager);
        //TabLayout加载viewpager
        tab_FindFragment_title.setupWithViewPager(vp_FindFragment_pager);
        //tab_FindFragment_title.set
    }


}

