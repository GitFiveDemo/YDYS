package ydys.jinou.com.application;

import android.app.Application;
import android.content.res.Configuration;
import android.graphics.Point;
import android.view.WindowManager;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * author: 晨光光
 * date : 2018/5/16 19:08
 */
public class YDApplication extends Application {
    public final static float DESIGN_WIDTH = 720; //绘制页面时参照的设计图宽度

    @Override
    public void onCreate() {
        super.onCreate();
        resetDensity();//注意不要漏掉
        //初始化frsco
        Fresco.initialize(this);
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
}
