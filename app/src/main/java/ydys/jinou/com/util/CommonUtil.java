package ydys.jinou.com.util;

import android.os.Process;

/**
 * author: 晨光光
 * date : 2018/5/18 17:13
 */
public class CommonUtil {

    public static void runUiThread(Runnable runnable){
        if (Process.myTid() == YDApplication.getMyTid()){
            runnable.run();
        }else{
            YDApplication.getHandler().post(runnable);
        }
    }
}
