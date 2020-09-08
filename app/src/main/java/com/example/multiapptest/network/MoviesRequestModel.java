package com.example.multiapptest.network;

import android.util.Log;

import com.example.multiapptest.data.DiscoverMovies;
import com.example.multiapptest.data.MovieItem;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MoviesRequestModel {

    private final TmdbService tmdb = TmdbService.getTmdbInstance();
    private final List<MovieItem> movies = new ArrayList<>();

    public List<MovieItem> getDiscoverMovies()  {

        tmdb.getRequest()
                .discoverMovies(TmdbApi.API_KEY)
                .enqueue(new Callback<DiscoverMovies>() {
                    @Override
                    public void onResponse(Call<DiscoverMovies> call,
                                           Response<DiscoverMovies> response) {
                        if (response.isSuccessful() & response.body() != null) {
                            movies.addAll(response.body().getMoviesList());

                        }
                    }
                    @Override
                    public void onFailure(Call<DiscoverMovies> call, Throwable t) {
                        Log.d("REQUEST FAILED: ", "NO RESPONSE");
                    }
                });
        return movies;
    }
}
