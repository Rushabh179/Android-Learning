package com.simform.rushabhmodi.androidlearning.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.simform.rushabhmodi.androidlearning.R;
import com.simform.rushabhmodi.androidlearning.other.ExamplesChild;
import com.simform.rushabhmodi.androidlearning.other.ExamplesParent;
import com.simform.rushabhmodi.androidlearning.viewholder.ExamplesChildViewHolder;
import com.simform.rushabhmodi.androidlearning.viewholder.ExamplesParentViewHolder;
import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

/**
 * Created by rushabh.modi on 01/02/18.
 */

public class ExamplesExpandableAdapter
        extends ExpandableRecyclerViewAdapter<ExamplesParentViewHolder, ExamplesChildViewHolder> {

    public ExamplesExpandableAdapter(List<? extends ExpandableGroup> groups) {
        super(groups);
    }

    @Override
    public ExamplesParentViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_base_recycler, parent, false);
        return new ExamplesParentViewHolder(view);
    }

    @Override
    public ExamplesChildViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_examples_child, parent, false);
        return new ExamplesChildViewHolder(view);
    }

    @Override
    public void onBindGroupViewHolder(ExamplesParentViewHolder holder, int flatPosition, ExpandableGroup group) {
        holder.setParentText(group);
    }

    @Override
    public void onBindChildViewHolder(ExamplesChildViewHolder holder, int flatPosition, ExpandableGroup group, int childIndex) {
        final ExamplesChild examplesChild = ((ExamplesParent) group).getItems().get(childIndex);
        holder.setChildText(examplesChild.getExamplesChildText());
    }

}
