package com.simform.rushabhmodi.androidlearning.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.simform.rushabhmodi.androidlearning.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by rushabh.modi on 19/03/18.
 */

public class OkHttpRecyclerAdapter extends RecyclerView.Adapter<OkHttpRecyclerAdapter.ViewHolder> {

    private ArrayList<HashMap<String, String>> infoList;

    public OkHttpRecyclerAdapter(ArrayList<HashMap<String, String>> infoList) {
        this.infoList = infoList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_item_okhttp, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.okHttpName.setText(infoList.get(position).get("name"));
    }

    @Override
    public int getItemCount() {
        return infoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView okHttpName;

        public ViewHolder(View itemView) {
            super(itemView);
            okHttpName = itemView.findViewById(R.id.textview_okhttp_name);
        }
    }
}
