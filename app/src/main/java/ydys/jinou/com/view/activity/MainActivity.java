package ydys.jinou.com.view.activity;


import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.iflytek.cloud.ErrorCode;
import com.iflytek.cloud.InitListener;
import com.iflytek.cloud.RecognizerListener;
import com.iflytek.cloud.RecognizerResult;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.SpeechRecognizer;
import com.iflytek.cloud.SpeechUtility;
import com.iflytek.cloud.ui.RecognizerDialog;
import com.iflytek.cloud.ui.RecognizerDialogListener;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.LinkedHashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ydys.jinou.com.R;
import ydys.jinou.com.broadcast.NetBroadcastReceiver;
import ydys.jinou.com.util.JsonParser;
import ydys.jinou.com.view.custom.CircleImageView;
import ydys.jinou.com.view.custom.slide.SlideLayout;
import ydys.jinou.com.view.fragment.FancyFragment;
import ydys.jinou.com.view.fragment.HomeFragment;
import ydys.jinou.com.view.fragment.MineFragment;
import ydys.jinou.com.view.fragment.SpecialFragment;


public class MainActivity extends AppCompatActivity {
    @BindView(R.id.main_bottom_bar)
    BottomNavigationBar mainBottomBar;
    @BindView(R.id.main_title)
    TextView mainTitle;
    @BindView(R.id.sideLayout)
    SlideLayout sideLayout;
    @BindView(R.id.main_frame)
    FrameLayout mainFrame;
    @BindView(R.id.menu_user_icon)
    CircleImageView menuUserIcon;
    @BindView(R.id.menu_user_remark)
    TextView menuUserRemark;
    private FragmentManager supportFragmentManager;
    private HomeFragment homeFragment;
    private SpecialFragment specialFragment;
    private FancyFragment fancyFragment;
    private MineFragment mineFragment;
    private NetBroadcastReceiver netBroadcastReceiver;

    //显示听写结果
    private TextView textView;
    //语音听写对象
    private SpeechRecognizer speechRecognizer;
    //语音听写UI
    private RecognizerDialog recognizerDialog;
    //是否显示听写UI
    private boolean isShowDialog = true;
    //缓存
    private SharedPreferences sharedPreferences;
    //用hashmap存储听写结果
    private HashMap<String, String> hashMap = new LinkedHashMap<>();
    //引擎类型（云端或本地）
    private String mEngineType = null;
    //函数返回值
    private int ret = 0;
    Toast toast;

