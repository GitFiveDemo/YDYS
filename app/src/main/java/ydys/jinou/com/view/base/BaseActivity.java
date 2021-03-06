package ydys.jinou.com.view.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jaeger.library.StatusBarUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import ydys.jinou.com.R;
import ydys.jinou.com.util.CommonUtil;
import ydys.jinou.com.view.activity.MainActivity;

/**
 * author: 晨光光
 * date : 2018/5/16 19:01
 */
public abstract class BaseActivity extends AppCompatActivity {

    private Unbinder bind;
    @BindView(R.id.base_title_tv)
    TextView titleTv;
    @BindView(R.id.base_back_img)
    ImageView backImage;
    @BindView(R.id.base_title_bar)
    RelativeLayout titleBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        init();
        bind = ButterKnife.bind(this);
        initView();
        initDate();

        // 是否隐藏标题
        if (isHideTitle()) titleBar.setVisibility(View.GONE);
    }

    // 设置标题
    protected void setActivityTitle(String titleStr) {
        titleTv.setText(titleStr);
    }

    private void init() {
        backImage = findViewById(R.id.base_back_img);
        titleTv = findViewById(R.id.base_title_tv);
        backImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                titleBackClick();
            }
        });


        FrameLayout frameLayout = findViewById(R.id.base_frame);
        View childView = getChildView();
        if (childView != null)
            // throw new NullPointerException("childView is null");
            frameLayout.addView(childView);
    }

    // 初始化view
    protected abstract void initView();

    // 初始化数据
    protected abstract void initDate();

    // 获取activity的布局
    protected abstract View getChildView();

    // 点击返回键的执行的方法
    protected void titleBackClick() {
        finish();
    }

    protected abstract boolean isHideTitle();

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onResume() {
        super.onResume();
        int themeColor = CommonUtil.obtainColorValue();
        if (themeColor != -1) {
            StatusBarUtil.setColor(this, themeColor);
            if (getChildView() != null)
                getChildView().setBackgroundColor(themeColor);
        }
        setTitleColorStyle();
    }

    protected void setTitleColorStyle() {
        int colorStyle = CommonUtil.obtainColorValue();
        if (colorStyle != -1)
            titleBar.setBackgroundColor(colorStyle);
    }
}
