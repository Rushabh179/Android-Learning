package com.simform.rushabhmodi.androidlearning.test;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.simform.rushabhmodi.androidlearning.R;

import java.util.List;

/**
 * Created by rushabh.modi on 28/03/18.
 */

public class ContentProviderRecyclerAdapter extends RecyclerView.Adapter<ContentProviderRecyclerAdapter.ViewHolder> {

    private List<String> contactNameList;

    public ContentProviderRecyclerAdapter(List<String> contactNameList) {
        this.contactNameList = contactNameList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_item_simple_recycler, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.contactName.setText(contactNameList.get(position));
    }

    @Override
    public int getItemCount() {
        return contactNameList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView contactName;

        public ViewHolder(View itemView) {
            super(itemView);
            contactName = itemView.findViewById(R.id.textview_simple_recycler);
        }
    }
}
