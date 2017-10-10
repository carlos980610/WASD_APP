package com.example.carlosandres.wasd_app.Fragment_Control_Data.Fragment_Control_Publication_Data;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by hp on 4/09/2017.
 */

public class View_Pager_Adapter extends FragmentPagerAdapter {

    public View_Pager_Adapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new First_Fragment_Main_Screen();
        }

        /*else if (position == 1) {
            //return new SecondFragment();
        }*/

        else
            return new Second_Fragment_Main();

    }

    @Override
    public int getCount() {
        return 2;
    }
}

