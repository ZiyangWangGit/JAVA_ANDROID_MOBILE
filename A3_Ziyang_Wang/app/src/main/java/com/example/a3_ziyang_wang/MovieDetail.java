package com.example.a3_ziyang_wang;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.squareup.picasso.Picasso;

public class MovieDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        // Get the movie object from the intent
        Movie movie = (Movie) getIntent().getSerializableExtra("movieDetails");

        // Check if the movie object is null
        if (movie != null) {
            TextView titleTextView = findViewById(R.id.titleTextView);
            TextView yearTextView = findViewById(R.id.yearTextView);
            TextView idTextView = findViewById(R.id.imdbIDTextView);
            TextView typeTextView = findViewById(R.id.typeTextView);
            ImageView posterImageView = findViewById(R.id.posterImageView);

            titleTextView.setText(getString(R.string.movie_name_display, movie.getTitle()));
            yearTextView.setText(getString(R.string.movie_year_display, movie.getYear()));
            typeTextView.setText(getString(R.string.movie_type_display, movie.getType()));
            idTextView.setText(getString(R.string.imdb_id_display, movie.getImdbID()));

            // Use Picasso to load the poster image
            Picasso.get().load(movie.getPosterUrl()).into(posterImageView);
        } else {
            // Handle the case where movie is null
            Toast.makeText(this, "No movie details found!", Toast.LENGTH_SHORT).show();
        }

        Button backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(v -> cancel());
    }

    private void cancel() {
        setResult(RESULT_CANCELED);
        finish();
    }
}
