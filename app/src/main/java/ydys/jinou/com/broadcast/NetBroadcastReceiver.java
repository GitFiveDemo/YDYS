package ydys.jinou.com.broadcast;

/**
 * author: 晨光光
 * date : 2018/5/17 20:59
 */

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import ydys.jinou.com.util.NetUtils;

public class NetBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        boolean networkConnected = NetUtils.isNetworkConnected(context);
        if (networkConnected) {
            int netWorkType = NetUtils.getNetWorkType(context);
            switch (netWorkType) {
                case NetUtils.NETWORKTYPE_2G:
                    Log.e("onReceive", "NETWORKTYPE_2G");
                    break;
                case NetUtils.NETWORKTYPE_3G:
                    Log.e("onReceive", "NETWORKTYPE_3G");
                    break;
                case NetUtils.NETWORKTYPE_INVALID:
                    Log.e("onReceive", "NETWORKTYPE_INVALID");
                    break;
                case NetUtils.NETWORKTYPE_WAP:
                    Log.e("onReceive", "NETWORKTYPE_WAP");
                    break;
                case NetUtils.NETWORKTYPE_WIFI:
                    Log.e("onReceive", "NETWORKTYPE_WIFI");
                    break;
            }
            Log.e("onReceive", "netWorkType");
        } else {
            Log.e("onReceive", "网络未连接");
        }
    }


}
