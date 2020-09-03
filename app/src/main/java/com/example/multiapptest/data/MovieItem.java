package com.example.multiapptest.data;


import com.google.gson.annotations.SerializedName;

public class MovieItem {

    int id;
    @SerializedName("original_title")
    String originalTitle;

    @SerializedName("poster_path")
    String posterPath;

    @SerializedName("vote_average")
    double voteAverage;

    public int getId() {
        return id;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public double getVoteAverage() {
        return voteAverage;
    }
}
