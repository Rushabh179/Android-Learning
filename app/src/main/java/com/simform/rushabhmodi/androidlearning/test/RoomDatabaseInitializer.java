package com.simform.rushabhmodi.androidlearning.test;

import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.List;

/**
 * Created by rushabh.modi on 01/03/18.
 */

public class RoomDatabaseInitializer {

    private static final String TAG = RoomDatabaseInitializer.class.getName();

    public static void populateAsync(@NonNull final RoomAppDatabase db) {
        PopulateDbAsync task = new PopulateDbAsync(db);
        task.execute();
    }

    public static void populateSync(@NonNull final RoomAppDatabase db) {
        populateWithTestData(db);
    }

    private static RoomTableData addItem(final RoomAppDatabase db, RoomTableData roomTableData) {
        db.getRoomDao().insertAll(roomTableData);
        return roomTableData;
    }

    private static void populateWithTestData(RoomAppDatabase db) {
        RoomTableData roomTableData = new RoomTableData();
        roomTableData.setRoomItemName("Item");
        addItem(db, roomTableData);

        List<RoomTableData> roomTableList = db.getRoomDao().getAll();
        Log.d(RoomDatabaseInitializer.TAG, "Rows Count: " + roomTableList.size());

    }

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final RoomAppDatabase mDb;

        PopulateDbAsync(RoomAppDatabase db) {
            mDb = db;
        }

        @Override
        protected Void doInBackground(final Void... params) {
            populateWithTestData(mDb);
            return null;
        }
    }
}
