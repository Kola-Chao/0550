package com.sxkj.a0550.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.sxkj.a0550.R;
import com.sxkj.a0550.activity.base.BaseActivity;

import butterknife.BindView;

/**
 * Introduce:
 * Author：mac
 * Date：2017/3/6
 * Time: 上午10:55
 */

public class MineInfoActivity extends BaseActivity implements AppBarLayout.OnOffsetChangedListener {
    @BindView(R.id.mine_info_toolbarlayout)
    Toolbar mineInfoToolbarlayout;

    @Override
    public void initLayout() {
        setContentView(R.layout.mine_info_main);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initToolBar();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /**
     * 初始化toolbar
     */
    private void initToolBar() {
        mineInfoToolbarlayout.inflateMenu(R.menu.menu_main);
    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {

    }
}
