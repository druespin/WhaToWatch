package com.example.multiapptest.presenter;

import com.example.multiapptest.data.MovieItem;

import java.util.List;

public interface Presenter {

    void getDiscoverMovies();
    void searchMovieByQuery(String query);
    void searchPeopleByQuery(String query);
    void onClickAction();
    void onStop();
}
