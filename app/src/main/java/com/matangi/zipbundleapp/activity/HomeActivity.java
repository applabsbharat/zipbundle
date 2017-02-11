package com.matangi.zipbundleapp.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.matangi.zipbundleapp.R;
import com.matangi.zipbundleapp.fragment.HomeFragment;
import com.matangi.zipbundleapp.fragment.LoginFragment;
import com.matangi.zipbundleapp.util.UpdateFragments;

/**
 * Created by matangi.agarwal on 2/10/2017.
 */

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView iv_leftmenu;
    private DrawerLayout mDrawerlayout;
    private RelativeLayout drawer_list_right;
    private ActionBarDrawerToggle mDrawerToggle;
    private RelativeLayout rl_signup, rl_setting;
    private LinearLayout ll_home, ll_category, ll_store_location, ll_scan_now, ll_contact_us;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        new UpdateFragments(HomeActivity.this);

        UpdateFragments.setFragment(getSupportFragmentManager().beginTransaction(), new LoginFragment(), R.id.Frame_Layout);
        initailize();
        setListener();
    }

    private void initailize() {
        mDrawerlayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        mDrawerlayout.setDrawerListener(mDrawerToggle);
        drawer_list_right = (RelativeLayout)findViewById(R.id.drawer_list_right);
        iv_leftmenu = (ImageView) findViewById(R.id.iv_leftmenu);
        rl_signup = (RelativeLayout) findViewById(R.id.rl_signup);
        rl_setting = (RelativeLayout) findViewById(R.id.rl_setting);
        ll_home = (LinearLayout) findViewById(R.id.ll_home);
        ll_category = (LinearLayout) findViewById(R.id.ll_category);
        ll_store_location = (LinearLayout) findViewById(R.id.ll_store_location);
        ll_scan_now = (LinearLayout) findViewById(R.id.ll_scan_now);
        ll_contact_us = (LinearLayout) findViewById(R.id.ll_contact_us);
    }

    private void setListener() {
        iv_leftmenu.setOnClickListener(this);
        rl_signup.setOnClickListener(this);
        rl_setting.setOnClickListener(this);
        ll_home.setOnClickListener(this);
        ll_category.setOnClickListener(this);
        ll_store_location.setOnClickListener(this);
        ll_scan_now.setOnClickListener(this);
        ll_contact_us.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.iv_leftmenu:
               mDrawerlayout.openDrawer(drawer_list_right);
                break;
            case R.id.rl_signup:
                UpdateFragments.setFragment(getSupportFragmentManager().beginTransaction(),new LoginFragment(), R.id.Frame_Layout);
                mDrawerlayout.closeDrawer(drawer_list_right);
                break;
            case R.id.rl_setting:
                break;
            case R.id.ll_home:
                UpdateFragments.setFragment(getSupportFragmentManager().beginTransaction(),new HomeFragment(), R.id.Frame_Layout);
                mDrawerlayout.closeDrawer(drawer_list_right);
                break;
            case R.id.ll_category:
                break;
            case R.id.ll_store_location:
                break;
            case R.id.ll_scan_now:
                break;
            case R.id.ll_contact_us:
                break;
        }
    }
}
