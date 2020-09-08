package com.example.multiapptest.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.multiapptest.R;
import com.example.multiapptest.data.MovieItem;
import com.example.multiapptest.util.ImageLoader;

import java.util.List;

public class MoviesListAdapter extends RecyclerView.Adapter<MoviesListAdapter.MovieViewHolder> {

    private List<MovieItem> movies;

    public MoviesListAdapter(List<MovieItem> movies) {
        this.movies = movies;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_item, parent,false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        MovieItem movie = movies.get(position);
        holder.title.setText(movie.getTitle());
        holder.vote.setText(String.valueOf(movie.getVoteAverage()));
        ImageLoader.loadImage(movie.getPosterPath(), holder.posterImage);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public void setMovies(List<MovieItem> movies) {
        this.movies = movies;
    }

    static class MovieViewHolder extends RecyclerView.ViewHolder {
        ImageView posterImage;
        TextView title, vote;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.movie_title);
            vote = itemView.findViewById(R.id.vote);
            posterImage = itemView.findViewById(R.id.poster);
        }
    }
}
