package com.patel.movies.ui.presenter;

import android.util.Log;

import com.patel.movies.api.RetrofitAdapter;
import com.patel.movies.api.models.review.Review;
import com.patel.movies.api.models.review.Reviews;
import com.patel.movies.api.models.trailer.Trailer;
import com.patel.movies.api.models.trailer.Trailers;
import com.patel.movies.ui.view.DetailListView;

import java.util.ArrayList;
import java.util.List;

import rx.Observer;

public class DetailedPresenterImp implements Presenter<DetailListView> {

    private DetailListView mDetailListView;

    private List<Review> mReviews;

    private List<Trailer> mTrailers;

    private String mId;

    public DetailedPresenterImp(DetailListView detailListView, String id) {
        mDetailListView = detailListView;
        mId = id;
    }

    @Override
    public void initialize() {
        mReviews = new ArrayList<>();
        mTrailers = new ArrayList<>();
    }

    @Override
    public void onViewCreate() {

    }

    @Override
    public void onViewResume() {

    }

    @Override
    public void onViewDestroy() {

    }

    @Override
    public void setView(DetailListView view) {

    }

    @Override
    public void onResume() {
        fetchReviews(mId);
        fetchTrailers(mId);
    }

    @Override
    public void onItemClicked(int position) {

    }

    @Override
    public void onDestroy() {

    }

    public void fetchReviews(String id) {
        mDetailListView.showLoading();
        RetrofitAdapter.getInstance().getReviews(id)
                .subscribe(new Observer<Reviews>() {
                    @Override
                    public void onCompleted() {
                        mDetailListView.hideLoading();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("TAG", "error " + e.getMessage());
                    }

                    @Override
                    public void onNext(Reviews reviews) {
                        mReviews = reviews.getResults();
                        mDetailListView.setReviews(mReviews);
                    }
                });
    }

    public void fetchTrailers(String id) {
        mDetailListView.showLoading();
        RetrofitAdapter.getInstance().getTrailers(id)
                .subscribe(new Observer<Trailers>() {
                    @Override
                    public void onCompleted() {
                        mDetailListView.hideLoading();
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(Trailers trailers) {
                        mTrailers = trailers.getResults();
                        mDetailListView.setTrailers(mTrailers);
                    }
                });
    }
}
