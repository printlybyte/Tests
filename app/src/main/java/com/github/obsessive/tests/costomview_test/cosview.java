package com.github.obsessive.tests.costomview_test;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;

import com.github.obsessive.tests.R;

/**
 * Created by liuguodong on 2017/4/9.
 */

public class cosview extends TextView {
    private String titleText;
    private int titleColor;
    private int titleSize;

    public cosview(Context context) {
        super(context);
    }

    public cosview(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    public cosview(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray array=context.obtainStyledAttributes(attrs,R.styleable.cosview,defStyleAttr,0);

    }
}
