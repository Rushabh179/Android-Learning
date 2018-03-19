package com.simform.rushabhmodi.androidlearning.exampleactivities;

import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.simform.rushabhmodi.androidlearning.R;

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

public class OkHttpExampleActivity extends AppCompatActivity {

    private ListView okHttpList;
    private SwipeRefreshLayout okHttpSwipeRefresh;
    //private static final String url = "https://api.androidhive.info/contacts/";
    private static final String url = "https://randomuser.me/api/";

    private ArrayList<HashMap<String, String>> infoList;
    private HashMap<String, String> info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_service_example);
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        infoList = new ArrayList<>();
        info = new HashMap<>();
        okHttpList = findViewById(R.id.listview_web_service);
        okHttpSwipeRefresh = findViewById(R.id.swiperefresh_web_service);

        okHttpSwipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                try {
                    okHttpRun();
                    okHttpSwipeRefresh.setRefreshing(false);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        try {
            okHttpRun();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void okHttpRun() throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient();

        Request request = new Request.Builder().url(url).build();
        for (int i = 0; i <= 5; i++) {
            okHttpClient.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(@NonNull Call call, @NonNull IOException e) {
                    call.cancel();
                }

                @Override
                public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                    @SuppressWarnings("ConstantConditions") final String jsonResponse = response.body().string();
                    OkHttpExampleActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                JSONObject json = new JSONObject(jsonResponse);

                                Toast.makeText(OkHttpExampleActivity.this,
                                        json.getJSONArray("results").getJSONObject(0).getJSONObject("name").getString("first"),
                                        Toast.LENGTH_SHORT).show();
                                String fullname = json.getJSONArray("results").getJSONObject(0).getJSONObject("name").getString("first");
                                info.put("name", fullname);

                                infoList.add(info);
                                //txtString.setText(json.getJSONObject("data").getString("first_name")+ " "+json.getJSONObject("data").getString("last_name"));

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
            });
        }

        ListAdapter adapter = new SimpleAdapter(
                OkHttpExampleActivity.this, infoList, R.layout.list_item_web_service,
                new String[]{"name"}, //"mobile", "email"},
                new int[]{R.id.textview_web_service_name});//, R.id.textview_web_service_phone, R.id.textview_web_service_email});

        okHttpList.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return false;
    }
}
