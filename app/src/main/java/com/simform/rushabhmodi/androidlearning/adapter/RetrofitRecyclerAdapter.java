package com.simform.rushabhmodi.androidlearning.adapter;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.simform.rushabhmodi.androidlearning.R;
import com.simform.rushabhmodi.androidlearning.model.RetrofitMovie;

import java.util.List;

/**
 * Created by rushabh.modi on 19/03/18.
 */

public class RetrofitRecyclerAdapter  extends RecyclerView.Adapter<RetrofitRecyclerAdapter.MovieViewHolder> {

    private List<RetrofitMovie> movies;
    private int rowLayout;
    private Context context;

    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        ConstraintLayout moviesLayout;
        TextView movieTitle;
        TextView data;
        TextView movieDescription;
        TextView rating;

        public MovieViewHolder(View v) {
            super(v);
            moviesLayout = v.findViewById(R.id.constraintlayout_retrofit);
            movieTitle = v.findViewById(R.id.textview_movie_title);
            data = v.findViewById(R.id.textview_movie_subtitle);
            movieDescription = v.findViewById(R.id.textview_movie_description);
            rating = v.findViewById(R.id.textview_movie_rating);
        }
    }

    public RetrofitRecyclerAdapter(List<RetrofitMovie> movies, int rowLayout, Context context) {
        this.movies = movies;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public RetrofitRecyclerAdapter.MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new MovieViewHolder(view);
    }


    @Override
    public void onBindViewHolder(MovieViewHolder holder, final int position) {
        holder.movieTitle.setText(movies.get(position).getTitle());
        holder.data.setText(movies.get(position).getReleaseDate());
        holder.movieDescription.setText(movies.get(position).getOverview());
        holder.rating.setText(movies.get(position).getVoteAverage().toString());
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }
}
