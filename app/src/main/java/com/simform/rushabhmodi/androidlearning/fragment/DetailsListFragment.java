package com.simform.rushabhmodi.androidlearning.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.simform.rushabhmodi.androidlearning.R;

/**
 * Created by rushabh.modi on 05/02/18.
 */

public class DetailsListFragment extends Fragment{

    private TextView nameTextView, contactTextView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_list_details, container, false);
        nameTextView = view.findViewById(R.id.textview_fragment_list_name);
        contactTextView = view.findViewById(R.id.textview_fragment_list_contact);
        return view;
    }

    public void change(String name, String contact){
        nameTextView.setText(name);
        contactTextView.setText(contact);
    }

}
