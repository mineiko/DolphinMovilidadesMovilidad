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
    Fragment FMA;
    FragmentAlertas FA;
    FragmentCuentaMovilidad FCM;
    FragmentConfiguracion FC;
    FragmentPreguntasFrecuentes FPF;


    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                if(FMA == null)
                    FMA = new FragmentMapaAlumnos();
                return FMA;

        }
        /*if(position==0)return new FragmentMapaAlumnos();
        if(position==1)return FA;
        if(position==2)return FCM;
        if(position==3)return FC;
        if(position==4)return FPF;*/

        return null;

    }

    @Override
    public int getCount() {
        return 5;
    }

}
