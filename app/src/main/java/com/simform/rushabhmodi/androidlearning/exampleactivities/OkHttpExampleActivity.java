package com.simform.rushabhmodi.androidlearning.exampleactivities;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.simform.rushabhmodi.androidlearning.R;
import com.simform.rushabhmodi.androidlearning.adapter.OkHttpRecyclerAdapter;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpExampleActivity extends BaseExampleActivity {

    private RecyclerView okHttpList;
    private OkHttpRecyclerAdapter okHttpRecyclerAdapter;
    private SwipeRefreshLayout okHttpSwipeRefresh;
    //private static final String url = "https://api.androidhive.info/contacts/";
    private static final String url = "https://randomuser.me/api/";

    private ArrayList<HashMap<String, String>> infoList;
    private HashMap<String, String> info;

    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttp_example);

        Toast.makeText(this, "Swipe to refresh", Toast.LENGTH_LONG).show();

        infoList = new ArrayList<>();
        handler = new Handler(Looper.getMainLooper());

        okHttpList = findViewById(R.id.recyclerview_okhttp);
        okHttpList.setLayoutManager(new LinearLayoutManager(this));
        okHttpList.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        okHttpSwipeRefresh = findViewById(R.id.swiperefresh_okhttp);

        try {
            okHttpRun();
            okHttpRecyclerAdapter = new OkHttpRecyclerAdapter(infoList);
            okHttpRecyclerAdapter.notifyDataSetChanged();
            okHttpList.setAdapter(okHttpRecyclerAdapter);
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*okHttpRecyclerAdapter = new OkHttpRecyclerAdapter(infoList);
        okHttpRecyclerAdapter.notifyDataSetChanged();
        okHttpList.setAdapter(okHttpRecyclerAdapter);*/

        okHttpSwipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                try {
                    okHttpRecyclerAdapter.notifyDataSetChanged();
                    okHttpRun();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                okHttpSwipeRefresh.setRefreshing(false);
            }
        });
    }

    void okHttpRun() throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                call.cancel();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                @SuppressWarnings("ConstantConditions") final String jsonResponse = response.body().string();
                //OkHttpExampleActivity.this.runOnUiThread(new Runnable() {
                //@Override
                //  public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            JSONObject json = new JSONObject(jsonResponse);
                            info = new HashMap<>();
                            String fullname = json.getJSONArray("results").getJSONObject(0).getJSONObject("name").getString("first");
                            Log.i("Names:", fullname);
                            info.put("name", fullname);

                            infoList.add(info);
                            //txtString.setText(json.getJSONObject("data").getString("first_name")+ " "+json.getJSONObject("data").getString("last_name"));

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                });
                //}
                // });
            }
        });

        okHttpRecyclerAdapter = new OkHttpRecyclerAdapter(infoList);
        okHttpRecyclerAdapter.notifyDataSetChanged();
        okHttpList.setAdapter(okHttpRecyclerAdapter);
    }
}
