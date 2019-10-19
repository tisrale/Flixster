package com.example.flixster.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    String posterpath;
    String title;
    String overview;
    String backdropPath;

    public Movie(JSONObject jsonObject) throws JSONException {
        backdropPath = jsonObject.getString("backdrop_path");
        posterpath = jsonObject.getString("poster_path");
        title = jsonObject.getString("title");
        overview = jsonObject.getString("overview");
    }

    public static List<Movie> fromJSONArray(JSONArray movieJSONArray)throws JSONException{
        List<Movie> movies = new ArrayList<>();
        for (int i = 0; i<movieJSONArray.length(); i++){
            movies.add(new Movie(movieJSONArray.getJSONObject(i)));

        }
        return movies;

    }


    public String getPosterpath() {

        return String.format("https://image.tmdb.org/t/p/w342/%s", posterpath);
    }

    public void setPosterpath(String posterpath) {
        this.posterpath = posterpath;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }
    public String getBackdroppath(){
        return String.format("https://image.tmdb.org/t/p/w342/%s",backdropPath);
    }
}
