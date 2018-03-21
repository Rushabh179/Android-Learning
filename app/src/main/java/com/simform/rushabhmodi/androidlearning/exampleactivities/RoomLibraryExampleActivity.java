package com.simform.rushabhmodi.androidlearning.exampleactivities;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.simform.rushabhmodi.androidlearning.R;
import com.simform.rushabhmodi.androidlearning.adapter.RoomRecyclerAdapter;
import com.simform.rushabhmodi.androidlearning.model.RoomTableData;
import com.simform.rushabhmodi.androidlearning.other.RoomAddActivity;
import com.simform.rushabhmodi.androidlearning.other.RoomAppDatabase;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * Visit https://github.com/Pavneet-Sing/RoomDemo
 * https://www.pluralsight.com/guides/android/making-a-notes-app-using-room-database
 */

public class RoomLibraryExampleActivity extends BaseExampleActivity implements RoomRecyclerAdapter.OnRoomItemClickListener {

    private RecyclerView roomRecyclerView;
    private RoomAppDatabase roomAppDatabase;
    private List<RoomTableData> roomItemList;
    private RoomRecyclerAdapter roomRecyclerAdapter;
    private DividerItemDecoration decoration;
    private int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_layout_recyclerview);

        roomRecyclerView = findViewById(R.id.recyclerview_base);
        roomRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        roomItemList = new ArrayList<>();
        roomRecyclerAdapter = new RoomRecyclerAdapter(roomItemList, RoomLibraryExampleActivity.this);
        roomRecyclerView.setAdapter(roomRecyclerAdapter);

        decoration = new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL);
        roomRecyclerView.addItemDecoration(decoration);

        roomAppDatabase = RoomAppDatabase.getInstance(this);
        new RetrieveTask(this).execute();

    }

    @Override
    protected void onDestroy() {
        RoomAppDatabase.cleanUp();
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_room_add, menu);
        return true;
    }

    @SuppressLint("InflateParams")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_room_add) {
            startActivityForResult(new Intent(this, RoomAddActivity.class), 100);
        } else {
            finish();
        }
        return false;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 100 && resultCode > 0) {
            if (resultCode == 1) {
                roomItemList.add((RoomTableData) data.getSerializableExtra(getString(R.string.room_extra)));
            } else if (resultCode == 2) {
                roomItemList.set(pos, (RoomTableData) data.getSerializableExtra(getString(R.string.room_extra)));
            }
            roomRecyclerAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onRoomItemClick(final int pos) {
        new AlertDialog.Builder(RoomLibraryExampleActivity.this)
                .setTitle(getString(R.string.room_option_select))
                .setItems(new String[]{getString(R.string.room_option_delete), getString(R.string.room_option_update)},
                        new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        switch (i) {
                            case 0:
                                roomAppDatabase.getRoomDao().deleteItem(roomItemList.get(pos));
                                roomItemList.remove(pos);
                                roomRecyclerAdapter.notifyDataSetChanged();
                                break;
                            case 1:
                                RoomLibraryExampleActivity.this.pos = pos;
                                startActivityForResult(
                                        new Intent(RoomLibraryExampleActivity.this,
                                                RoomAddActivity.class).putExtra(getString(R.string.room_extra), roomItemList.get(pos)),
                                        100);

                                break;
                        }
                    }
                }).show();
    }

    private static class RetrieveTask extends AsyncTask<Void, Void, List<RoomTableData>> {

        private WeakReference<RoomLibraryExampleActivity> activityReference;

        // only retain a weak reference to the activity
        RetrieveTask(RoomLibraryExampleActivity context) {
            activityReference = new WeakReference<>(context);
        }

        @Override
        protected List<RoomTableData> doInBackground(Void... voids) {
            if (activityReference.get() != null)
                return activityReference.get().roomAppDatabase.getRoomDao().getAll();
            else
                return null;
        }

        @Override
        protected void onPostExecute(List<RoomTableData> roomItemList) {
            if (roomItemList != null && roomItemList.size() > 0) {
                activityReference.get().roomItemList.clear();
                activityReference.get().roomItemList.addAll(roomItemList);
                activityReference.get().roomRecyclerAdapter.notifyDataSetChanged();
            }
        }
    }
}
