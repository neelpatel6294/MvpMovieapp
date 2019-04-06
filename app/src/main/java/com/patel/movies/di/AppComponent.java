package com.patel.movies.di;


import com.patel.movies.App;
import com.patel.movies.ui.activity.DetailedActivity;
import com.patel.movies.ui.activity.MainActivity;
import com.patel.movies.ui.fragment.DetailedFragment;
import com.patel.movies.ui.fragment.MainFragment;
import com.patel.movies.ui.view.ReviewRowView;
import com.patel.movies.ui.view.TrailerRowView;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    //Application-level
    void inject(App application);

    //Activities
    void inject(MainActivity activity);

    void inject(DetailedActivity activity);

    //Fragments
    void inject(MainFragment fragment);

    void inject(DetailedFragment fragment);

    //view
    void inject(TrailerRowView view);

    void inject(ReviewRowView view);
}
