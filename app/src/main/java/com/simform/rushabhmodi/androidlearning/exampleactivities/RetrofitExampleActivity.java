package com.simform.rushabhmodi.androidlearning.exampleactivities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.simform.rushabhmodi.androidlearning.R;
import com.simform.rushabhmodi.androidlearning.adapter.RetrofitRecyclerAdapter;
import com.simform.rushabhmodi.androidlearning.interfaces.RetrofitApiInterface;
import com.simform.rushabhmodi.androidlearning.model.RetrofitMovie;
import com.simform.rushabhmodi.androidlearning.model.RetrofitMoviesResponse;
import com.simform.rushabhmodi.androidlearning.other.RetrofitApiClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitExampleActivity extends AppCompatActivity {

    private final static String API_KEY = "7e8f60e325cd06e164799af1e317d7a7";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_layout_recyclerview);

        if (API_KEY.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please obtain your API KEY from themoviedb.org first!", Toast.LENGTH_LONG).show();
        }

        final RecyclerView recyclerView = findViewById(R.id.recyclerview_base);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        RetrofitApiInterface apiService =
                RetrofitApiClient.getClient().create(RetrofitApiInterface.class);

        Call<RetrofitMoviesResponse> call = apiService.getTopRatedMovies(API_KEY);
        call.enqueue(new Callback<RetrofitMoviesResponse>() {
            @Override
            public void onResponse(@NonNull Call<RetrofitMoviesResponse> call, @NonNull Response<RetrofitMoviesResponse> response) {
                int statusCode = response.code();
                List<RetrofitMovie> movies = response.body().getResults();
                recyclerView.setAdapter(new RetrofitRecyclerAdapter(movies, R.layout.list_item_retrofit, getApplicationContext()));
            }

            @Override
            public void onFailure(@NonNull Call<RetrofitMoviesResponse> call, @NonNull Throwable throwable) {
                // Log error here since request failed
               call.cancel();
            }
        });
    }
}
