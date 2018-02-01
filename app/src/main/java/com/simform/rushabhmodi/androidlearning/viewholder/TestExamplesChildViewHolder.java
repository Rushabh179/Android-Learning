package com.simform.rushabhmodi.androidlearning.viewholder;

import android.view.View;
import android.widget.TextView;

import com.simform.rushabhmodi.androidlearning.R;
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

/**
 * Created by rushabh.modi on 01/02/18.
 */

public class TestExamplesChildViewHolder extends ChildViewHolder {

    private TextView testChildText;

    public TestExamplesChildViewHolder(View itemView) {
        super(itemView);
        testChildText = itemView.findViewById(R.id.textview_erv_child);
    }

    public void setTestChildText(String text) {
        testChildText.setText(text);
    }
}
