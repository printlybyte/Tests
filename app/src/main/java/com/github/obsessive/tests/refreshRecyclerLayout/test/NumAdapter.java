package com.github.obsessive.tests.refreshRecyclerLayout.test;

import android.content.Context;

import com.github.obsessive.tests.R;
import com.github.obsessive.tests.refreshRecyclerLayout.Adapter.SWRecyclerAdapter;
import com.github.obsessive.tests.refreshRecyclerLayout.Adapter.SWViewHolder;

import java.util.List;

/**
 * Created by liuguodong on 2017/4/7.
 */

public class NumAdapter extends SWRecyclerAdapter<String> {

    private List<String> list;
    private Context context;

    public NumAdapter(Context context, List<String> list) {
        super(context, list);
        this.context = context;
        this.list = list;
    }

    @Override
    public int getItemLayoutId(int viewType) {
        return R.layout.item;
    }

    @Override
    public void bindData(SWViewHolder holder, int position, String item) {
        holder.getTextView(R.id.text).setText(list.get(position)+"");
    }
}