package ydys.jinou.com.view.activity;

import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Paint;
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
    private AlertDialog dialog2;
    private AlertDialog dialog3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initView() {
        setActivityTitle("设置");
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
                final AlertDialog.Builder builder = new AlertDialog.Builder(this);
                View view = View
                        .inflate(this, R.layout.alertdialog1_view_layout, null);
                builder.setView(view);
                builder.setCancelable(true);
                TextView title= (TextView) view
                        .findViewById(R.id.title);//设置标题

                final TextView message = view.findViewById(R.id.message);
                TextView fuzhi = view.findViewById(R.id.fuzhi);
                TextView guanbi = view.findViewById(R.id.guanbi);
                fuzhi.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ClipboardManager cmb  = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                        cmb.setText(message.getText().toString());
                        Toast.makeText(SettingActivity.this,"已复制到粘贴板",Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
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
                final AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
                View view2 = View
                        .inflate(this, R.layout.alertdialog2_view_layout, null);
                builder2.setView(view2);
                builder2.setCancelable(true);
                TextView text_ydys = view2.findViewById(R.id.text_ydys);
                TextView text_jinou = view2.findViewById(R.id.text_jinou);
                text_ydys.getPaint().setFlags(Paint. UNDERLINE_TEXT_FLAG );
                text_jinou.getPaint().setFlags(Paint. UNDERLINE_TEXT_FLAG );
                TextView text_guanbi = view2.findViewById(R.id.text_guanbi);

                dialog2 = builder2.create();
                text_guanbi.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog2.dismiss();
                        Toast.makeText(SettingActivity.this,"关于",Toast.LENGTH_SHORT).show();
                    }
                });
                dialog2.show();
                break;
            case R.id.relative_fankui:
                final AlertDialog.Builder builder3 = new AlertDialog.Builder(this);
                View view3 = View
                        .inflate(this, R.layout.alertdialog3_view_layout, null);
                builder3.setView(view3);
                builder3.setCancelable(true);
                EditText edit_text_youxiang = view3.findViewById(R.id.edit_text_youxiang);
                EditText edit_text_fankui = view3.findViewById(R.id.edit_text_fankui);
                Button btn_ly = view3.findViewById(R.id.btn_ly);
                Button btn_quxiao = view3.findViewById(R.id.btn_quxiao);
                Button btn_fasong = view3.findViewById(R.id.btn_fasong);
                TextView text_shouji_xiangqing = view3.findViewById(R.id.text_shouji_xiangqing);
                text_shouji_xiangqing.setText( android.os.Build.MODEL +"   "+android.os.Build.MANUFACTURER+ "    ("
                        + android.os.Build.VERSION.RELEASE+")");
                dialog3 = builder3.create();
                btn_quxiao.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog3.dismiss();
                    }
                });
                String youxiang = edit_text_youxiang.getText().toString();
                String fankui = edit_text_fankui.getText().toString();
                if (!fankui.equals("") && !youxiang.equals("")){
                    btn_fasong.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog3.dismiss();
                        }
                    });
                }
                dialog3.setCancelable(false);
                dialog3.show();
                Toast.makeText(this,"反馈",Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    protected boolean isHideTitle() {
        return false;
    }
}
