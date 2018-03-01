package com.simform.rushabhmodi.androidlearning.test;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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

        roomTitleText = findViewById(R.id.textinputedittext_room_title);
        roomDetailsText = findViewById(R.id.textinputedittext_room_details);
        roomAppDatabase = roomAppDatabase.getInstance(RoomAddActivity.this);

        if ( (roomTableData = (RoomTableData) getIntent().getSerializableExtra("note"))!=null ){
            //getSupportActionBar().setTitle("Update Note");
            update = true;
            //button.setText("Update");
            roomTitleText.setText(roomTableData.getRoomItemName());
            roomDetailsText.setText(roomTableData.getRoomItemDetails());
        }
    }

    public void onRoomAddClick(View view) {
        if (update){
            roomTableData.setRoomItemDetails(roomDetailsText.getText().toString());
            roomTableData.setRoomItemName(roomTitleText.getText().toString());
            roomAppDatabase.getRoomDao().updateItem(roomTableData);
            roomSetResult(roomTableData,2);
        }else {
            roomTableData = new RoomTableData(roomDetailsText.getText().toString(), roomTitleText.getText().toString());
            new InsertTask(RoomAddActivity.this,roomTableData).execute();
        }
    }

    private void roomSetResult(RoomTableData roomTableData, int flag){
        setResult(flag,new Intent().putExtra("note",roomTableData));
        finish();
    }

    private static class InsertTask extends AsyncTask<Void,Void,Boolean> {

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
            // retrieve auto incremented note id
            long j = activityReference.get().roomAppDatabase.getRoomDao().inserItem(roomTableData);
            roomTableData.setRoomId(j);
            Log.e("ID ", "doInBackground: "+j );
            return true;
        }

        // onPostExecute runs on main thread
        @Override
        protected void onPostExecute(Boolean bool) {
            if (bool){
                activityReference.get().roomSetResult(roomTableData,1);
                activityReference.get().finish();
            }
        }
    }

}
