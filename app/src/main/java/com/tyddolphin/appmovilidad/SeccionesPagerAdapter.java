package com.tyddolphin.appmovilidad;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Gianella Milon on 18/06/2017.
 */

public class SeccionesPagerAdapter extends FragmentPagerAdapter {
    SeccionesPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if(position==0)return new FragmentIniciarJornada();
        if(position==1)return new FragmentAlertas();
        if(position==2)return new FragmentCuentaMovilidad();
        if(position==3)return new FragmentConfiguracion();
        if(position==4)return new FragmentPreguntasFrecuentes();

        return new FragmentIniciarJornada();

    }

    @Override
    public int getCount() {
        return 5;
    }

}
