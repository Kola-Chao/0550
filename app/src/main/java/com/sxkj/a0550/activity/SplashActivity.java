package com.sxkj.a0550.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.view.ViewPager;

import com.sxkj.a0550.R;
import com.sxkj.a0550.activity.base.BaseActivity;

import butterknife.BindView;


/**
 * Introduce: 闪屏页
 * Author：mac
 * Date：2017/1/27
 * Time: 下午12:05
 */

public class SplashActivity extends BaseActivity {


    @BindView(R.id.splash_vp)
    ViewPager splashVp;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.splashlayout);
        initVP();
    }

    /**
     * 初始化ViewPager页面
     */
    private void initVP() {
//        splashVp.
    }

}
