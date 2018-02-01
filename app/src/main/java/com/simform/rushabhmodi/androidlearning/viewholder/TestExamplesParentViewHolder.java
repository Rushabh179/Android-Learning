package com.simform.rushabhmodi.androidlearning.viewholder;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;

import com.simform.rushabhmodi.androidlearning.R;
import com.simform.rushabhmodi.androidlearning.examples.GestureExampleActivity;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

/**
 * Created by rushabh.modi on 01/02/18.
 */

public class TestExamplesParentViewHolder extends GroupViewHolder {

    private TextView testParentText;
    private CardView testParentCard;

    public TestExamplesParentViewHolder(final View itemView) {
        super(itemView);
        testParentText = itemView.findViewById(R.id.textview_base_recycler);
        testParentCard = itemView.findViewById(R.id.cardview_base_recycler);
        testParentCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case 0:
                        Intent intent = new Intent(itemView.getContext(), GestureExampleActivity.class);
                        itemView.getContext().startActivity(intent);
                        break;
                    default:
                        TestExamplesParentViewHolder.super.onClick(view);
                }
            }
        });
    }

    public void setTestParentText(ExpandableGroup testExamplesParent){
        testParentText.setText(testExamplesParent.getTitle());
    }
}
