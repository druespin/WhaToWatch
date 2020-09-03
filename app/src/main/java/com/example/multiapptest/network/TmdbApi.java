package com.example.multiapptest.network;

import com.example.multiapptest.data.DiscoverResponse;
import com.example.multiapptest.data.MovieItem;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface TmdbApi {

    String API_KEY = "1ef053623376c52e57fa08a511ca3e2d";

    @GET("discover/movie?api_key=" + API_KEY)
    Call<DiscoverResponse> discoverMovies();
            //@Query("page") int page);

    @GET("movie/{movie_id}")
    Call<MovieItem> getMovieById(@Path("movie_id") int movie_id);
}
