package com.simform.rushabhmodi.androidlearning.viewholder;

import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.simform.rushabhmodi.androidlearning.R;
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

/**
 * Created by rushabh.modi on 31/01/18.
 */

public class ErvChildViewHolder extends ChildViewHolder {

    private TextView ervChildText;
    private CardView ervChildCard;

    public ErvChildViewHolder(final View itemView) {
        super(itemView);
        ervChildText = itemView.findViewById(R.id.textview_erv_child);
        ervChildCard = itemView.findViewById(R.id.cardview_erv_child);
        ervChildCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(itemView.getContext(), ervChildText.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void setErvChildText(String text) {
        ervChildText.setText(text);
    }
}
