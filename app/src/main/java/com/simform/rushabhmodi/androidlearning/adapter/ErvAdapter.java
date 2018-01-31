package com.simform.rushabhmodi.androidlearning.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.simform.rushabhmodi.androidlearning.R;
import com.simform.rushabhmodi.androidlearning.constant.ErvChild;
import com.simform.rushabhmodi.androidlearning.constant.ErvParent;
import com.simform.rushabhmodi.androidlearning.viewholder.ErvChildViewHolder;
import com.simform.rushabhmodi.androidlearning.viewholder.ErvParentViewHolder;
import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

/**
 * Created by rushabh.modi on 31/01/18.
 */

public class ErvAdapter
        extends ExpandableRecyclerViewAdapter<ErvParentViewHolder,ErvChildViewHolder> {

    public ErvAdapter(List<? extends ExpandableGroup> groups) {
        super(groups);
    }

    @Override
    public ErvParentViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_erv_parent, parent, false);
        return new ErvParentViewHolder(view);
    }

    @Override
    public ErvChildViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_erv_child, parent, false);
        return new ErvChildViewHolder(view);
    }

    @Override
    public void onBindGroupViewHolder(ErvParentViewHolder holder, int flatPosition, ExpandableGroup group) {
        holder.setErvParentText(group);
    }

    @Override
    public void onBindChildViewHolder(ErvChildViewHolder holder, int flatPosition, ExpandableGroup group, int childIndex) {
        final ErvChild ervChild = ((ErvParent) group).getItems().get(childIndex);
        holder.setErvChildText(ervChild.getChild());
    }
}
