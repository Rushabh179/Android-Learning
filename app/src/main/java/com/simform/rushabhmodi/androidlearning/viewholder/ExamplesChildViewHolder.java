package com.simform.rushabhmodi.androidlearning.viewholder;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.simform.rushabhmodi.androidlearning.R;
import com.simform.rushabhmodi.androidlearning.examples.DialogFragmentExampleActivity;
import com.simform.rushabhmodi.androidlearning.examples.ListFragmentExampleActivity;
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
                //Toast.makeText(itemView.getContext(), childText.getText().toString(), Toast.LENGTH_SHORT).show();
                switch (childText.getText().toString()){
                    case "Dialog Fragment":
                        itemView.getContext().startActivity(new Intent(itemView.getContext(),DialogFragmentExampleActivity.class));
                        break;
                    case "List Fragment":
                        itemView.getContext().startActivity(new Intent(itemView.getContext(),ListFragmentExampleActivity.class));
                        break;
                }
            }
        });
    }

    public void setChildText(String text) {
        childText.setText(text);
    }

}
