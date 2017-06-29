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
            new FragmentMapaAlumnos(),
            new FragmentAlertas(),
            new FragmentCuentaMovilidad(),
            new FragmentConfiguracion(),
            new FragmentPreguntasFrecuentes()
    };

    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }

    @Override
    public int getCount() {
        return 5;
    }

}
