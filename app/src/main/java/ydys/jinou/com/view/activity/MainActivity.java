package ydys.jinou.com.view.activity;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

import butterknife.BindView;
import butterknife.ButterKnife;
import ydys.jinou.com.R;
import ydys.jinou.com.view.fragment.FancyFragment;
import ydys.jinou.com.view.fragment.HomeFragment;
import ydys.jinou.com.view.fragment.MineFragment;
import ydys.jinou.com.view.fragment.SpecialFragment;


public class MainActivity extends AppCompatActivity {
    @BindView(R.id.main_bottom_bar)
    BottomNavigationBar mainBottomBar;
    @BindView(R.id.main_title)
    TextView mainTitle;
    private FragmentManager supportFragmentManager;
    private HomeFragment homeFragment;
    private SpecialFragment specialFragment;
    private FancyFragment fancyFragment;
    private MineFragment mineFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
        initBottomMenu();
    }

    private void init() {
        supportFragmentManager = getSupportFragmentManager();
        homeFragment = new HomeFragment();
        supportFragmentManager.beginTransaction().add(R.id.main_frame, homeFragment).commit();
    }

    private void initBottomMenu() {
        mainBottomBar.addItem(new BottomNavigationItem(R.drawable.found, "精选"))
                .addItem(new BottomNavigationItem(R.drawable.special, "专题"))
                .addItem(new BottomNavigationItem(R.drawable.fancy, "发现"))
                .addItem(new BottomNavigationItem(R.drawable.my, "我的"))
                .setFirstSelectedPosition(0)
                .initialise();//所有的设置需在调用该方法前完成

        mainBottomBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {//这里也可以使用SimpleOnTabSelectedListener
            @Override
            public void onTabSelected(int position) {//未选中 -> 选中
                hideAllFragments();
                FragmentTransaction toggleTransaction = supportFragmentManager.beginTransaction();
                int backgroundColor = Color.parseColor("#00ACA0");
                String titleStr = "精选";
                switch (position) {
                    case 0:
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
                mainTitle.setText(titleStr);
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

    private void hideAllFragments() {
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        if (homeFragment != null) fragmentTransaction.hide(homeFragment);
        if (specialFragment != null) fragmentTransaction.hide(specialFragment);
        if (mineFragment != null) fragmentTransaction.hide(mineFragment);
        if (fancyFragment != null) fragmentTransaction.hide(fancyFragment);
        fragmentTransaction.commit();
    }

}
