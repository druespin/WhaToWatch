package com.example.multiapptest.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PersonResults {

    private int page;

    @SerializedName("total_results")
    private int totalResults;

    @SerializedName("total_pages")
    private int totalPages;

    @SerializedName("results")
    private List<Person> personList;


    public int getPage() {
        return page;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public List<Person> getPersonList() {
        return personList;
    }
}
