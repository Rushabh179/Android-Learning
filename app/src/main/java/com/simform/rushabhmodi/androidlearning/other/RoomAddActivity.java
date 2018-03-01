package com.simform.rushabhmodi.androidlearning.other;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

import com.simform.rushabhmodi.androidlearning.R;

import java.lang.ref.WeakReference;

public class RoomAddActivity extends AppCompatActivity {

    private TextInputEditText roomTitleText, roomDetailsText;
    private RoomAppDatabase roomAppDatabase;
    private RoomTableData roomTableData;
    private boolean update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_add);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        roomTitleText = findViewById(R.id.textinputedittext_room_title);
        roomDetailsText = findViewById(R.id.textinputedittext_room_details);
        roomAppDatabase = RoomAppDatabase.getInstance(RoomAddActivity.this);

        if ((roomTableData = (RoomTableData) getIntent().getSerializableExtra(getString(R.string.room_extra))) != null) {
            update = true;
            roomTitleText.setText(roomTableData.getRoomItemName());
            roomDetailsText.setText(roomTableData.getRoomItemDetails());
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return false;
    }

    public void onRoomAddClick(View view) {
        if (update) {
            roomTableData.setRoomItemDetails(roomDetailsText.getText().toString());
            roomTableData.setRoomItemName(roomTitleText.getText().toString());
            roomAppDatabase.getRoomDao().updateItem(roomTableData);
            roomSetResult(roomTableData, 2);
        } else {
            roomTableData = new RoomTableData(roomDetailsText.getText().toString(), roomTitleText.getText().toString());
            new InsertTask(RoomAddActivity.this, roomTableData).execute();
        }
    }

    private void roomSetResult(RoomTableData roomTableData, int flag) {
        setResult(flag, new Intent().putExtra(getString(R.string.room_extra), roomTableData));
        finish();
    }

    private static class InsertTask extends AsyncTask<Void, Void, Boolean> {

        private WeakReference<RoomAddActivity> activityReference;
        private RoomTableData roomTableData;

        // only retain a weak reference to the activity
        InsertTask(RoomAddActivity context, RoomTableData roomTableData) {
            activityReference = new WeakReference<>(context);
            this.roomTableData = roomTableData;
        }

        // doInBackground methods runs on a worker thread
        @Override
        protected Boolean doInBackground(Void... objs) {
            // retrieve auto incremented item id
            long j = activityReference.get().roomAppDatabase.getRoomDao().inserItem(roomTableData);
            roomTableData.setRoomId(j);
            return true;
        }

        // onPostExecute runs on main thread
        @Override
        protected void onPostExecute(Boolean bool) {
            if (bool) {
                activityReference.get().roomSetResult(roomTableData, 1);
                activityReference.get().finish();
            }
        }
    }
}
