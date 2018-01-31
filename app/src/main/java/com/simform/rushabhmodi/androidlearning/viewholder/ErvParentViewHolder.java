package com.simform.rushabhmodi.androidlearning.viewholder;

import android.view.View;
import android.widget.TextView;

import com.simform.rushabhmodi.androidlearning.R;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

/**
 * Created by rushabh.modi on 31/01/18.
 */

public class ErvParentViewHolder extends GroupViewHolder {

    private TextView ervParentText;

    public ErvParentViewHolder(View itemView) {
        super(itemView);
        ervParentText = itemView.findViewById(R.id.textview_erv_parent);
    }

    public void setErvParentText(ExpandableGroup ervParent){
        ervParentText.setText(ervParent.getTitle());
    }

}
