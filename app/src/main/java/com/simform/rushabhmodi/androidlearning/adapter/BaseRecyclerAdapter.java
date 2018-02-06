package com.simform.rushabhmodi.androidlearning.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.simform.rushabhmodi.androidlearning.R;
import com.simform.rushabhmodi.androidlearning.interfaces.OnRecyclerItemClickListener;

import java.util.List;

/**
 * Created by rushabh.modi on 30/01/18.
 */

public class BaseRecyclerAdapter extends RecyclerView.Adapter<BaseRecyclerAdapter.ViewHolder> {

    private List<String> titleTextList;
    private OnRecyclerItemClickListener onRecyclerItemClickListener;

    public BaseRecyclerAdapter(List<String> titleTextList) {
        this.titleTextList = titleTextList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_item_base_recycler, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.baseRecyclerText.setText(titleTextList.get(position));
    }

    @Override
    public int getItemCount() {
        return titleTextList.size();
    }

    public void setOnReclyclerItemClickListener(OnRecyclerItemClickListener onReclyclerItemClickListener) {
        this.onRecyclerItemClickListener = onReclyclerItemClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView baseRecyclerText;
        private CardView baseRecyclerCard;

        public ViewHolder(final View itemView) {
            super(itemView);
            baseRecyclerText = itemView.findViewById(R.id.textview_base_recycler);
            baseRecyclerCard = itemView.findViewById(R.id.cardview_base_recycler);
            baseRecyclerCard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (onRecyclerItemClickListener != null){
                        onRecyclerItemClickListener.onRecyclerItemCLick(view, getAdapterPosition());
                    }
                }
            });
        }
    }
}
