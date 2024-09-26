package com.example.a2_ziyang_wang;

import android.os.Bundle;
import android.view.MenuItem;


import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavView;
    HomeFragment homeFragment = new HomeFragment();
    FeedbackFragment feedbackFragment = new FeedbackFragment();
    RecipeFragment recipeFragment = new RecipeFragment();
    TimerFragment timerFragment = new TimerFragment();

    public TimerFragment getTimerFragment() {
        return timerFragment; // Return the existing TimerFragment
    }

    public void showTimerFragment() {
        getSupportFragmentManager().beginTransaction()
                .hide(homeFragment)
                .hide(feedbackFragment)
                .hide(recipeFragment)
                .show(timerFragment)
                .commit();
    }


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
        bottomNavView = findViewById(R.id.bottomNavigationView);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container,homeFragment)
                .add(R.id.container,feedbackFragment)
                .add(R.id.container,timerFragment)
                .add(R.id.container,recipeFragment)
                .hide(feedbackFragment)
                .hide(recipeFragment)
                .hide(timerFragment)
                .commit();
        bottomNavView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if(id == R.id.home) {
                    getSupportFragmentManager().beginTransaction().hide(feedbackFragment).hide(timerFragment).
                    hide(recipeFragment).show(homeFragment).commit();
                    return true;
                }else if (id == R.id.feedback){
                    getSupportFragmentManager().beginTransaction().hide(homeFragment).hide(timerFragment).
                            hide(recipeFragment).show(feedbackFragment).
                            commit();
                    return true;
                }else if(id == R.id.timer){
                    getSupportFragmentManager().beginTransaction().hide(homeFragment).hide(feedbackFragment).
                            hide(recipeFragment).show(timerFragment).
                            commit();
                    return true;
                }else if(id == R.id.recipe) {
                    getSupportFragmentManager().beginTransaction().hide(homeFragment).hide(feedbackFragment).
                            hide(timerFragment).show(recipeFragment).
                            commit();
                    return true;
                }
                return false;
            }
        });


    }
}