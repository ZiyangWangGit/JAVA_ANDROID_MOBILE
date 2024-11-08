package com.example.a3_ziyang_wang;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import com.squareup.picasso.Picasso;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private final ArrayList<Movie> movies;

    public RecyclerAdapter(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView year;
        public ImageView poster;

        public ViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.title);
            year = view.findViewById(R.id.year);
            poster = view.findViewById(R.id.poster);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Movie currentMovie = movies.get(position);
        holder.title.setText(currentMovie.getTitle());
        holder.year.setText(String.valueOf(currentMovie.getYear()));
        Picasso.get().load(currentMovie.getPosterUrl()).into(holder.poster);

        holder.itemView.setOnClickListener(v -> {

            Context context = v.getContext();
            Intent intent = new Intent(context, MovieDetail.class);

            // Pass the selected movie object to the new activity (ensure Movie implements Serializable or Parcelable)
            intent.putExtra("movieDetails", currentMovie);

            // Start the MovieDetailActivity
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public void removeMovie(int position) {
        movies.remove(position);
        notifyItemRemoved(position);
    }

}