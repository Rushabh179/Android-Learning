package com.simform.rushabhmodi.androidlearning.viewholder;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.simform.rushabhmodi.androidlearning.R;
import com.simform.rushabhmodi.androidlearning.examples.ExpandableRecyclerViewExampleActivity;
import com.simform.rushabhmodi.androidlearning.examples.GestureExampleActivity;
import com.simform.rushabhmodi.androidlearning.examples.IntentExampleActivity;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

/**
 * Created by rushabh.modi on 01/02/18.
 */

public class ExamplesParentViewHolder extends GroupViewHolder {

    private TextView parentText;

    public ExamplesParentViewHolder(final View itemView) {
        super(itemView);
        parentText = itemView.findViewById(R.id.textview_base_recycler);
    }

    public void setParentText(ExpandableGroup examplesParent) {
        parentText.setText(examplesParent.getTitle());
    }

    @Override
    public void onClick(View v) {
        switch (parentText.getText().toString()) {
            case "Gestures":
                itemView.getContext().startActivity(new Intent(itemView.getContext(), GestureExampleActivity.class));
                break;
            case "Intents":
                itemView.getContext().startActivity(new Intent(itemView.getContext(), IntentExampleActivity.class));
                break;
            case "Expandable RecyclerView":
                itemView.getContext().startActivity(new Intent(itemView.getContext(), ExpandableRecyclerViewExampleActivity.class));
                break;
            default:
                super.onClick(v);
        }
    }
}
