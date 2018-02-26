package com.simform.rushabhmodi.androidlearning.viewholder;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.simform.rushabhmodi.androidlearning.R;
import com.simform.rushabhmodi.androidlearning.examples.DialogFragmentExampleActivity;
import com.simform.rushabhmodi.androidlearning.examples.InternalStorageExampleActivity;
import com.simform.rushabhmodi.androidlearning.examples.ListFragmentExampleActivity;
import com.simform.rushabhmodi.androidlearning.examples.SearchExampleActivity;
import com.simform.rushabhmodi.androidlearning.examples.SharedPreferencesExampleActivity;
import com.simform.rushabhmodi.androidlearning.other.ExamplesDataFactory;
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

/**
 * Created by rushabh.modi on 01/02/18.
 */

public class ExamplesChildViewHolder extends ChildViewHolder {

    private TextView childText;
    private Context childContext;// = itemView.getContext();

    public ExamplesChildViewHolder(final View itemView) {
        super(itemView);
        childContext = itemView.getContext();
        childText = itemView.findViewById(R.id.textview_examples_child);
        childText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (childText.getText().toString()) {
                    case ExamplesDataFactory.parent4child1:
                        childContext.startActivity(new Intent(childContext, DialogFragmentExampleActivity.class));
                        break;
                    case ExamplesDataFactory.parent4child2:
                        childContext.startActivity(new Intent(childContext, ListFragmentExampleActivity.class));
                        break;
                    case ExamplesDataFactory.parent5child1:
                        childContext.startActivity(new Intent(childContext, SharedPreferencesExampleActivity.class));
                        break;
                    case ExamplesDataFactory.parent5child2:
                        childContext.startActivity(new Intent(childContext, InternalStorageExampleActivity.class));
                        break;
                    case ExamplesDataFactory.parent8child1:
                        childContext.startActivity(new Intent(childContext, SearchExampleActivity.class).putExtra(childContext.getString(R.string.search_type), childContext.getString(R.string.search_simple)));
                        break;
                    case ExamplesDataFactory.parent8child2:
                        childContext.startActivity(new Intent(childContext, SearchExampleActivity.class).putExtra(childContext.getString(R.string.search_type), childContext.getString(R.string.search_enhanced)));
                        break;
                }
            }
        });
    }

    public void setChildText(String text) {
        childText.setText(text);
    }

}
