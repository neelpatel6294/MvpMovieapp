package com.patel.movies.common;

import android.content.Context;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;

import com.patel.movies.App;
import com.patel.movies.R;
import com.jakewharton.rxbinding.internal.Preconditions;

import javax.inject.Singleton;

@Singleton
public class Utils {

    public static final String BASE_IMAGE_URL = "http://image.tmdb.org/t/p/w";

    public static final Integer IMAGE_SIZE = 185;

    public static String getImageUrl(String imgPath) {
        Preconditions.checkArgument(!TextUtils.isEmpty(imgPath), "img path is empty");
        StringBuilder uriString = new StringBuilder(BASE_IMAGE_URL);
        uriString.append(IMAGE_SIZE);
        uriString.append(imgPath);
        return uriString.toString();
    }

    public static boolean isLandscape() {
        return App.getInstance().getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
    }

    public static boolean isTablet() {
        return App.getInstance().getResources().getBoolean(R.bool.isTablet);
    }

    public static boolean isConnectedToInternet() {
            ConnectivityManager connectivityManager
                    = (ConnectivityManager) App.getInstance().getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
