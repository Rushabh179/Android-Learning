package com.simform.rushabhmodi.androidlearning.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.simform.rushabhmodi.androidlearning.R;
import com.simform.rushabhmodi.androidlearning.adapter.BaseRecyclerAdapter;
import com.simform.rushabhmodi.androidlearning.interfaces.OnRecyclerItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class InformationFragment extends Fragment implements OnRecyclerItemClickListener {

    private RecyclerView baseRecyclerView;
    private RecyclerView.LayoutManager baseRecyclerLayoutManager;
    private BaseRecyclerAdapter baseRecyclerAdapter;
    private List<String> titleTextList;

    public InformationFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.base_layout_recyclerview, container, false);
        baseRecyclerView = view.findViewById(R.id.recyclerview_base);
        baseRecyclerLayoutManager = new LinearLayoutManager(getContext());
        baseRecyclerView.setLayoutManager(baseRecyclerLayoutManager);

        titleTextList = new ArrayList<>();
        for (int i = 1; i <= 15; i++) {
            titleTextList.add("Information" + i);
        }
        baseRecyclerAdapter = new BaseRecyclerAdapter(titleTextList);
        baseRecyclerAdapter.setOnReclyclerItemClickListener(this);
        baseRecyclerView.setAdapter(baseRecyclerAdapter);

        return view;
    }

    @Override
    public void onRecyclerItemCLick(View view, int position) {
        Toast.makeText(getContext(), R.string.toast_not_ready, Toast.LENGTH_SHORT).show();
    }
}
