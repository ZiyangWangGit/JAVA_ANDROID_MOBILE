package com.example.a1_ziyang_wang;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegistrationFormTwo extends AppCompatActivity {
    private EditText selfIntroductionInput; // For Birthday
    private EditText preferenceInput; // For Gender

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registration_form_two);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        selfIntroductionInput = findViewById(R.id.self_introductionEditText);
        preferenceInput = findViewById(R.id.preferenceEditText);
    }

    public void sendRegistration(View view) {
        Intent intent = new Intent(this, RegistrationFinal.class);

        Intent previousIntent = getIntent();
        String name = previousIntent.getStringExtra("Name");
        String email = previousIntent.getStringExtra("Email");
        String password = previousIntent.getStringExtra("Password");
        String birthday = previousIntent.getStringExtra("Birthday");
        String gender = previousIntent.getStringExtra("Gender");

        String preference = selfIntroductionInput.getText().toString();
        String selfIntroduction = preferenceInput.getText().toString();

        // Pass the data to RegistrationFinal
        intent.putExtra("Name", name);
        intent.putExtra("Email", email);
        intent.putExtra("Password", password);
        intent.putExtra("Birthday", birthday);
        intent.putExtra("Gender", gender);
        intent.putExtra("Preference", preference);
        intent.putExtra("SelfIntroduction", selfIntroduction);

        startActivity(intent);
    }

}