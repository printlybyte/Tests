package com.github.obsessive.tests.Search_listviiew;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.View;

import com.github.obsessive.tests.R;

public class Search_list extends AppCompatActivity implements View.OnClickListener {

    private SearchView mSearchView;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_list);
        initView();
    }

    private void initView() {
        mSearchView = (SearchView) findViewById(R.id.search_view);
        mSearchView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.search_view:
                break;

        }
    }
}
