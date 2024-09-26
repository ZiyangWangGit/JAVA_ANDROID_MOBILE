package com.example.a1_ziyang_wang;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegistrationFinal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registration_final);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Intent previousIntent = getIntent();
        String email = previousIntent.getStringExtra("Email");
        String name = previousIntent.getStringExtra("Name");
        String birthday = previousIntent.getStringExtra("Birthday");
        String gender = previousIntent.getStringExtra("Gender");
        String selfIntroduction = previousIntent.getStringExtra("SelfIntroduction");
        String preference = previousIntent.getStringExtra("Preference");

        TextView nameTextView = findViewById(R.id.nameTextView);
        TextView emailTextView = findViewById(R.id.emailTextView);
        TextView birthdayTextView = findViewById(R.id.birthdayTextView);
        TextView genderTextView = findViewById(R.id.genderTextView);
        TextView selfIntrouctionTextView = findViewById(R.id.selfIntroductionTextView);
        TextView preferenceTextView = findViewById(R.id.preferenceTextView);

        nameTextView.setText(name);
        emailTextView.setText(email);
        birthdayTextView.setText(birthday);
        genderTextView.setText(gender);
        selfIntrouctionTextView.setText(selfIntroduction);
        preferenceTextView.setText(preference);


    }
}