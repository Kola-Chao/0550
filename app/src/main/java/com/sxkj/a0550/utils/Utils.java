package com.sxkj.a0550.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * 作者：author
 * 时间：2017/1/26:下午4:19
 * 说明：
 */

public class Utils {
    public static Context mcxt;

    public static void showToast(String string, Context context) {
        if (mcxt == null) return;
        Toast.makeText(context, string, Toast.LENGTH_SHORT);
    }

    public static void showToast(String string) {
        if (mcxt == null) return;
        Toast.makeText(mcxt, string, Toast.LENGTH_SHORT).show();
    }

}
