package com.github.obsessive.tests.refreshRecyclerLayout.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;

import com.github.obsessive.tests.R;
import com.github.obsessive.tests.refreshRecyclerLayout.Layout.SWPullRecyclerLayout;
import com.github.obsessive.tests.refreshRecyclerLayout.interfacee.OnTouchUpListener;

import java.util.ArrayList;
import java.util.List;

public class Rrfresh_Test extends AppCompatActivity  implements OnTouchUpListener {
    private SWPullRecyclerLayout recycler;
    private View header;
    private View footer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rrfresh__test);
        inital();
    } private void inital() {
        recycler = (SWPullRecyclerLayout) findViewById(R.id.recycler);
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            list.add(i + 1 + "");
        }
        header= LayoutInflater.from(this).inflate(R.layout.header,null);
        footer= LayoutInflater.from(this).inflate(R.layout.footer,null);
        recycler.addHeaderView(header,100);
        recycler.addFooterView(footer,100);
        NumAdapter adapter = new NumAdapter(this, list);
        recycler.setMyRecyclerView(new LinearLayoutManager(this), adapter);
        recycler.addOnTouchUpListener(this);
    }

    @Override
    public void touchUp() {
        if (recycler.getTotal() >= 100) {
            recycler.setScrollTo(recycler.getTotal(), 100);
            if (!recycler.isScrollRefresh()) {
                recycler.setIsScrollRefresh(true);
            }
        } else if (-recycler.getTotal() >= 100) {
            recycler.setScrollTo(recycler.getTotal(), -100);
            if (!recycler.isScrollLoad()) {
            }
        } else {
            recycler.setScrollTo(0, 0);
        }
    }


}
