package com.simform.rushabhmodi.androidlearning.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.simform.rushabhmodi.androidlearning.R;
import com.simform.rushabhmodi.androidlearning.other.RoomTableData;

import java.util.List;

/**
 * Created by rushabh.modi on 28/02/18.
 */

public class RoomRecyclerAdapter extends RecyclerView.Adapter<RoomRecyclerAdapter.ViewHolder> {

    private List<RoomTableData> roomItemList;
    private LayoutInflater layoutInflater;
    private OnRoomItemClickListener onRoomItemClickListener;

    public RoomRecyclerAdapter(List<RoomTableData> roomItemList, Context context) {
        this.roomItemList = roomItemList;
        this.onRoomItemClickListener = (OnRoomItemClickListener) context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_item_simple_recycler, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.roomListText.setText(roomItemList.get(position).getRoomItemName());
    }

    @Override
    public int getItemCount() {
        return roomItemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView roomListText;

        public ViewHolder(final View itemView) {
            super(itemView);
            roomListText = itemView.findViewById(R.id.textview_simple_recycler);
            roomListText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onRoomItemClickListener.onRoomItemClick(getAdapterPosition());
                }
            });
        }
    }

    public interface OnRoomItemClickListener {
        void onRoomItemClick(int pos);
    }
}
