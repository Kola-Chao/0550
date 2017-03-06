package com.sxkj.a0550.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.XmlRes;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import com.sxkj.a0550.R;
import com.sxkj.a0550.utils.EmptyUtils;

/**
 * Introduce:
 * Author：mac
 * Date：2017/3/4
 * Time: 下午5:14
 */

public class NativeBottomView extends LinearLayout implements View.OnClickListener, View.OnLongClickListener {
    //布局使用的参数
    private int xmlResource;

    public NativeBottomView(Context context) {
        this(context, null);
    }

    public NativeBottomView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public NativeBottomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    /**
     * 初始化View
     *
     * @param context
     * @param attrs
     */
    private void init(Context context, AttributeSet attrs) {
        populateAttributes(context, attrs);
        if (xmlResource != 0) {
            setItems(xmlResource);
        }
    }


    /**
     * 填充配置
     */
    private void populateAttributes(Context context, AttributeSet attrs) {
        if (EmptyUtils.isEmpty(attrs)) {
            TypedArray ta = context.getTheme().obtainStyledAttributes(attrs, R.styleable.NativeBottomView, 0, 0);
            try {
                xmlResource = ta.getResourceId(R.styleable.NativeBottomView_bb_xmlResource, 0);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                ta.recycle();
            }

        } else {
            return;
        }
    }

    /**
     * 设置bottom bar 的item
     *
     * @param xmlResource
     */
    private void setItems(@XmlRes int xmlResource) {
        if (xmlResource == 0) {
            throw new RuntimeException("没有设置好的布局文件");
        }
//        TabParser parser = new TabParser(getContext(), xmlResource);
//        updateItems(parser.getTabs());

    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public boolean onLongClick(View view) {
        return false;
    }
}
