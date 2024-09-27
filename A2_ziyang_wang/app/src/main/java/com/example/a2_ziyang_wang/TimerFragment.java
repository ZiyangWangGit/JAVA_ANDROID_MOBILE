package com.example.a2_ziyang_wang;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.widget.Button;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TimerFragment extends Fragment {

    private TextView timerText;

    private String recipeName;
    private String cookTime;
    private int cookMinutes;      // integer to store cook time in minutes

    private TextView recipeNameTextView;
    private TextView cookTimeTextView;

    private CountDownTimer countDownTimer;
    private boolean timerStarted = false;
    private long timeInMillis;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Retrieve the arguments (recipe name and cook time) passed from the previous fragment
        if (getArguments() != null) {
            recipeName = getArguments().getString("recipeName");
            cookTime = getArguments().getString("cookTime");
            cookMinutes = extractMinutes(cookTime); // Extract minutes from cookTime
            timeInMillis = (long) cookMinutes * 60 * 1000; // Convert minutes to milliseconds
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_timer, container, false);
        recipeNameTextView = view.findViewById(R.id.recipeNameTextView);
        cookTimeTextView = view.findViewById(R.id.cookTimeTextView);
        timerText = view.findViewById(R.id.timerTextView);
        SeekBar seekBar = view.findViewById(R.id.timeSeekBar);
        cookMinutes = seekBar.getProgress();
        timeInMillis = (long) cookMinutes * 60 * 1000;


        timerText.setText(getFormattedTime(timeInMillis));
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                cookMinutes = progress; // Update cookMinutes based on SeekBar progress
                timeInMillis = (long) cookMinutes * 60 * 1000; // Update time in milliseconds
                timerText.setText(getFormattedTime(timeInMillis)); // Update the timer display
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Optional: Code when dragging starts
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Optional: Code when dragging stops
            }
        });


        Button startButton = view.findViewById(R.id.startButton);
        startButton.setOnClickListener(this::startTimer);

        Button pauseButton = view.findViewById(R.id.pauseButton);
        pauseButton.setOnClickListener(this::pauseTimer);

        Button resetButton = view.findViewById(R.id.resetButton);
        resetButton.setOnClickListener(this::resetTimer);
        updateUI(); // Call to update UI with initial values
        return view;
    }

    public void updateTimerDetails(String recipeName, String cookTime) {
        this.recipeName = recipeName;
        this.cookTime = cookTime;
        cookMinutes = extractMinutes(cookTime);
        timeInMillis = (long) cookMinutes * 60 * 1000; // Reset time to the new cook time in milliseconds
        updateUI();
    }

    private void updateUI() {
        recipeNameTextView.setText(recipeName);
        cookTimeTextView.setText(cookTime);
        timerText.setText(getFormattedTime(timeInMillis)); // Update to formatted time
    }


    public int extractMinutes(String cookTime) {
        // Define a regex pattern to find the numeric part
        String regex = "\\d+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(cookTime);

        // If a match is found, parse it to an integer
        if (matcher.find()) {
            return Integer.parseInt(matcher.group());
        }
        return 0;
    }

    @SuppressLint("DefaultLocale")
    private String getFormattedTime(long millis) {
        // Convert milliseconds to minutes and seconds
        int minutes = (int) (millis / 1000) / 60;
        int seconds = (int) (millis / 1000) % 60;
        return String.format("%02d:%02d", minutes, seconds); // Format as MM:SS
    }

    public void startTimer(View view) {
        if (!timerStarted) {
            countDownTimer = new CountDownTimer(timeInMillis, 1000) { // Timer counts down every second
                @Override
                public void onTick(long millisUntilFinished) {
                    timeInMillis = millisUntilFinished; // Update time in milliseconds
                    timerText.setText(getFormattedTime(timeInMillis)); // Update the timer display
                }

                @SuppressLint("SetTextI18n")
                @Override
                public void onFinish() {
                    timerStarted = false;
                    timerText.setText("00:00"); // Reset to 00:00 when finished
                }
            }.start();
            timerStarted = true;
        }
    }

    public void pauseTimer(View view) {
        if (timerStarted) {
            countDownTimer.cancel();
            timerStarted = false;
        }
    }

    public void resetTimer(View view) {
        if (timerStarted) {
            countDownTimer.cancel();
            timerStarted = false;
        }
        timeInMillis = (long) cookMinutes * 60 * 1000; // Reset to initial cook time in milliseconds
        timerText.setText(getFormattedTime(timeInMillis)); // Update the UI to reflect reset
    }
}
