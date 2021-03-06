package com.example.multiapptest.data;


import com.google.gson.annotations.SerializedName;

public class MovieItem {

    int id;
    double popularity;
    String title;
    String overview;

    @SerializedName("release_date")
    String releaseDate;

    @SerializedName("original_language")
    String originalLanguage;

    @SerializedName("original_title")
    String originalTitle;

    @SerializedName("poster_path")
    String posterPath;

    @SerializedName("vote_average")
    double voteAverage;


    public int getId() {
        return id;
    }

    public String getTitle() { return title; }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public double getPopularity() {
        return popularity;
    }

    public String getOverview() {
        return overview;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }
}
