package com.github.obsessive.tests.sheji_moshhi;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

/**
 * Created by liuguodong on 2017/4/13.
 */

public class Servicesss extends IntentService {
  static final String a="aaa";
    public Servicesss() {
        super(a);

    }

    @Override
    protected void onHandleIntent(Intent intent) {
        for (int i = 0; i < 10; i++) {
            Log.i("qwe","这是啥innn"+i);
        }
    }
}
