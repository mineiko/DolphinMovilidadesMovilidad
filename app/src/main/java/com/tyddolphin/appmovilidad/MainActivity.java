package com.tyddolphin.appmovilidad;

import android.support.annotation.DrawableRes;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TabHost;

public class MainActivity extends AppCompatActivity {

    private static String TAG = "MainActivity";

    private SeccionesPagerAdapter mSeccionesPagerAdapter;

    private ViewPager mViewPager;

    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSeccionesPagerAdapter = new SeccionesPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSeccionesPagerAdapter);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        setIconoEnTab(0,R.drawable.ic_home_black_24dp);
        setIconoEnTab(1,R.drawable.ic_warning_black_24dp);
        setIconoEnTab(2,R.drawable.ic_account_box_black_24dp);
        setIconoEnTab(3,R.drawable.ic_help_black_24dp);


    }

    private void setIconoEnTab(int tabid, @DrawableRes int drawable){
        TabLayout.Tab tab = tabLayout.getTabAt(tabid);
        if (tab != null)
            tab.setIcon(drawable);
    }
}
