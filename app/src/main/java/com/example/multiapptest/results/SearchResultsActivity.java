package com.example.multiapptest.results;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.multiapptest.R;
import com.example.multiapptest.adapter.MoviesListAdapter;
import com.example.multiapptest.adapter.PersonListAdapter;
import com.example.multiapptest.data.MovieItem;
import com.example.multiapptest.data.Person;
import com.example.multiapptest.presenter.MoviePresenter;

import java.util.List;

public class SearchResultsActivity  extends Activity implements ResultsView {

    private MoviesListAdapter moviesAdapter;
    private PersonListAdapter personsAdapter;
    private MoviePresenter presenter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);

        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        presenter = new MoviePresenter(this);

        String searchQuery = getIntent().getStringExtra("query");
        if (searchQuery != null && !"".equals(searchQuery)) {
            presenter.searchPeopleByQuery(searchQuery);
        }
        else {
            presenter.getDiscoverMovies();
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void showDiscoverMovies(List<MovieItem> movies) {
        moviesAdapter = new MoviesListAdapter(movies);
        recyclerView.setAdapter(moviesAdapter);
    }

    @Override
    public void showPeopleResults(List<Person> persons) {
        personsAdapter = new PersonListAdapter(persons);
        recyclerView.setAdapter(personsAdapter);
    }

    @Override
    public void showEmptyList() {

    }
}
