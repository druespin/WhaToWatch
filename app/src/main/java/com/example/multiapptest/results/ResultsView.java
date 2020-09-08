package com.example.multiapptest.results;

import com.example.multiapptest.data.MovieItem;
import com.example.multiapptest.data.Person;
import com.example.multiapptest.data.PersonResults;

import java.util.List;

public interface ResultsView  {

    void showDiscoverMovies(List<MovieItem> movies);
    void showPeopleResults(List<Person> persons);
    void showEmptyList();
}
