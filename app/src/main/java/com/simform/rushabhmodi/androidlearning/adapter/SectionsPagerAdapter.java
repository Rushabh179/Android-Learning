package com.simform.rushabhmodi.androidlearning.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.simform.rushabhmodi.androidlearning.fragment.PlaceholderFragment;

/**
 * Created by rushabh.modi on 16/02/18.
 *
 * A FragmentPagerAdapter that returns a fragment corresponding to one of the sections/tabs/pages.
 */

public class SectionsPagerAdapter extends FragmentPagerAdapter {

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        return PlaceholderFragment.newInstance(position + 1);
    }

    @Override
    public int getCount() {
        // Show total pages.
        return 3;
    }
}
