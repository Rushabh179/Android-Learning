package com.simform.rushabhmodi.androidlearning.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.simform.rushabhmodi.androidlearning.R;
import com.simform.rushabhmodi.androidlearning.other.TestExamplesChild;
import com.simform.rushabhmodi.androidlearning.other.TestExamplesParent;
import com.simform.rushabhmodi.androidlearning.viewholder.TestExamplesChildViewHolder;
import com.simform.rushabhmodi.androidlearning.viewholder.TestExamplesParentViewHolder;
import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

/**
 * Created by rushabh.modi on 01/02/18.
 */

public class TestExamplesExpandableAdapter
        extends ExpandableRecyclerViewAdapter<TestExamplesParentViewHolder, TestExamplesChildViewHolder> {

    public TestExamplesExpandableAdapter(List<? extends ExpandableGroup> groups) {
        super(groups);
    }

    @Override
    public TestExamplesParentViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_base_recycler, parent, false);
        return new TestExamplesParentViewHolder(view);
    }

    @Override
    public TestExamplesChildViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_erv_child, parent, false);
        return new TestExamplesChildViewHolder(view);
    }

    @Override
    public void onBindGroupViewHolder(TestExamplesParentViewHolder holder, int flatPosition, ExpandableGroup group) {
        holder.setTestParentText(group);
    }

    @Override
    public void onBindChildViewHolder(TestExamplesChildViewHolder holder, int flatPosition, ExpandableGroup group, int childIndex) {
        final TestExamplesChild testExamplesChild = ((TestExamplesParent) group).getItems().get(childIndex);
        holder.setTestChildText(testExamplesChild.getTestChild());
    }

}
