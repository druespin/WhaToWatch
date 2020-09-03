package com.example.multiapptest.util;

import android.util.Log;

import com.example.multiapptest.data.DiscoverResponse;
import com.example.multiapptest.data.MovieItem;
import com.example.multiapptest.network.TmdbService;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AsyncHelper {

    private TmdbService tmdb;
    private List<MovieItem> movies;

    public AsyncHelper() {
        tmdb = TmdbService.getTmdbInstance();
        movies = new ArrayList<>();
    }

    public void getDiscoverMovies()  {

        tmdb.getRequest()
                .discoverMovies()
                .enqueue(new Callback<DiscoverResponse>() {
                    @Override
                    public void onResponse(Call<DiscoverResponse> call,
                                           Response<DiscoverResponse> response) {
                        if (response.isSuccessful()) {
                            movies.addAll(response.body().getMoviesList());
                        }
                    }

                    @Override
                    public void onFailure(Call<DiscoverResponse> call, Throwable t) {
                        Log.d("REQUEST FAILED: ", "NO RESPONSE");
                    }
                });
    }

    public void getMovieById() {

        tmdb.getRequest()
                .getMovieById(11)
                .enqueue(new Callback<MovieItem>() {
                    @Override
                    public void onResponse(Call<MovieItem> call, Response<MovieItem> response) {
                        //movies.add(response.body());
                    }

                    @Override
                    public void onFailure(Call<MovieItem> call, Throwable t) {
                        Log.d("REQUEST FAILED: ", "NO MOVIE WITH THIS ID");
                    }
                });
    }

}