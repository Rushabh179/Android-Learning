package com.simform.rushabhmodi.androidlearning.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;

/**
 * Created by rushabh.modi on 01/03/18.
 */

@Entity(tableName = "roomtable")
public class RoomTableData implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private long roomId;

    @ColumnInfo(name = "item_name")
    private String roomItemName;
    private String roomItemDetails;

    public RoomTableData(String roomItemDetails, String roomItemName) {
        this.roomItemDetails = roomItemDetails;
        this.roomItemName = roomItemName;
    }

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }

    public String getRoomItemName() {
        return roomItemName;
    }

    public void setRoomItemName(String roomItemName) {
        this.roomItemName = roomItemName;
    }

    public String getRoomItemDetails() {
        return roomItemDetails;
    }

    public void setRoomItemDetails(String roomItemDetails) {
        this.roomItemDetails = roomItemDetails;
    }

}
