package com.simform.rushabhmodi.androidlearning.other;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.simform.rushabhmodi.androidlearning.R;
import com.simform.rushabhmodi.androidlearning.interfaces.RoomDao;
import com.simform.rushabhmodi.androidlearning.model.RoomTableData;

/**
 * Created by rushabh.modi on 01/03/18.
 */

@Database(entities = {RoomTableData.class}, version = 1, exportSchema = false)
public abstract class RoomAppDatabase extends RoomDatabase {

    private static RoomAppDatabase roomAppDatabaseInstance;

    public abstract RoomDao getRoomDao();

    // synchronized is use to avoid concurrent access in multithred environment
    public static /*synchronized*/ RoomAppDatabase getInstance(Context context) {
        if (null == roomAppDatabaseInstance) {
            roomAppDatabaseInstance = buildDatabaseInstance(context);
        }
        return roomAppDatabaseInstance;
    }

    private static RoomAppDatabase buildDatabaseInstance(Context context) {
        return Room.databaseBuilder(context, RoomAppDatabase.class, context.getString(R.string.room_database_name)).allowMainThreadQueries().build();
    }

    public static void cleanUp() {
        roomAppDatabaseInstance = null;
    }
}
