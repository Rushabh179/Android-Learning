package com.simform.rushabhmodi.androidlearning.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.simform.rushabhmodi.androidlearning.R;
import com.simform.rushabhmodi.androidlearning.interfaces.OnRecyclerItemClickListener;

import java.util.List;

/**
 * Created by rushabh.modi on 28/02/18.
 */

public class SimpleRecyclerViewAdapter extends RecyclerView.Adapter<SimpleRecyclerViewAdapter.ViewHolder> {
    private List<String> titleTextList;
    private OnRecyclerItemClickListener onRecyclerItemClickListener;

    public SimpleRecyclerViewAdapter(List<String> titleTextList) {
        this.titleTextList = titleTextList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_item_simple_recycler, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.simpleRecyclerText.setText(titleTextList.get(position));
    }

    @Override
    public int getItemCount() {
        return titleTextList.size();
    }

    public void setOnReclyclerItemClickListener(OnRecyclerItemClickListener onReclyclerItemClickListener) {
        this.onRecyclerItemClickListener = onReclyclerItemClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView simpleRecyclerText;

        public ViewHolder(final View itemView) {
            super(itemView);
            simpleRecyclerText = itemView.findViewById(R.id.textview_simple_recycler);
            simpleRecyclerText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (onRecyclerItemClickListener != null) {
                        onRecyclerItemClickListener.onRecyclerItemCLick(view, getAdapterPosition());
                    }
                }
            });
        }
    }
}
