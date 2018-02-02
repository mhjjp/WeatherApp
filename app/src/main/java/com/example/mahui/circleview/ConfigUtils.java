package com.example.mahui.circleview;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;

/**
 * Created by Jeff on 2015/9/10.
 */
public class ConfigUtils {

    public static int devicesWidth; // 设备宽度
    public static int devicesHeight; // 设备高度

    /**
     * 获取屏幕设备高度
     *
     * @param context
     * @return
     */
    public static int getDeviceHeight(Activity context) {
        if (ConfigUtils.devicesHeight == 0) {
            DisplayMetrics metrics = new DisplayMetrics();
            WindowManager wm = context.getWindowManager();
            wm.getDefaultDisplay().getMetrics(metrics);
            ConfigUtils.devicesHeight = metrics.heightPixels;
        }
        return ConfigUtils.devicesHeight;
    }

    /**
     * 获取屏幕设备宽度
     *
     * @param context
     * @return
     */
    public static int getDeviceWidth(Activity context) {
        try {
            if (ConfigUtils.devicesWidth == 0) {
                WindowManager wm = (WindowManager) context
                        .getSystemService(Context.WINDOW_SERVICE);
                int width = wm.getDefaultDisplay().getWidth();

                ConfigUtils.devicesWidth = width;
            }
            return ConfigUtils.devicesWidth;
        } catch (Exception ex) {
            Log.e("ConfigUtils", "获取屏幕尺寸出错：" + ex.getMessage(), ex);
            return 0;
        }
    }

    public static boolean haveInternet(ContextWrapper context) {

        ConnectivityManager mConnectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
        if (mNetworkInfo != null) {
            Log.i("网络判断", "haveInternet: "+mNetworkInfo.isAvailable()+"==="+mNetworkInfo.isConnected());
            return mNetworkInfo.isAvailable() && mNetworkInfo.isConnected();
        }else{
            return false;
        }
    }


    public static String GetVersionName(Context context) {
        PackageManager nPackageManager = context.getPackageManager();// 得到包管理器
        try {
            PackageInfo nPackageInfo = nPackageManager.getPackageInfo(context.getPackageName(), PackageManager.GET_CONFIGURATIONS);
            return nPackageInfo.versionName;// 得到现在app的版本号
        } catch (PackageManager.NameNotFoundException e1) {
            return "";
        }
    }

    public static int GetVersionCode(Context context) {
        PackageManager nPackageManager = context.getPackageManager();// 得到包管理器
        try {
            PackageInfo nPackageInfo = nPackageManager.getPackageInfo(context.getPackageName(), PackageManager.GET_CONFIGURATIONS);
            return nPackageInfo.versionCode;// 得到现在app的版本号
        } catch (PackageManager.NameNotFoundException e1) {
            return 0;
        }
    }

}
