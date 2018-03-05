package com.simform.rushabhmodi.androidlearning.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.simform.rushabhmodi.androidlearning.R;
import com.simform.rushabhmodi.androidlearning.adapter.ExamplesExpandableAdapter;

import static com.simform.rushabhmodi.androidlearning.model.ExamplesDataFactory.makeParents;

/**
 * Created by rushabh.modi on 31/01/18.
 */

public class ExamplesExpandableFragment extends Fragment {

    private RecyclerView examplesExpandableRecyclerView;
    public ExamplesExpandableAdapter examplesExpandableAdapter;

    public ExamplesExpandableFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.base_layout_recyclerview, container, false);
        examplesExpandableRecyclerView = view.findViewById(R.id.recyclerview_base);
        examplesExpandableRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        examplesExpandableAdapter = new ExamplesExpandableAdapter(makeParents());
        examplesExpandableRecyclerView.setAdapter(examplesExpandableAdapter);

        return view;
    }
}
