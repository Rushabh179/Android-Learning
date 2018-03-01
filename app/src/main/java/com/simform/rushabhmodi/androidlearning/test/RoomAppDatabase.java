package com.simform.rushabhmodi.androidlearning.test;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

/**
 * Created by rushabh.modi on 01/03/18.
 */

@Database(entities = {RoomTableData.class}, version = 1)
@TypeConverters({RoomDataConverter.class})
public abstract class RoomAppDatabase extends RoomDatabase {

    //private static RoomAppDatabase INSTANCE;
    private static RoomAppDatabase roomAppDatabaseInstance;

    //public abstract RoomDao roomDao();
    public abstract RoomDao getRoomDao();

    /*public static RoomAppDatabase getRoomAppDatabase(Context context) {
        if (roomAppDatabaseInstance == null) {
            roomAppDatabaseInstance =
                    Room.databaseBuilder(context.getApplicationContext(), RoomAppDatabase.class, "room-database")
                            // allow queries on the main thread.
                            // Don't do this on a real app! See PersistenceBasicSample for an example.
                            .allowMainThreadQueries()
                            .build();
        }
        return roomAppDatabaseInstance;
    }

    public static void destroyInstance() {
        roomAppDatabaseInstance = null;
    }*/

    // synchronized is use to avoid concurrent access in multithred environment
    public static /*synchronized*/ RoomAppDatabase getInstance(Context context) {
        if (null == roomAppDatabaseInstance) {
            roomAppDatabaseInstance = buildDatabaseInstance(context);
        }
        return roomAppDatabaseInstance;
    }

    private static RoomAppDatabase buildDatabaseInstance(Context context) {
        return Room.databaseBuilder(context, RoomAppDatabase.class, "roomdatabasename.db").allowMainThreadQueries().build();
    }

    public static void cleanUp(){
        roomAppDatabaseInstance = null;
    }

}
