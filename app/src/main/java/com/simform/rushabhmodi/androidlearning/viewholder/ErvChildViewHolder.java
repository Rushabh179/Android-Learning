package com.simform.rushabhmodi.androidlearning.viewholder;

import android.view.View;
import android.widget.TextView;

import com.simform.rushabhmodi.androidlearning.R;
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

/**
 * Created by rushabh.modi on 31/01/18.
 */

public class ErvChildViewHolder extends ChildViewHolder {

    private TextView ervChildText;

    public ErvChildViewHolder(View itemView) {
        super(itemView);
        ervChildText = itemView.findViewById(R.id.textview_erv_child);
    }

    public void setErvChildText(String text) {
        ervChildText.setText(text);
    }
}
