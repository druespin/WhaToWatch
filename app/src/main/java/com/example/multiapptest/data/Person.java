package com.example.multiapptest.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Person {

    private int id;
    private String name;
    private int popularity;

    private int gender;
    @SerializedName("profile_path")
    private String photo;

    @SerializedName("known_for_department")
    private String profession;

    @SerializedName("known_for")
    private List<MovieItem> moviesList;

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getPopularity() {
        return popularity;
    }

    public int getGender() {
        return gender;
    }

    public String getPhoto() {
        return photo;
    }

    public String getProfession() {
        return profession;
    }

    public List<MovieItem> getMoviesList() {
        return moviesList;
    }
}
