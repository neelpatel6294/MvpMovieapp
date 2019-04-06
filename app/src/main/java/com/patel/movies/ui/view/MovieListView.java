package com.patel.movies.ui.view;

import com.patel.movies.api.models.movie.Movie;

import java.util.List;

public interface MovieListView extends DevilListView{

    void showLoading();

    void hideLoading();

    void setItems(List<Movie> movies);

    void remove(Movie movie);
}
