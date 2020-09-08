package com.example.multiapptest.network;

import com.example.multiapptest.data.DiscoverMovies;
import com.example.multiapptest.data.MovieItem;
import com.example.multiapptest.data.PersonResults;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface TmdbApi {

    String API_KEY = "1ef053623376c52e57fa08a511ca3e2d";

    @GET("discover/movie")
    Call<DiscoverMovies> discoverMovies(@Query("api_key") String apikey);

    @GET("discover/movie")
    Call<DiscoverMovies> discoverMovies(@Query("page") int page,
                                        @Query("api_key") String apikey);

    @GET("search/movie")
    Call<DiscoverMovies> searchMovie(@Query("query") String query,
                                     @Query("page") int page,
                                     @Query("api_key") String apikey);

    @GET("search/person")
    Call<PersonResults> searchPeople(@Query("query") String query,
                                     @Query("page") int page,
                                     @Query("api_key") String apikey);

    @GET("movie/{movie_id}")
    Call<MovieItem> getMovieById(@Path("movie_id") int movie_id);
}
