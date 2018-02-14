package com.simform.rushabhmodi.androidlearning.viewholder;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.simform.rushabhmodi.androidlearning.R;
import com.simform.rushabhmodi.androidlearning.examples.ExpandableRecyclerViewExampleActivity;
import com.simform.rushabhmodi.androidlearning.examples.GestureExampleActivity;
import com.simform.rushabhmodi.androidlearning.examples.IntentExampleActivity;
import com.simform.rushabhmodi.androidlearning.examples.CollapsingToolbarScrollingExampleActivity;
import com.simform.rushabhmodi.androidlearning.examples.TextInputExampleActivity;
import com.simform.rushabhmodi.androidlearning.examples.WebViewExampleActivity;
import com.simform.rushabhmodi.androidlearning.other.ExamplesDataFactory;
import com.simform.rushabhmodi.androidlearning.examples.ScrollViewsExampleActivity;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

/**
 * Created by rushabh.modi on 01/02/18.
 */

public class ExamplesParentViewHolder extends GroupViewHolder {

    private TextView parentText;
    private Context parentContext;// = itemView.getContext();

    public ExamplesParentViewHolder(final View itemView) {
        super(itemView);
        parentText = itemView.findViewById(R.id.textview_base_recycler);
    }

    public void setParentText(ExpandableGroup examplesParent) {
        parentText.setText(examplesParent.getTitle());
    }

    @Override
    public void onClick(View v) {
        parentContext = v.getContext();
        switch (parentText.getText().toString()) {
            case ExamplesDataFactory.parent1:
                parentContext.startActivity(new Intent(parentContext, GestureExampleActivity.class));
                break;
            case ExamplesDataFactory.parent2:
                parentContext.startActivity(new Intent(parentContext, IntentExampleActivity.class));
                break;
            case ExamplesDataFactory.parent3:
                parentContext.startActivity(new Intent(parentContext, ExpandableRecyclerViewExampleActivity.class));
                break;
            case ExamplesDataFactory.parent6:
                parentContext.startActivity(new Intent(parentContext, CollapsingToolbarScrollingExampleActivity.class));
                break;
            case ExamplesDataFactory.parent7:
                parentContext.startActivity(new Intent(parentContext, ScrollViewsExampleActivity.class));
                break;
            case ExamplesDataFactory.parent9:
                parentContext.startActivity(new Intent(parentContext, WebViewExampleActivity.class));
                break;
            case ExamplesDataFactory.parent10:
                parentContext.startActivity(new Intent(parentContext, TextInputExampleActivity.class));
                break;
            default:
                super.onClick(v);
        }
    }
}
