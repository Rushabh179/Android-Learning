package com.simform.rushabhmodi.androidlearning.test;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by rushabh.modi on 01/03/18.
 */

@Dao
public interface RoomDao {

    @Query("SELECT * FROM roomtable")
    List<RoomTableData> getAll();

    /*@Query("SELECT item_name FROM roomtable")
    List<RoomTableData> getItems();*/

    @Insert
    long inserItem(RoomTableData roomTableData);

    @Insert
    void insertAll(RoomTableData... roomTableDatas);

    @Update
    void updateItem(RoomTableData repos);

    @Delete
    void deleteItem(RoomTableData roomTableData);

    @Delete
    void deleteAll(RoomTableData... roomTableDatas);

}
