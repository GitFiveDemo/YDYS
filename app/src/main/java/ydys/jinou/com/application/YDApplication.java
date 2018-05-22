package ydys.jinou.com.application;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Point;
import android.os.Handler;
import android.os.Process;
import android.view.WindowManager;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechUtility;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreater;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;

import retrofit2.http.HEAD;
import ydys.jinou.com.R;

/**
 * author: 晨光光
 * date : 2018/5/16 19:08
 */
public class YDApplication extends Application {
    public final static float DESIGN_WIDTH = 720; //绘制页面时参照的设计图宽度
    private static int myTid;
    private static Context context;
    private static Handler handler;
    @Override
    public void onCreate() {
        super.onCreate();
        resetDensity();//注意不要漏掉
        //初始化frsco
        Fresco.initialize(this);
        myTid = Process.myTid();
        handler = new Handler();
        context = getApplicationContext();
        //设置全局的Header构建器
        SmartRefreshLayout.setDefaultRefreshHeaderCreater(new DefaultRefreshHeaderCreater() {
            @Override
            public RefreshHeader createRefreshHeader(Context context, RefreshLayout layout) {
                layout.setPrimaryColorsId(R.color.colorPrimary, android.R.color.white);//全局设置主题颜色
                return new ClassicsHeader(context).setSpinnerStyle(SpinnerStyle.Translate);//指定为经典Header，默认是 贝塞尔雷达Header
            }
        });
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        resetDensity();//这个方法重写也是很有必要的
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
    public static Context getAppContext(){
        return context;
    };
}
