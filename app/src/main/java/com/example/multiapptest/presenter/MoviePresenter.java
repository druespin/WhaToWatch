package com.example.multiapptest.presenter;

import android.util.Log;

import com.example.multiapptest.data.DiscoverMovies;
import com.example.multiapptest.data.MovieItem;
import com.example.multiapptest.data.Person;
import com.example.multiapptest.data.PersonResults;
import com.example.multiapptest.network.TmdbApi;
import com.example.multiapptest.network.TmdbService;
import com.example.multiapptest.results.ResultsView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MoviePresenter implements Presenter {

    private ResultsView rv;
    private TmdbService tmdb;

    public MoviePresenter(ResultsView rv) {
        this.rv = rv;
        tmdb = TmdbService.getTmdbInstance();
    }

    @Override
    public void getDiscoverMovies() {
        final List<MovieItem> movies = new ArrayList<>();

        tmdb.getRequest()
                .discoverMovies(TmdbApi.API_KEY)
                .enqueue(new Callback<DiscoverMovies>() {
                    @Override
                    public void onResponse(Call<DiscoverMovies> call,
                                           Response<DiscoverMovies> response) {
                        if (response.isSuccessful() & response.body() != null) {
                            movies.addAll(response.body().getMoviesList());
                            rv.showDiscoverMovies(movies);
                        }
                    }
                    @Override
                    public void onFailure(Call<DiscoverMovies> call, Throwable t) {
                        Log.d("REQUEST FAILED", "NO RESPONSE");
                    }
                });
    }

    @Override
    public void searchMovieByQuery(String query) {
        final List<MovieItem> movies = new ArrayList<>();

        tmdb.getRequest()
                .searchMovie(query, 1, TmdbApi.API_KEY)
                .enqueue(new Callback<DiscoverMovies>() {
                    @Override
                    public void onResponse(Call<DiscoverMovies> call,
                                           Response<DiscoverMovies> response) {
                        if (response.isSuccessful() & response.body() != null) {
                            movies.addAll(response.body().getMoviesList());
                            rv.showDiscoverMovies(movies);
                        }
                    }
                    @Override
                    public void onFailure(Call<DiscoverMovies> call, Throwable t) {
                        Log.d("REQUEST FAILED", "NO RESPONSE");
                    }
                });
    }

    @Override
    public void searchPeopleByQuery(String query) {
        final List<Person> persons = new ArrayList<>();

        tmdb.getRequest()
                .searchPeople(query, 1, TmdbApi.API_KEY)
                .enqueue(new Callback<PersonResults>() {
                    @Override
                    public void onResponse(Call<PersonResults> call,
                                           Response<PersonResults> response) {
                        if (response.isSuccessful() & response.body() != null) {
                            persons.addAll(response.body().getPersonList());
                            rv.showPeopleResults(persons);
                        }
                    }
                    @Override
                    public void onFailure(Call<PersonResults> call, Throwable t) {
                        Log.d("REQUEST FAILED: ", "NO RESPONSE");
                    }
                });
    }

    @Override
    public void onClickAction() {

    }

    @Override
    public void onStop() {

    }
}
