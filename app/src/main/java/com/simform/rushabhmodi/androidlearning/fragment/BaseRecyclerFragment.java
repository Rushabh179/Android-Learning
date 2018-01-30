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
import com.simform.rushabhmodi.androidlearning.adapter.BaseRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rushabh.modi on 30/01/18.
 */

public class BaseRecyclerFragment extends Fragment {

    RecyclerView baseRecyclerView;
    RecyclerView.LayoutManager baseRecyclerLayoutManager;
    BaseRecyclerAdapter baseRecyclerAdapter;
    private List<String> titleTextList;

    public BaseRecyclerFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_base_recycler, container, false);
        baseRecyclerView = view.findViewById(R.id.recyclerview_base);
        baseRecyclerLayoutManager = new LinearLayoutManager(getContext());
        baseRecyclerView.setLayoutManager(baseRecyclerLayoutManager);

        /*titleTextList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            titleTextList.add("Example" + i);
        }
        baseRecyclerAdapter = new BaseRecyclerAdapter(titleTextList);
        baseRecyclerView.setAdapter(baseRecyclerAdapter);*/

        return view;
    }
}
