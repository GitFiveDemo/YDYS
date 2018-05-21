package ydys.jinou.com.application;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Point;
import android.os.Handler;
import android.os.Process;
import android.view.WindowManager;

import com.facebook.drawee.backends.pipeline.Fresco;

import retrofit2.http.HEAD;

/**
 * author: 晨光光
 * date : 2018/5/16 19:08
 */
public class YDApplication extends Application {
    public final static float DESIGN_WIDTH = 720; //绘制页面时参照的设计图宽度
    private static int myTid;
    private static Handler handler;
    private static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        resetDensity();//注意不要漏掉
        //初始化frsco
        Fresco.initialize(this);
        myTid = Process.myTid();
        handler = new Handler();
        context = getApplicationContext();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        resetDensity();//这个方法重写也是很有必要的
    }
    public static Context getAppContext() {
        return context;
    }
    public void resetDensity() {
        Point size = new Point();
        ((WindowManager) getSystemService(WINDOW_SERVICE)).getDefaultDisplay().getSize(size);
        getResources().getDisplayMetrics().xdpi = size.x / DESIGN_WIDTH * 72f;
    }

    public static int getMyTid() {
        return myTid;
    }

    public static Handler getHandler() {
        return handler;
    }
}
