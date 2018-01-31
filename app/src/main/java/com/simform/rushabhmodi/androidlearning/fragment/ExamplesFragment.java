package com.simform.rushabhmodi.androidlearning.fragment;

import android.content.Intent;
import android.os.Bundle;
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
import com.simform.rushabhmodi.androidlearning.examples.ExpandableRecyclerViewExampleActivity;
import com.simform.rushabhmodi.androidlearning.examples.GestureExampleActivity;
import com.simform.rushabhmodi.androidlearning.examples.IntentExampleActivity;
import com.simform.rushabhmodi.androidlearning.interfaces.OnRecyclerItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class ExamplesFragment extends Fragment implements OnRecyclerItemClickListener {

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
        titleTextList.add("Gestures");
        titleTextList.add("Intents");
        titleTextList.add("Expandable RecylerView");
        for (int i = 4; i <= 15; i++) {
            titleTextList.add("Example" + i);
        }
        baseRecyclerAdapter = new BaseRecyclerAdapter(titleTextList);
        baseRecyclerAdapter.setOnReclyclerItemClickListener(this);
        baseRecyclerView.setAdapter(baseRecyclerAdapter);

        return view;
    }

    @Override
    public void onRecyclerItemCLick(View view, int position) {
        switch (position) {
            case 0:
                startActivity(new Intent(getContext(), GestureExampleActivity.class));
                break;
            case 1:
                startActivity(new Intent(getContext(), IntentExampleActivity.class));
                break;
            case 2:
                startActivity(new Intent(getContext(), ExpandableRecyclerViewExampleActivity.class));
                break;
            default:
                Toast.makeText(getContext(), R.string.toast_not_ready, Toast.LENGTH_SHORT).show();
        }
    }

    public interface OnFragmentInteractionListener {
    }
}
