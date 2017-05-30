package com.tyddolphin.appmovilidad;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/*
* @author Alexis Vargas
* */

class SeccionesPagerAdapter extends FragmentPagerAdapter {
    SeccionesPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return new FragmentIniciarJornada();
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "Tab";
    }
}
