package com.simform.rushabhmodi.androidlearning.interfaces;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.simform.rushabhmodi.androidlearning.other.RoomTableData;

import java.util.List;

/**
 * Created by rushabh.modi on 01/03/18.
 */

@Dao
public interface RoomDao {

    @Query("SELECT * FROM roomtable")
    List<RoomTableData> getAll();

    @Insert
    long inserItem(RoomTableData roomTableData);

    @Update
    void updateItem(RoomTableData roomTableData);

    @Delete
    void deleteItem(RoomTableData roomTableData);

}
