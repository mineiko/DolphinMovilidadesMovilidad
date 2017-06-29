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
    Fragment FMA;
    Fragment FA;
    Fragment FCM;
    Fragment FC;
    Fragment FPF;

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                if(FMA == null)
                    FMA = fragments[position];
                return FMA;
            case 1:
                if(FA == null)
                    FA = fragments[position];
                return FA;
            case 2:
                if(FCM == null)
                    FCM= fragments[position];
                return FCM;
            case 3:
                if(FC== null)
                    FC= fragments[position];
                return FC;
            case 4:
                if(FPF == null)
                    FPF= fragments[position];
                return FPF;
        }
        return null;

    }
    public int getCount() {
        return 5;
    }

}