    //有UI监听器
    private RecognizerDialogListener dialogListener = new RecognizerDialogListener() {
        @Override
        public void onResult(RecognizerResult recognizerResult, boolean b) {
            if (recognizerResult != null) {
                Log.e("tag", "听写结果：" + recognizerResult.getResultString());
                printResult(recognizerResult);
            }
        }

        @Override
        public void onError(SpeechError speechError) {
            Log.e("tag", speechError.getPlainDescription(true));

        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
        initBottomMenu();

        // 是否关闭首页的自动轮播
        sideLayout.setPanelSlideListener(new SlideLayout.PanelSlideListener() {
            @Override
            public void onPanelOpened() {
                EventBus.getDefault().post(1);
            }

            @Override
            public void onPanelClosed() {
                EventBus.getDefault().post(-1);
            }

            @Override
            public void onPanelSlide(float percent) {
                EventBus.getDefault().post(0);
            }
        });
    }


    //点击返回两次退出app
    private long exitTime = 0;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK
                && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                //弹出提示，可以有多种方式
                Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                finish();
            }
            return false;
        }

        return super.onKeyDown(keyCode, event);
    }

    private void init() {
        // 获取Fragment管理者
        supportFragmentManager = getSupportFragmentManager();
        // 默认显示homeFragment
        homeFragment = new HomeFragment();
        supportFragmentManager.beginTransaction().add(R.id.main_frame, homeFragment).commit();

        // 首页默认隐藏 titlebar
        mainTitle.setVisibility(View.GONE);

        initDateXunFei();
    }

    private void initBottomMenu() {

        /**
         * 初始化底部选项卡 添加item
         */
        mainBottomBar.setMode(BottomNavigationBar.MODE_FIXED);
        mainBottomBar.setBackgroundResource(R.drawable.bottom_bg);
        mainBottomBar.addItem(new BottomNavigationItem(R.drawable.found, "精选"))
                .addItem(new BottomNavigationItem(R.drawable.special, "专题"))
                .addItem(new BottomNavigationItem(R.drawable.fancy, "发现"))
                .addItem(new BottomNavigationItem(R.drawable.my, "我的"))
                .setFirstSelectedPosition(0)
                .initialise();//所有的设置需在调用该方法前完成

        /**
         * 底部选项卡的监听事件
         */
        mainBottomBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {//这里也可以使用SimpleOnTabSelectedListener
            @Override
            public void onTabSelected(int position) {//未选中 -> 选中
                hideAllFragments();
                FragmentTransaction toggleTransaction = supportFragmentManager.beginTransaction();
                int backgroundColor = Color.parseColor("#00ACA0");
                String titleStr = "精选";
                boolean isHideTitle = false;
                switch (position) {
                    case 0:
                        isHideTitle = true;
                        toggleTransaction.show(homeFragment);

                        break;
                    case 1:
                        if (specialFragment == null) {
                            specialFragment = new SpecialFragment();
                            toggleTransaction.add(R.id.main_frame, specialFragment);
                        } else {
                            toggleTransaction.show(specialFragment);
                        }

                        backgroundColor = Color.parseColor("#7B1FA2");
                        titleStr = "专题";
                        break;
                    case 2:
                        if (fancyFragment == null) {
                            fancyFragment = new FancyFragment();
                            toggleTransaction.add(R.id.main_frame, fancyFragment);
                        } else {
                            toggleTransaction.show(fancyFragment);
                        }

                        backgroundColor = Color.parseColor("#FF5252");
                        titleStr = "发现";
                        break;
                    case 3:
                        if (mineFragment == null) {
                            mineFragment = new MineFragment();
                            toggleTransaction.add(R.id.main_frame, mineFragment);
                        } else {
                            toggleTransaction.show(mineFragment);
                        }

                        backgroundColor = Color.parseColor("#FF9800");
                        titleStr = "我的";
                        break;
                }
                if (isHideTitle) {
                    mainTitle.setVisibility(View.GONE);
                } else {
                    mainTitle.setVisibility(View.VISIBLE);
                    mainTitle.setText(titleStr);
                }

                mainTitle.setBackgroundColor(backgroundColor);

                toggleTransaction.commit();
            }

            @Override
            public void onTabUnselected(int position) {//选中 -> 未选中
            }

            @Override
            public void onTabReselected(int position) {//选中 -> 选中
            }
        });

    }

    /**
     * 隐藏所有的Fragment
     */
    private void hideAllFragments() {
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        if (homeFragment != null) fragmentTransaction.hide(homeFragment);
        if (specialFragment != null) fragmentTransaction.hide(specialFragment);
        if (mineFragment != null) fragmentTransaction.hide(mineFragment);
        if (fancyFragment != null) fragmentTransaction.hide(fancyFragment);
        fragmentTransaction.commit();
    }

    @OnClick({R.id.menu_user_icon, R.id.menu_user_collect, R.id.menu_user_download, R.id.menu_user_boon, R.id.menu_user_share, R.id.menu_user_advise, R.id.menu_user_setting, R.id.menu_user_about1, R.id.menu_user_about2, R.id.menu_user_theme1, R.id.menu_user_theme2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.menu_user_icon:
            case R.id.menu_user_download:
                Toast.makeText(this, "敬请期待", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_user_collect:
                break;
            case R.id.menu_user_boon:
                startActivity(new Intent(this, BoonActivity.class));
                break;
            case R.id.menu_user_share:
                break;
            case R.id.menu_user_advise: // 一个弹框 集成讯飞
                showDiglog();
                break;
            case R.id.menu_user_setting:// 跳转设置 drawable
                startActivity(new Intent(this, SettingActivity.class));
                break;
            case R.id.menu_user_about1:
            case R.id.menu_user_about2: // 弹框

                break;
            case R.id.menu_user_theme1: // 弹框 选择主题
            case R.id.menu_user_theme2:
                break;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        // 注册广播
        if (netBroadcastReceiver == null) {
            netBroadcastReceiver = new NetBroadcastReceiver();
            IntentFilter filter = new IntentFilter();
            // filter.addAction(WifiManager.WIFI_STATE_CHANGED_ACTION);
            filter.addAction(WifiManager.NETWORK_STATE_CHANGED_ACTION);
            // filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
            registerReceiver(netBroadcastReceiver, filter);
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (netBroadcastReceiver != null) {
            // 注销广播
            unregisterReceiver(netBroadcastReceiver);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        // 关闭侧滑
        if (sideLayout.isOpened()) {
            sideLayout.close();
        }
    }

    public void showDiglog() {
        final AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
        View alertView = View.inflate(this, R.layout.alertdialog3_view_layout, null);
                
        alertBuilder.setView(alertView);
        alertBuilder.setCancelable(true);
        EditText edit_text_youxiang = alertView.findViewById(R.id.edit_text_youxiang);
        EditText edit_text_fankui = alertView.findViewById(R.id.edit_text_fankui);
        textView = edit_text_fankui;
        Button btn_ly = alertView.findViewById(R.id.btn_ly);
        Button btn_quxiao = alertView.findViewById(R.id.btn_quxiao);
        Button btn_fasong = alertView.findViewById(R.id.btn_fasong);
        TextView phoneInfoTv = alertView.findViewById(R.id.text_shouji_xiangqing);

        String phoneInfo = android.os.Build.MODEL + "   " + android.os.Build.MANUFACTURER + "    ("
                + android.os.Build.VERSION.RELEASE + ")";

        btn_ly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xunFeiStart();
                Toast.makeText(MainActivity.this, "反馈", Toast.LENGTH_SHORT).show();
            }
        });
        phoneInfoTv.setText(phoneInfo);
        
        final AlertDialog alertDialog = alertBuilder.create();
        btn_quxiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
        String youxiang = edit_text_youxiang.getText().toString();
        String fankui = edit_text_fankui.getText().toString();
        if (!fankui.equals("") && !youxiang.equals("")) {
            btn_fasong.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    alertDialog.dismiss();
                }
            });
        }
        alertDialog.setCancelable(false);
        alertDialog.show();
    }

    private void initDateXunFei() {
        //初始化sdk 将自己申请的appid放到下面
        //此句代码应该放在application中的，这里为了方便就直接放代码中了
      //  SpeechUtility.createUtility(this, "appid=5ae0845d");
        speechRecognizer = SpeechRecognizer.createRecognizer(this, initListener);
        Log.e("speechRecognizer","---->"+speechRecognizer);
        recognizerDialog = new RecognizerDialog(this, initListener);
        sharedPreferences = getSharedPreferences(this.getPackageName(), Context.MODE_PRIVATE);
        toast = Toast.makeText(this, "", Toast.LENGTH_SHORT);
        //这里我直接将引擎类型设置为云端，因为本地需要下载讯飞语记，这里为了方便直接使用云端
        //有需要的朋友可以加个单选框 让用户选择云端或本地
        mEngineType = SpeechConstant.TYPE_CLOUD;
    }

    //开始听写
    public void xunFeiStart() {
        textView.setText("");
        hashMap.clear();
        setParams();

        if (isShowDialog) {
            recognizerDialog.setListener(dialogListener);
            recognizerDialog.show();
        } else {
            ret = speechRecognizer.startListening(recognizerListener);
            if (ret != ErrorCode.SUCCESS) {
                Log.e("tag", "听写失败,错误码" + ret);
            }
        }
    }

    //结束听写
    public void stop() {
        Toast.makeText(this, "停止听写", Toast.LENGTH_SHORT).show();
        if (isShowDialog) {
            recognizerDialog.dismiss();
        } else {
            speechRecognizer.stopListening();
        }
    }

    //初始化监听器
    private InitListener initListener = new InitListener() {
        @Override
        public void onInit(int i) {
            if (i != ErrorCode.SUCCESS) {
                Log.e("tag", "初始化失败，错误码" + i);
            }
        }
    };

    //无UI监听器
    private RecognizerListener recognizerListener = new RecognizerListener() {
        @Override
        public void onVolumeChanged(final int i, byte[] bytes) {
            Log.e("tag", "返回数据大小" + bytes.length);
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    toast.setText("当前音量" + i);
                }
            });
        }

        @Override
        public void onBeginOfSpeech() {
            Log.e("tag", "开始说话");
        }

        @Override
        public void onEndOfSpeech() {
            Log.e("tag", "结束说话");
        }

        @Override
        public void onResult(RecognizerResult recognizerResult, boolean b) {
            if (recognizerResult != null) {
                Log.e("tag", "听写结果：" + recognizerResult.getResultString());
                printResult(recognizerResult);
            }

        }

        @Override
        public void onError(SpeechError speechError) {
            Log.e("tag", "错误信息" + speechError.getPlainDescription(true));
            if (isShowDialog) {
                recognizerDialog.dismiss();
            } else {
                speechRecognizer.stopListening();
            }
        }

        @Override
        public void onEvent(int i, int i1, int i2, Bundle bundle) {
            // 以下代码用于获取与云端的会话id，当业务出错时将会话id提供给技术支持人员，可用于查询会话日志，定位出错原因
            // 若使用本地能力，会话id为null
            //  if (SpeechEvent.EVENT_SESSION_ID == eventType) {
            //      String sid = obj.getString(SpeechEvent.KEY_EVENT_SESSION_ID);
            //      Log.d(TAG, "session id =" + sid);
            //  }
        }
    };



    //输出结果，将返回的json字段解析并在textVie中显示
    private void printResult(RecognizerResult results) {
        String text = JsonParser.parseIatResult(results.getResultString());
        String sn = null;
        // 读取json结果中的sn字段
        try {
            JSONObject resultJson = new JSONObject(results.getResultString());
            sn = resultJson.optString("sn");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        hashMap.put(sn, text);

        StringBuffer resultBuffer = new StringBuffer();
        for (String key : hashMap.keySet()) {
            resultBuffer.append(hashMap.get(key));
        }

        textView.setText(resultBuffer.toString());
    }

    private void setParams() {
        //清空参数
//        speechRecognizer.setParameter(SpeechConstant.PARAMS, null);
        //设置引擎
        speechRecognizer.setParameter(SpeechConstant.ENGINE_TYPE, mEngineType);
        //设置返回数据类型
        speechRecognizer.setParameter(SpeechConstant.RESULT_TYPE, "json");
        //设置中文 普通话
        speechRecognizer.setParameter(SpeechConstant.LANGUAGE, "zh_cn");
        speechRecognizer.setParameter(SpeechConstant.ACCENT, "mandarin");

        // 设置语音前端点:静音超时时间，即用户多长时间不说话则当做超时处理
        speechRecognizer.setParameter(SpeechConstant.VAD_BOS,
                sharedPreferences.getString("iat_vadbos_preference", "4000"));

        // 设置语音后端点:后端点静音检测时间，即用户停止说话多长时间内即认为不再输入， 自动停止录音
        speechRecognizer.setParameter(SpeechConstant.VAD_EOS,
                sharedPreferences.getString("iat_vadeos_preference", "1000"));

        // 设置标点符号,设置为"0"返回结果无标点,设置为"1"返回结果有标点
        speechRecognizer.setParameter(SpeechConstant.ASR_PTT,
                sharedPreferences.getString("iat_punc_preference", "0"));

        // 设置音频保存路径，保存音频格式支持pcm、wav，设置路径为sd卡请注意WRITE_EXTERNAL_STORAGE权限
        // 注：AUDIO_FORMAT参数语记需要更新版本才能生效
        speechRecognizer.setParameter(SpeechConstant.AUDIO_FORMAT, "wav");
        speechRecognizer.setParameter(SpeechConstant.ASR_AUDIO_PATH,
                Environment.getExternalStorageDirectory() + "/msc/iat.wav");
    }
}
