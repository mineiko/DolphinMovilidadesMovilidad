package com.tyddolphin.appmovilidad;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * @author Gianella
 */

class SeccionesPagerAdapter extends FragmentPagerAdapter {
    SeccionesPagerAdapter(FragmentManager fm) {
        super(fm);
    }
    private Fragment fragments[] = {
            new FragmentIniciarJornada(),
            new FragmentAlertas(),
            new FragmentCuentaMovilidad(),
            //new FragmentConfiguracion(),
            new FragmentPreguntasFrecuentes()
    };


    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }
    public int getCount() {
        return fragments.length;
    }

}
