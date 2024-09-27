package com.example.a2_ziyang_wang;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class FeedbackFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_feedback, container, false);

        Button submitButton = view.findViewById(R.id.submitButton);
        submitButton.setOnClickListener(this::submitFeedback);

        return view;
    }

    public void submitFeedback(View view) {
        Toast.makeText(getActivity(), "Feedback submitted successfully!", Toast.LENGTH_SHORT).show();
    }
}