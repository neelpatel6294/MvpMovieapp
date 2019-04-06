package com.patel.movies.ui;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.patel.movies.App;
import com.patel.movies.R;
import com.patel.movies.api.models.movie.Movie;
import com.patel.movies.common.Utils;
import com.patel.movies.ui.activity.DetailedActivity;
import com.patel.movies.ui.activity.MainActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

public class StaggeredViewAdapter extends RecyclerView.Adapter<StaggeredView> {

    private List<Movie> mMovies;

    private static Context sContext = App.getInstance().getApplicationContext();

    private int lastPosition = -1;

    public StaggeredViewAdapter() {
        this.mMovies = null;
    }

    @Override
    public StaggeredView onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.grid_item, parent, false);
        StaggeredView staggeredView = new StaggeredView(layoutView);
        return staggeredView;
    }

    @Override
    public void onBindViewHolder(StaggeredView holder, final int position) {
        Picasso.with(sContext)
                .load(Utils.getImageUrl(mMovies.get(position).getPosterPath()))
                .into(holder.mMovieThumbnail);

        holder.mMovieTitle.setText(mMovies.get(position).getTitle());

        holder.mGridItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("tag", "movieId: " + mMovies.get(position).getId());
                if (!Utils.isLandscape()) {
                    v.getContext().startActivity(
                            DetailedActivity.newIntent(sContext, mMovies.get(position)));
                } else {
                    //landscape
                    if (!Utils.isTablet()) {
                        //phone
                        v.getContext().startActivity(
                                DetailedActivity.newIntent(sContext, mMovies.get(position)));
                    } else {
                        v.getContext().startActivity(
                                MainActivity.newIntentForDetailedFragment(sContext, mMovies.get(position)));
                    }
                }
            }
        });

        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition) {
            ViewCompat.animate(holder.itemView).rotation(2);
        }
    }

    @Override
    public int getItemCount() {
        return mMovies == null ? 0 : mMovies.size();
    }

    public void addMovies(List<Movie> movies) {
        if (movies != null) {
            mMovies = movies;
            notifyDataSetChanged();
        }
    }
}
