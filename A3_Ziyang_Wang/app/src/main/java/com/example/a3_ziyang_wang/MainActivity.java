package com.example.a3_ziyang_wang;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private static final int ADD_MOVIE_REQUEST = 1;

    private final ArrayList<Movie> movies = new ArrayList<>(Arrays.asList(
            new Movie("The Shawshank Redemption", 1994, "tt0111161", "Drama", "https://m.media-amazon.com/images/I/51zXApiWzgL._AC_UF894,1000_QL80_.jpg"),
            new Movie("The Godfather", 1972, "tt0068646", "Drama", "https://m.media-amazon.com/images/I/61MwEEt+NXL._AC_UF894,1000_QL80_.jpg"),
            new Movie("The Dark Knight", 2008, "tt0468569", "Drama", "https://m.media-amazon.com/images/I/51rF2-tvXVL.jpg")
    ));

    RecyclerView recyclerView;
    RecyclerAdapter adapter = new RecyclerAdapter(movies);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        recyclerView = findViewById(R.id.recycler_view);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ItemTouchHelper itemTouchHelper = getItemTouchHelper();
        itemTouchHelper.attachToRecyclerView(recyclerView);

        FloatingActionButton fab = findViewById(R.id.add_fab);
        fab.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddMovie.class);
            startActivityForResult(intent, ADD_MOVIE_REQUEST);
        });
    }

    private @NonNull ItemTouchHelper getItemTouchHelper() {
        ItemTouchHelper.SimpleCallback itemTouchHelperCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override

            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false; // No movement
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getBindingAdapterPosition();
                movies.remove(position); // Remove the movie from the list
                adapter.notifyItemRemoved(position); // Notify the adapter to remove the item from the view
            }
        };

        return new ItemTouchHelper(itemTouchHelperCallback);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ADD_MOVIE_REQUEST && resultCode == RESULT_OK) {
            // Get the new movie from the result
            Movie newMovie = (Movie) data.getSerializableExtra("newMovie");

            // Add the new movie to the list first
            movies.add(newMovie);
            adapter.notifyItemInserted(movies.size() - 1);
            recyclerView.scrollToPosition(movies.size() - 1);
        }
    }

}