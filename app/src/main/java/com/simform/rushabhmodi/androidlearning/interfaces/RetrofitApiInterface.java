package com.simform.rushabhmodi.androidlearning.interfaces;

import com.simform.rushabhmodi.androidlearning.model.RetrofitMoviesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by rushabh.modi on 19/03/18.
 */

public interface RetrofitApiInterface {

    @GET("movie/top_rated")
    Call<RetrofitMoviesResponse> getTopRatedMovies(@Query("api_key") String apiKey);

    @GET("movie/{id}")
    Call<RetrofitMoviesResponse> getMovieDetails(@Path("id") int id, @Query("api_key") String apiKey);
}
