package com.patel.movies;

import android.app.Application;

import com.patel.movies.di.AppComponent;
import com.patel.movies.di.AppModule;
import com.patel.movies.di.DaggerAppComponent;
import com.facebook.stetho.Stetho;

public class App extends Application {

    public static final String TAG = App.class.getSimpleName();

    private static App sInstance;

    /**
     * Dagger component for the application
     */
    private AppComponent appComponent;

    public App() {
        sInstance = this;
    }

    public static App getInstance() {
        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        Stetho.initializeWithDefaults(this);
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
        appComponent.inject(this);
    }

    public AppComponent getDaggerComponent() {
        return appComponent;
    }
}
