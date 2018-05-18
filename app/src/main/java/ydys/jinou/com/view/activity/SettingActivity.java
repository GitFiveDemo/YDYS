package ydys.jinou.com.view.activity;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.OnClick;
import ydys.jinou.com.R;
import ydys.jinou.com.view.base.BaseActivity;

public class SettingActivity extends BaseActivity{

    @BindView(R.id.relative_tuijie)
    RelativeLayout relativeTuijie;
    @BindView(R.id.relative_qingchu)
    RelativeLayout relativeQingchu;
    @BindView(R.id.relative_guanyu)
    RelativeLayout relativeGuanyu;
    @BindView(R.id.relative_fankui)
    RelativeLayout relativeFankui;
    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initView() {
        titleTv.setText("设置");
    }

    @Override
    protected void initDate() {

    }

    @Override
    protected View getChildView() {
        return View.inflate(this, R.layout.activity_setting, null);
    }

    /*@Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.relative_tuijie:
                Toast.makeText(this,"推介",Toast.LENGTH_SHORT).show();
                break;
            case R.id.relative_qingchu:
                break;
            case R.id.relative_guanyu:
                break;
            case R.id.relative_fankui:
                break;
        }
    }*/

    @OnClick({R.id.relative_tuijie,R.id.relative_qingchu,R.id.relative_guanyu,R.id.relative_fankui})
    public void sayHi(View v){
        switch (v.getId()){
            case R.id.relative_tuijie:
                /*AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("发现一个看片神器");
                builder.setMessage("https://github.com/GeekGhost/Ghost");
                builder.setNegativeButton("关闭",null);
                builder.setPositiveButton("复制",null);
                builder.show();*/
                final AlertDialog.Builder builder = new AlertDialog.Builder(this);
                View view = View
                        .inflate(this, R.layout.alertdialog_view_layout, null);
                builder.setView(view);
                builder.setCancelable(true);
                TextView title= (TextView) view
                        .findViewById(R.id.title);//设置标题

                TextView message = view.findViewById(R.id.message);
                TextView fuzhi = view.findViewById(R.id.fuzhi);
                TextView guanbi = view.findViewById(R.id.guanbi);
                fuzhi.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(SettingActivity.this,"复制好了",Toast.LENGTH_SHORT).show();
                    }
                });

                //取消或确定按钮监听事件处理
                dialog = builder.create();
                guanbi.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
                break;
            case R.id.relative_qingchu:
                Toast.makeText(this,"清理",Toast.LENGTH_SHORT).show();
                break;
            case R.id.relative_guanyu:
                Toast.makeText(this,"关于",Toast.LENGTH_SHORT).show();
                break;
            case R.id.relative_fankui:
                Toast.makeText(this,"反馈",Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    protected boolean isHideTitle() {
        return false;
    }
}
