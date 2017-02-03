package com.sxkj.a0550.activity.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import butterknife.Unbinder;

/**
 * Created by mac on 2017/1/26.
 */

public class BaseActivity extends FragmentActivity {
    protected Context mContext;
    protected Unbinder unbinder;
    protected String TAG = "TestTang";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (unbinder != null) {
            unbinder.unbind();
        }
    }
}
