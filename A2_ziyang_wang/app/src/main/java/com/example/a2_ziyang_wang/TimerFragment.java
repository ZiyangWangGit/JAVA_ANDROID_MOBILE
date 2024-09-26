package com.example.a2_ziyang_wang;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TimerFragment extends Fragment {

    private String recipeName; // Declare as member variable
    private String cookTime;   // Declare as member variable

    private TextView recipeNameTextView; // Declare as member variable
    private TextView cookTimeTextView;   // Declare as member variable

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Retrieve the arguments (recipe name and cook time) passed from the previous fragment
        if (getArguments() != null) {
            recipeName = getArguments().getString("recipeName");
            cookTime = getArguments().getString("cookTime");
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_timer, container, false);
        recipeNameTextView = view.findViewById(R.id.recipeNameTextView);
        cookTimeTextView = view.findViewById(R.id.cookTimeTextView);
        updateUI(); // Call to update UI with initial values
        return view;
    }

    public void updateTimerDetails(String recipeName, String cookTime) {
        this.recipeName = recipeName;
        this.cookTime = cookTime;
        updateUI(); // Update the UI whenever the data is changed
    }

    private void updateUI() {
        recipeNameTextView.setText(recipeName);
        cookTimeTextView.setText(cookTime);
    }
}