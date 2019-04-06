package com.patel.movies.ui.presenter;

import com.patel.movies.ui.view.DevilListView;

public interface Presenter<T extends DevilListView> {

    void initialize();

    void onViewCreate();

    void onViewResume();

    void onViewDestroy();

    void setView(T view);

    void onResume();

    void onItemClicked(int position);

    void onDestroy();
}