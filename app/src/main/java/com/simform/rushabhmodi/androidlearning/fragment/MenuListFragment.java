package com.simform.rushabhmodi.androidlearning.fragment;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.simform.rushabhmodi.androidlearning.R;

/**
 * Created by rushabh.modi on 05/02/18.
 */

public class MenuListFragment extends ListFragment {
    String[] names = new String[]{"abc", "def", "ghij", "klmno", "pq"};
    String[] contacts = new String[]{"99999", "11111", "2121212", "44153", "2343432"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_menu, container, false);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_list_item_1, names);
        setListAdapter(adapter);
        return view;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        DetailsListFragment txt = (DetailsListFragment) getFragmentManager().findFragmentById(R.id.fragment_list_details);
        txt.change(names[position],"Contact : "+contacts[position]);
        getListView().setSelector(android.R.color.holo_blue_dark);

    }
}
