package com.patel.movies.ui.viewmodel;

import com.patel.movies.api.models.movie.Movie;


public class MovieViewModel extends DevilViewModel {

    private Movie mMovie;

    public MovieViewModel(Movie movie) {
        this.mMovie = movie;
    }

    @Override
    public String getId() {
        return mMovie.getId();
    }

    @Override
    public String getImageUrl() {
        return mMovie.getPosterPath();
    }

    @Override
    public String getTitle() {
        return mMovie.getTitle();
    }

    @Override
    public String getReleaseDate() {
        return mMovie.getReleaseDate();
    }

    @Override
    public double getVoteAverage() {
        return mMovie.getmVoteAverage();
    }

    @Override
    public String getOverview() {
        return mMovie.getOverview();
    }
}
