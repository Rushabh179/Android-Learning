package com.simform.rushabhmodi.androidlearning.test;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by rushabh.modi on 01/03/18.
 */

@Entity(tableName = "roomtable")
public class RoomTableData implements Serializable{

    @PrimaryKey(autoGenerate = true)
    private long roomId;

    @ColumnInfo(name = "item_name")
    private String roomItemName;

    private String roomItemDetails;

    private Date date;

    public RoomTableData(String roomItemDetails, String roomItemName) {
        this.roomItemDetails = roomItemDetails;
        this.roomItemName = roomItemName;
        this.date = new Date(System.currentTimeMillis());
    }

    @Ignore
    public RoomTableData(){}

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RoomTableData)) return false;

        RoomTableData note = (RoomTableData) o;

        if (roomId != note.roomId) return false;
        return roomItemName != null ? roomItemName.equals(note.roomItemName) : note.roomItemName == null;
    }



    @Override
    public int hashCode() {
        int result = (int)roomId;
        result = 31 * result + (roomItemName != null ? roomItemName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Note{" +
                "note_id=" + roomId +
                ", content='" + roomItemDetails + '\'' +
                ", title='" + roomItemName + '\'' +
                ", date=" + date +
                '}';
    }

}
