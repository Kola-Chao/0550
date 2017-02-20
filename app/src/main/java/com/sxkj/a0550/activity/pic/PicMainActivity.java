package com.sxkj.a0550.activity.pic;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.sxkj.a0550.R;


/**
 * Introduce:
 * Author  : tangchao
 * Date   :2017/2/20
 * Time   :15:45
 */

public class PicMainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pic_main);
    }

    public void showLikedSnackbar() {
        Toast.makeText(this, "like", Toast.LENGTH_SHORT).show();
    }
}
