package com.simform.rushabhmodi.androidlearning.viewholder;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.simform.rushabhmodi.androidlearning.R;
import com.simform.rushabhmodi.androidlearning.activitymain.OptionsActivity;
import com.simform.rushabhmodi.androidlearning.exampleactivities.GestureExampleActivity;
import com.simform.rushabhmodi.androidlearning.exampleactivities.IntentExampleActivity;
import com.simform.rushabhmodi.androidlearning.exampleactivities.CollapsingToolbarExampleActivity;
import com.simform.rushabhmodi.androidlearning.exampleactivities.DesingSupportExampleActivity;
import com.simform.rushabhmodi.androidlearning.exampleactivities.NotificationExapleActivity;
import com.simform.rushabhmodi.androidlearning.exampleactivities.PermissionExampleActivity;
import com.simform.rushabhmodi.androidlearning.exampleactivities.ServiceExampleActivity;
import com.simform.rushabhmodi.androidlearning.exampleactivities.TextInputExampleActivity;
import com.simform.rushabhmodi.androidlearning.exampleactivities.WebViewExampleActivity;
import com.simform.rushabhmodi.androidlearning.exampleactivities.WidgetsExampleActivity;
import com.simform.rushabhmodi.androidlearning.model.ExamplesDataFactory;
import com.simform.rushabhmodi.androidlearning.exampleactivities.ScrollViewsExampleActivity;
import com.simform.rushabhmodi.androidlearning.test.ContentProviderExampleActivity;
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
            case ExamplesDataFactory.parent6:
                parentContext.startActivity(new Intent(parentContext, CollapsingToolbarExampleActivity.class));
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
            case ExamplesDataFactory.parent11:
                parentContext.startActivity(new Intent(parentContext, DesingSupportExampleActivity.class));
                break;
            case ExamplesDataFactory.parent12:
                parentContext.startActivity(new Intent(parentContext, WidgetsExampleActivity.class));
                break;
            case ExamplesDataFactory.parent13:
                parentContext.startActivity(new Intent(parentContext, PermissionExampleActivity.class));
                break;
            case ExamplesDataFactory.parent14:
                parentContext.startActivity(new Intent(parentContext, NotificationExapleActivity.class));
                break;
            case ExamplesDataFactory.parent15:
                parentContext.startActivity(new Intent(parentContext, ServiceExampleActivity.class));
                break;
            case ExamplesDataFactory.parent17:
                parentContext.startActivity(new Intent(parentContext, OptionsActivity.class));
                break;
            case ExamplesDataFactory.parent18:
                parentContext.startActivity(new Intent(parentContext, ContentProviderExampleActivity.class));
                break;
            default:
                super.onClick(v);
        }
    }
}
