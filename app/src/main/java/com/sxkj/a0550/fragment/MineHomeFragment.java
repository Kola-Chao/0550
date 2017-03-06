package com.sxkj.a0550.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.sxkj.a0550.R;
import com.sxkj.a0550.activity.MineInfoActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Introduce:
 * Author：mac
 * Date：2017/3/6
 * Time: 上午10:37
 */

public class MineHomeFragment extends Fragment {

    @BindView(R.id.user_info_layout)
    RelativeLayout userInfoLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_minehome, container, false);

        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.user_info_layout)
    public void onClick() {
        startActivity(new Intent(getActivity(), MineInfoActivity.class));
    }
}
