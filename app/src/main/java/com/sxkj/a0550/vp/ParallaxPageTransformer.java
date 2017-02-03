package com.sxkj.a0550.vp;

import android.support.v4.view.ViewPager;
import android.view.View;

import static android.R.attr.id;

/**
 * Introduce: viewpager的滑动动画
 * Author：mac
 * Date：2017/1/27
 * Time: 下午9:09
 */

public class ParallaxPageTransformer implements ViewPager.PageTransformer {
    private int speed = 100;
    private int border = 10;

    @Override
    public void transformPage(View view, float position) {
        View parallaxView = view.findViewById(id);
        if (parallaxView != null) {
            if (position > -1 && position < 1) {
                float width = parallaxView.getWidth();
                parallaxView.setTranslationX(-(position * width * speed));
                float sc = ((float) view.getWidth() - border) / view.getWidth();
                if (position == 0) {//这里处理了缩放的效果，去掉即和Yahoo天气的效果一样
                    view.setScaleX(1);
                    view.setScaleY(1);
                } else {
                    view.setScaleX(sc);
                    view.setScaleY(sc);
                }
            }
        }
    }
}
