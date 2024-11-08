package com.example.a3_ziyang_wang;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddMovie extends AppCompatActivity {

    private EditText editTextTitle, editTextYear, editTextImdbID, editTextType, editTextPosterUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_movie);

        // Initialize views
        editTextTitle = findViewById(R.id.editTextTitle);
        editTextYear = findViewById(R.id.editTextYear);
        editTextImdbID = findViewById(R.id.editTextImdbID);
        editTextType = findViewById(R.id.editTextType);
        editTextPosterUrl = findViewById(R.id.editTextPosterUrl);
        Button buttonAddMovie = findViewById(R.id.buttonAddMovie);
        Button buttonCancel = findViewById(R.id.buttonCancel);

        // Set onClick listener for the "Add Movie" button
        buttonAddMovie.setOnClickListener(v -> addMovie());

        // Set onClick listener for the "Cancel" button
        buttonCancel.setOnClickListener(v -> cancel());
    }

    private void addMovie() {
        String title = editTextTitle.getText().toString().trim();
        String yearStr = editTextYear.getText().toString().trim();
        String imdbID = editTextImdbID.getText().toString().trim();
        String type = editTextType.getText().toString().trim();
        String posterUrl = editTextPosterUrl.getText().toString().trim();

        // Check for empty fields
        if (TextUtils.isEmpty(title) || TextUtils.isEmpty(yearStr) || TextUtils.isEmpty(imdbID) ||
                TextUtils.isEmpty(type) || TextUtils.isEmpty(posterUrl)) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        // Parse the year
        int year;
        try {
            year = Integer.parseInt(yearStr);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Invalid year", Toast.LENGTH_SHORT).show();
            return;
        }

        // Create a new Movie object
        Movie newMovie = new Movie(title, year, imdbID, type, posterUrl);

        // Pass the new movie back to MainActivity
        Intent resultIntent = new Intent();
        resultIntent.putExtra("newMovie", newMovie);
        setResult(RESULT_OK, resultIntent);
        finish();
    }

    private void cancel() {
        setResult(RESULT_CANCELED);
        finish();
    }
}
