package com.example.a3_ziyang_wang;

import java.io.Serializable;
public class Movie implements Serializable{
    private final String title;
    private final int year;
    private final String imdbID;
    private final String type;
    private final String posterUrl;

    // Constructor
    public Movie(String title, int year, String imdbID, String type, String posterUrl) {
        this.title = title;
        this.year = year;
        this.imdbID = imdbID;
        this.type = type;
        this.posterUrl = posterUrl;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String getImdbID() {
        return imdbID;
    }

    public String getType() {
        return type;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

}
