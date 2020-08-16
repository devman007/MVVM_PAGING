package com.mvvm.paginglib.utils;

import android.util.Log;

import com.mvvm.paginglib.BuildConfig;

public class UtilsMethods {

    public static void mLog(String mKey, String mValue) {
        if (BuildConfig.DEBUG) {
            Log.d("mLog:" + mKey, mValue);
        }
    }

}
