package com.simform.rushabhmodi.androidlearning.test;

import android.content.Context;
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

    private List<RoomTableData> roomItemList;
    private Context context;
    private LayoutInflater layoutInflater;
    private OnRecyclerItemClickListener onRecyclerItemClickListener;
    private OnNoteItemClick onNoteItemClick;

    public RoomRecyclerAdapter(List<RoomTableData> roomItemList, Context context) {
        this.roomItemList = roomItemList;
        this.context = context;
        this.onNoteItemClick = (OnNoteItemClick) context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        layoutInflater = LayoutInflater.from(parent.getContext());
        //View view = layoutInflater.inflate(R.layout.list_item_room_recycler, parent, false);
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

    /*public void setOnReclyclerItemClickListener(OnRecyclerItemClickListener onReclyclerItemClickListener) {
        this.onRecyclerItemClickListener = onReclyclerItemClickListener;
    }*/

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView roomListText;

        public ViewHolder(final View itemView) {
            super(itemView);
            roomListText = itemView.findViewById(R.id.textview_simple_recycler);
            roomListText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onNoteItemClick.onNoteClick(getAdapterPosition());
                }
            });
            /*roomListText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (onRecyclerItemClickListener != null) {
                        onRecyclerItemClickListener.onRecyclerItemCLick(view, getAdapterPosition());
                    }
                }
            });
            roomListText.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    int position = getAdapterPosition();
                    roomItemList.remove(position);
                    notifyItemRemoved(position);
                    notifyItemRangeChanged(position, roomItemList.size());
                    return false;
                }
            });*/
        }
    }

    public interface OnNoteItemClick{
        void onNoteClick(int pos);
    }
}
