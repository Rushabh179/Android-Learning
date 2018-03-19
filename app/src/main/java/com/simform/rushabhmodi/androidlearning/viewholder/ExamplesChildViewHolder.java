package com.simform.rushabhmodi.androidlearning.viewholder;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.simform.rushabhmodi.androidlearning.R;
import com.simform.rushabhmodi.androidlearning.exampleactivities.DialogFragmentExampleActivity;
import com.simform.rushabhmodi.androidlearning.exampleactivities.ExpandableRecyclerViewExampleActivity;
import com.simform.rushabhmodi.androidlearning.exampleactivities.ExternalStorageExampleActivity;
import com.simform.rushabhmodi.androidlearning.exampleactivities.OkHttpExampleActivity;
import com.simform.rushabhmodi.androidlearning.exampleactivities.RetrofitExampleActivity;
import com.simform.rushabhmodi.androidlearning.exampleactivities.SimpleRecyclerViewExampleActivity;
import com.simform.rushabhmodi.androidlearning.exampleactivities.InternalStorageExampleActivity;
import com.simform.rushabhmodi.androidlearning.exampleactivities.ListFragmentExampleActivity;
import com.simform.rushabhmodi.androidlearning.exampleactivities.RoomLibraryExampleActivity;
import com.simform.rushabhmodi.androidlearning.exampleactivities.SearchExampleActivity;
import com.simform.rushabhmodi.androidlearning.exampleactivities.SharedPreferencesExampleActivity;
import com.simform.rushabhmodi.androidlearning.exampleactivities.SqliteDatabaseExampleActivity;
import com.simform.rushabhmodi.androidlearning.exampleactivities.WebServiceExampleActivity;
import com.simform.rushabhmodi.androidlearning.model.ExamplesDataFactory;
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
                    case ExamplesDataFactory.parent3child1:
                        childContext.startActivity(new Intent(childContext, SimpleRecyclerViewExampleActivity.class));
                        break;
                    case ExamplesDataFactory.parent3child2:
                        childContext.startActivity(new Intent(childContext, ExpandableRecyclerViewExampleActivity.class));
                        break;
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
                    case ExamplesDataFactory.parent5child3:
                        childContext.startActivity(new Intent(childContext, ExternalStorageExampleActivity.class));
                        break;
                    case ExamplesDataFactory.parent5child4:
                        childContext.startActivity(new Intent(childContext, SqliteDatabaseExampleActivity.class));
                        break;
                    case ExamplesDataFactory.parent5child5:
                        childContext.startActivity(new Intent(childContext, RoomLibraryExampleActivity.class));
                        break;
                    case ExamplesDataFactory.parent8child1:
                        childContext.startActivity(new Intent(childContext, SearchExampleActivity.class).putExtra(childContext.getString(R.string.search_type), childContext.getString(R.string.search_simple)));
                        break;
                    case ExamplesDataFactory.parent8child2:
                        childContext.startActivity(new Intent(childContext, SearchExampleActivity.class).putExtra(childContext.getString(R.string.search_type), childContext.getString(R.string.search_enhanced)));
                        break;
                    case ExamplesDataFactory.parent16child1:
                        childContext.startActivity(new Intent(childContext, WebServiceExampleActivity.class));
                        break;
                    case ExamplesDataFactory.parent16child2:
                        childContext.startActivity(new Intent(childContext, OkHttpExampleActivity.class));
                        break;
                    case ExamplesDataFactory.parent16child3:
                        childContext.startActivity(new Intent(childContext, RetrofitExampleActivity.class));
                        break;
                }
            }
        });
    }

    public void setChildText(String text) {
        childText.setText(text);
    }

}
