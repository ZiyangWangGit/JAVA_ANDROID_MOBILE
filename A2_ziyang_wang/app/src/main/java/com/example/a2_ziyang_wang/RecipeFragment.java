package com.example.a2_ziyang_wang;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class RecipeFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recipe, container, false);
        Button redCurryDetailButton = view.findViewById(R.id.redCurryDetail);
        redCurryDetailButton.setOnClickListener(this::redCurryClick);

        Button parmensanChickenDetailButton = view.findViewById(R.id.parmensanChickenDetail);
        parmensanChickenDetailButton.setOnClickListener(this::parmesanChickenClick);

        Button lentilSoupButton = view.findViewById(R.id.lentilSoupDetail);
        lentilSoupButton.setOnClickListener(this::lentilSoupClick);

        Button beefTacoButton = view.findViewById(R.id.beefTacoDetail);
        beefTacoButton.setOnClickListener(this::beefTacoClick);

        Button parmensanChickenTimerButton = view.findViewById(R.id.parmensanChickenTimer);
        parmensanChickenTimerButton.setOnClickListener(this::parmensanChickenTimerClick);

        Button lentilSoupTimerButton = view.findViewById(R.id.lentilSoupTimer);
        lentilSoupTimerButton.setOnClickListener(this::lentilSoupTimerClicker);

        Button beefTacoTimerButton = view.findViewById(R.id.beefTacoTimer);
        beefTacoTimerButton.setOnClickListener(this::beefTacoTimerClicker);

        Button redCurryTimerButton = view.findViewById(R.id.redCurryTimer);
        redCurryTimerButton.setOnClickListener(this::redCurryTimerClicker);
        return view;
    }

    private void navigateToTimerFragment(String recipeName, String cookTime) {
        // Get the existing TimerFragment from the MainActivity
        TimerFragment timerFragment = ((MainActivity) requireActivity()).getTimerFragment();

        if (timerFragment != null) {
            // Update the existing TimerFragment with new data
            timerFragment.updateTimerDetails(recipeName, cookTime);
        }

        ((MainActivity) requireActivity()).showTimerFragment();

    }



    private void parmensanChickenTimerClick(View view) {
        navigateToTimerFragment("Parmesan Chicken", "30 minutes");
    }

    private void lentilSoupTimerClicker(View view) {
        navigateToTimerFragment("Lentil Soup", "20 minutes");
    }

    private void beefTacoTimerClicker(View view) {
        navigateToTimerFragment("Beef Taco", "25 minutes");
    }

    private void redCurryTimerClicker(View view) {
        navigateToTimerFragment("Red Curry", "40 minutes");
    }


    public void redCurryClick(View view) {
        Intent intent = new Intent(requireActivity(), RedCurryDetails.class);
        startActivity(intent);
    }


    public void beefTacoClick(View view) {
        Intent intent = new Intent(requireActivity(),BeefTacoDetails.class);
        startActivity(intent);
    }

    public void lentilSoupClick(View view) {
        Intent intent = new Intent(requireActivity(),LentilSoupDetails.class);
        startActivity(intent);
    }

    public void parmesanChickenClick(View view) {
        Intent intent = new Intent(requireActivity(), ParmensanChickenDetails.class);
        startActivity(intent);
    }





}