package com.example.multiapptest.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

class DiscoverTV {

    private int page;

    @SerializedName("total_results")
    private int totalResults;

    @SerializedName("total_pages")
    private int totalPages;

    @SerializedName("results")
    private List<TvItem> tvList;


    public int getPage() {
        return page;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public List<TvItem> getTvList() {
        return tvList;
    }
}
