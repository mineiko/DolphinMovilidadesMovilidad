package com.tyddolphin.appmovilidad;

import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.tyddolphin.appmovilidad.rest.Rest;
import com.tyddolphin.appmovilidad.signalr.SignalR;

public class MainActivity extends AppCompatActivity {

    SeccionesPagerAdapter mSeccionesPagerAdapter;
    private ViewPager mViewPager;
    TabLayout Tabs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Tabs = (TabLayout) findViewById(R.id.tabs);
        mViewPager = (ViewPager) findViewById(R.id.container);
        mSeccionesPagerAdapter = new SeccionesPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mSeccionesPagerAdapter);
        mViewPager.setOffscreenPageLimit(4);
        Tabs.setupWithViewPager(mViewPager);


        setIconoOnTab(0,R.drawable.ic_person_pin_circle_white_36dp);
        setIconoOnTab(1,R.drawable.ic_report_white_36dp);
        setIconoOnTab(2,R.drawable.ic_account_box_white_36dp);
        //setIconoOnTab(3,R.drawable.ic_settings_white_36dp);
        setIconoOnTab(3,R.drawable.ic_help_white_36dp);

        SignalR.Iniciar(getApplicationContext());

        /*Rest r = new Rest(getApplicationContext());
        String url = "http://movilidadessignalr20170616114841.azurewebsites.net/ServicioMock.svc/movilidades/0";
        r.Reponse(url);
        r.getCantidadAlumnosCompleted.add(new Rest.RestListener<Integer>() {
            @Override
            public void onRespuesta(Integer cantidad) {
                Toast.makeText(MainActivity.this,cantidad,Toast.LENGTH_LONG).show();
            }
        });
        r.getCantidadAlumnosCompleted.add(new Rest.RestListener<Integer>() {
            @Override
            public void onRespuesta(Integer cantidad) {
                Log.i("","");
            }
        });
        r.getCantidadAlumnosAsync("1");*/

    }

    private void setIconoOnTab(int tabID, @DrawableRes int drawable){
        TabLayout.Tab tab = Tabs.getTabAt(tabID);
        if (tab != null){
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(drawable);

            tab.setCustomView(imageView);
            // /tab.setIcon(drawable);
        }

    }

}
