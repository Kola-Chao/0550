package com.sxkj.a0550.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sxkj.a0550.R;

/**
 * Introduce:
 * Author：mac
 * Date：2017/3/4
 * Time: 下午4:27
 */

public class FavoriteFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_favorite, container, false);

        return view;
    }
}
