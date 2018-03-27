package com.simform.rushabhmodi.androidlearning.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.simform.rushabhmodi.androidlearning.R;

/**
 * Created by rushabh.modi on 16/02/18.
 */

// A placeholder fragment containing a simple view.
public class PlaceholderFragment extends Fragment {

    // The fragment argument representing the section number for this fragment.
    private static final String ARG_SECTION_NUMBER = "section_number";

    public PlaceholderFragment() {
    }

    // Returns a new instance of this fragment for the given section number.
    public static PlaceholderFragment newInstance(int sectionNumber) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_design_support_example, container, false);
        TextView textView = rootView.findViewById(R.id.section_label);
        String tabString;
        if (getArguments() != null) {
            tabString = getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)) + "\n";
            for (int i = 0; i <= 70; i++) {
                tabString += getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)) + "\n";
            }
            textView.setText(tabString);//getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
        }
        return rootView;
    }
}
