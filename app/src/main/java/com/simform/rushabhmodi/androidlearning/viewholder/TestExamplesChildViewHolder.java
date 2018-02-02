package com.simform.rushabhmodi.androidlearning.viewholder;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.simform.rushabhmodi.androidlearning.R;
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

/**
 * Created by rushabh.modi on 01/02/18.
 */

public class TestExamplesChildViewHolder extends ChildViewHolder {

    private TextView testChildText;

    public TestExamplesChildViewHolder(final View itemView) {
        super(itemView);
        testChildText = itemView.findViewById(R.id.textview_erv_child);
        testChildText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(itemView.getContext(), testChildText.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void setTestChildText(String text) {
        testChildText.setText(text);
    }

}
