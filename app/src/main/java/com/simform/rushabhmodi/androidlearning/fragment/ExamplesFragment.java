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

public class ExamplesFragment extends Fragment {

    private RecyclerView baseRecyclerView;
    private RecyclerView.LayoutManager baseRecyclerLayoutManager;
    private BaseRecyclerAdapter baseRecyclerAdapter;
    private List<String> titleTextList;

    public ExamplesFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_base_recycler, container, false);
        baseRecyclerView = view.findViewById(R.id.recyclerview_base);
        baseRecyclerLayoutManager = new LinearLayoutManager(getContext());
        baseRecyclerView.setLayoutManager(baseRecyclerLayoutManager);

        titleTextList = new ArrayList<>();
        for (int i = 1; i <= 15; i++) {
            titleTextList.add("Example" + i);
        }
        baseRecyclerAdapter = new BaseRecyclerAdapter(titleTextList);
        baseRecyclerView.setAdapter(baseRecyclerAdapter);

        return view;
    }

    public interface OnFragmentInteractionListener {
    }



    /*// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public ExamplesFragment() {
        // Required empty public constructor
    }

    public static ExamplesFragment newInstance(String param1, String param2) {
        ExamplesFragment fragment = new ExamplesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_examples, container, false);
    }

    public void onButtonPressed(String text) {
        if (mListener != null) {
            mListener.onFragmentInteraction(text);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(String text);
    }*/
}
