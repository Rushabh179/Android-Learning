package com.simform.rushabhmodi.androidlearning.viewholder;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.simform.rushabhmodi.androidlearning.R;
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

/**
 * Created by rushabh.modi on 01/02/18.
 */

public class ExamplesChildViewHolder extends ChildViewHolder {

    private TextView childText;

    public ExamplesChildViewHolder(final View itemView) {
        super(itemView);
        childText = itemView.findViewById(R.id.textview_examples_child);
        childText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(itemView.getContext(), childText.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void setChildText(String text) {
        childText.setText(text);
    }

}
