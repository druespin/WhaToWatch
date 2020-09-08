package com.example.multiapptest.data;

import com.google.gson.annotations.SerializedName;

class TvItem {

    int id;
    double popularity;
    String name;
    String overview;

    @SerializedName("release_date")
    String releaseDate;

    @SerializedName("original_language")
    String originalLanguage;

    @SerializedName("original_name")
    String originalName;

    @SerializedName("poster_path")
    String posterPath;

    @SerializedName("vote_average")
    double voteAverage;


    public int getId() {
        return id;
    }

    public String getTitle() { return name; }

    public String getOriginalTitle() {
        return originalName;
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
