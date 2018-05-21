package ydys.jinou.com.util;

import android.content.SharedPreferences;
import android.util.Log;

import ydys.jinou.com.application.YDApplication;

public class SharePrenFace {
    public static final String TAG = "Dash";//sp文件的xml名称
    private static SharedPreferences sharedPreferences;
    public static void saveString(String flag, String str) {
        if (sharedPreferences == null) {
            sharedPreferences = YDApplication.getAppContext().getSharedPreferences(TAG, YDApplication.getAppContext().MODE_PRIVATE);
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(flag, str);
        edit.commit();
    }
    public static String getString(String flag) {
        if (sharedPreferences == null) {
            sharedPreferences = YDApplication.getAppContext().getSharedPreferences(TAG, YDApplication.getAppContext().MODE_PRIVATE);
        }
        return sharedPreferences.getString(flag, "");
    }

    public static boolean getBoolean(String tag) {
        if (sharedPreferences == null) {
            sharedPreferences = YDApplication.getAppContext().getSharedPreferences(TAG, YDApplication.getAppContext().MODE_PRIVATE);
        }
        return sharedPreferences.getBoolean(tag, false);
    }

    public static void putBoolean(String tag, boolean content) {
        if (sharedPreferences == null) {
            sharedPreferences = YDApplication.getAppContext().getSharedPreferences(TAG, YDApplication.getAppContext().MODE_PRIVATE);
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putBoolean(tag, content);
        edit.commit();
    }

    public static void clearSp() {
        if (sharedPreferences == null) {
            sharedPreferences = YDApplication.getAppContext().getSharedPreferences(TAG, YDApplication.getAppContext().MODE_PRIVATE);
        }
        boolean isClear = sharedPreferences.edit().clear().commit();

        Log.e("AAA","是否清空"+isClear);
    }
}
