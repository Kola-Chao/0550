package com.sxkj.a0550.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.sxkj.a0550.R;
import com.sxkj.a0550.activity.base.BaseActivity;
import com.sxkj.a0550.vp.MyViewPageAdapter;
import com.sxkj.a0550.vp.ParallaxPageTransformer;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * Introduce: 闪屏页
 * Author：mac
 * Date：2017/1/27
 * Time: 下午12:05
 */

public class SplashActivity extends BaseActivity {


    @BindView(R.id.splash_vp)
    ViewPager splashVp;
    @BindView(R.id.splash_btn)
    Button splashBtn;

    private ViewPager.PageTransformer transformer;
    private MyViewPageAdapter adapter;
    private ArrayList<View> views;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initFakeViews();
        initVP();
    }

    @Override
    public void initLayout() {
        setContentView(R.layout.splashlayout);
    }

    /**
     * 初始化假的页面数据
     */
    private void initFakeViews() {
        views = new ArrayList<>();
        //前面添加一个
        View view0 = getLayoutInflater().inflate(R.layout.splash_item, null);
        ((ImageView) view0.findViewById(R.id.img_item)).setImageResource(R.drawable.splash_4);
        View view1 = getLayoutInflater().inflate(R.layout.splash_item, null);
        ((ImageView) view1.findViewById(R.id.img_item)).setImageResource(R.drawable.splash_1);
        View view2 = getLayoutInflater().inflate(R.layout.splash_item, null);
        ((ImageView) view2.findViewById(R.id.img_item)).setImageResource(R.drawable.splash_2);
        View view3 = getLayoutInflater().inflate(R.layout.splash_item, null);
        ((ImageView) view3.findViewById(R.id.img_item)).setImageResource(R.drawable.splash_3);
        View view4 = getLayoutInflater().inflate(R.layout.splash_item, null);
        ((ImageView) view4.findViewById(R.id.img_item)).setImageResource(R.drawable.splash_4);
        View view5 = getLayoutInflater().inflate(R.layout.splash_item, null);
        ((ImageView) view5.findViewById(R.id.img_item)).setImageResource(R.drawable.splash_1);
        views.add(view0);
        views.add(view1);
        views.add(view2);
        views.add(view3);
        views.add(view4);
        views.add(view5);

    }

    /**
     * 初始化ViewPager页面
     */
    private void initVP() {
        adapter = new MyViewPageAdapter(views);
        transformer = new ParallaxPageTransformer();
        splashVp.setPageTransformer(true, transformer);
        splashVp.setAdapter(adapter);
        splashVp.setCurrentItem(1);
        splashVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            int p;

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == (views.size() - 1)) {
                    p = 1;
                } else if (position == 0) {
                    p = (views.size() - 2);
                } else {
                    p = position;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if (ViewPager.SCROLL_STATE_IDLE == state)
                    splashVp.setCurrentItem(p, false);
            }
        });
    }

    @OnClick({R.id.splash_btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.splash_btn:
                startActivity(new Intent(this, MainActivity.class));
                break;
            default:
                break;
        }
    }
}
