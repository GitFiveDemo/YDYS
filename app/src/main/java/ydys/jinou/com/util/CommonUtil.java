package ydys.jinou.com.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Process;

import ydys.jinou.com.application.YDApplication;
import ydys.jinou.com.model.key.SharedKey;

/**
 * author: 晨光光
 * date : 2018/5/18 17:13
 */
public class CommonUtil {

    private static SharedPreferences sharedPreferences;

    public static void runUiThread(Runnable runnable) {
        if (Process.myTid() == YDApplication.getMyTid()) {
            runnable.run();
        } else {
            YDApplication.getHandler().post(runnable);
        }
    }


    private static void getSharePreference() {
        if (sharedPreferences == null)
            sharedPreferences = YDApplication.getAppContext().getSharedPreferences("cgShared", Context.MODE_PRIVATE);
    }

    public static void saveColorValue(int color) {
        getSharePreference();
        sharedPreferences.edit().putInt(SharedKey.COLOR_KEY, color).commit();
    }

    public static int obtainColorValue() {
        getSharePreference();
        return sharedPreferences.getInt(SharedKey.COLOR_KEY, -1);
    }
}
