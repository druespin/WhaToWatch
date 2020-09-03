package com.example.multiapptest;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.multiapptest.adapter.MoviesListAdapter;
import com.example.multiapptest.data.DiscoverResponse;
import com.example.multiapptest.data.MovieItem;
import com.example.multiapptest.network.TmdbService;
import com.example.multiapptest.util.AsyncHelper;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SearchResultsActivity extends Activity {

    private MoviesListAdapter adapter;
    RecyclerView recyclerView;
    private List<MovieItem> movies;
    private AsyncHelper helper;
    private TmdbService tmdb;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);

        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

//        helper = new AsyncHelper();
//        movies = helper.getDiscoverMovies();
        movies = new ArrayList<>();
        adapter = new MoviesListAdapter(movies);
        recyclerView.setAdapter(adapter);
        getDiscoverMovies();
    }

    void getDiscoverMovies()  {
        tmdb = TmdbService.getTmdbInstance();
        tmdb.getRequest()
                .discoverMovies()
                .enqueue(new Callback<DiscoverResponse>() {
                    @Override
                    public void onResponse(Call<DiscoverResponse> call,
                                           Response<DiscoverResponse> response) {
                        if (response.isSuccessful()) {
                            movies.addAll(response.body().getMoviesList());
                            adapter.notifyDataSetChanged();
                        }
                    }
                    @Override
                    public void onFailure(Call<DiscoverResponse> call, Throwable t) {
                        Log.d("REQUEST FAILED: ", "NO RESPONSE");
                    }
                });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
