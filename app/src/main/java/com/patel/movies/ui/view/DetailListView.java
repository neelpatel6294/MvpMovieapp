package com.patel.movies.ui.view;

import com.patel.movies.api.models.review.Review;
import com.patel.movies.api.models.trailer.Trailer;

import java.util.List;

public interface DetailListView extends DevilListView {

    void showLoading();

    void hideLoading();

    void setTrailers(List<Trailer> trailers);

    void setReviews(List<Review> reviews);

    void removeTrailer(Trailer movie);

    void removeReview(Review movie);
}
