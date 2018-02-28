package com.simform.rushabhmodi.androidlearning.test;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.simform.rushabhmodi.androidlearning.R;
import com.simform.rushabhmodi.androidlearning.interfaces.OnRecyclerItemClickListener;

import java.util.List;

/**
 * Created by rushabh.modi on 28/02/18.
 */

public class RoomRecyclerAdapter extends RecyclerView.Adapter<RoomRecyclerAdapter.ViewHolder> {

    private List<String> roomItemList;
    private OnRecyclerItemClickListener onRecyclerItemClickListener;

    public RoomRecyclerAdapter(List<String> roomItemList) {
        this.roomItemList = roomItemList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_item_room_recycler, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.roomListText.setText(roomItemList.get(position));
    }

    @Override
    public int getItemCount() {
        return roomItemList.size();
    }

    public void setOnReclyclerItemClickListener(OnRecyclerItemClickListener onReclyclerItemClickListener) {
        this.onRecyclerItemClickListener = onReclyclerItemClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView roomListText;

        public ViewHolder(final View itemView) {
            super(itemView);
            roomListText = itemView.findViewById(R.id.textview_room_item);
            /*baseRecyclerText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (onRecyclerItemClickListener != null) {
                        onRecyclerItemClickListener.onRecyclerItemCLick(view, getAdapterPosition());
                    }
                }
            });*/
        }
    }
}
