package com.patel.movies.di;

import android.app.Application;
import android.content.Context;

import dagger.Module;
import dagger.Provides;


@Module
public class AppModule {

    private final Context appContext;

    public AppModule(Application application) {
        this.appContext = application.getApplicationContext();
    }

    @Provides
    public Context provideApplicationContext() {
        return appContext;
    }
}
