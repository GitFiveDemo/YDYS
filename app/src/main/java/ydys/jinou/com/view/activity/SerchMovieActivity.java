package ydys.jinou.com.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ydys.jinou.com.R;
import ydys.jinou.com.util.SharePrenFace;
import ydys.jinou.com.view.adapter.ListAdapet;
import ydys.jinou.com.view.base.BaseActivity;

public class SerchMovieActivity extends BaseActivity {


    @BindView(R.id.serch_movies)
    EditText serchMovies;
    @BindView(R.id.qx)
    TextView qx;
    @BindView(R.id.clear)
    ImageView clear;
    List<String> list = new ArrayList<>();
    @BindView(R.id.lv)
    ListView lv;

    @Override
    protected boolean isHideTitle() {
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initDate() {
    }

    @Override
    protected View getChildView() {
        return View.inflate(this, R.layout.activity_serch_movie, null);
    }

    @OnClick({R.id.qx, R.id.clear})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.qx:
                String shuru = serchMovies.getText().toString();
                Toast.makeText(this, ""+shuru, Toast.LENGTH_SHORT).show();
                SharePrenFace.saveString("lishi",shuru);
                String lishi = SharePrenFace.getString("lishi");
                list.add(lishi);
                ListAdapet listAdapet = new ListAdapet(this, list);
                lv.setAdapter(listAdapet);
                break;
            case R.id.clear:
                Toast.makeText(this, "清空", Toast.LENGTH_SHORT).show();
                SharePrenFace.clearSp();
                break;
        }
    }
}
