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

public class RegistrationFormOne extends AppCompatActivity {

    private EditText nameInput; //For Name
    private EditText emailInput; // For Email
    private EditText passwordInput; // For Password
    private EditText birthdayInput; // For Birthday
    private EditText genderInput; // For Gender


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registration_form_one);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        nameInput = findViewById(R.id.nameEditText);  //Name EditText
        emailInput = findViewById(R.id.emailEditText);  // Email EditText
        passwordInput = findViewById(R.id.passwordEditText);  // Password EditText
        birthdayInput = findViewById(R.id.birthdayEditText);  // Birthday EditText
        genderInput = findViewById(R.id.genderEditText);  // Birthday EditText
    }

    public void continueRegister(View view) {
        Intent intent = new Intent(this,RegistrationFormTwo.class);

        String name = nameInput.getText().toString();
        String email = emailInput.getText().toString();
        String password = passwordInput.getText().toString();
        String birthday = birthdayInput.getText().toString();
        String gender = genderInput.getText().toString();

        intent.putExtra("Name", name);
        intent.putExtra("Email", email);
        intent.putExtra("Password", password);
        intent.putExtra("Birthday", birthday);
        intent.putExtra("Gender", gender);
        startActivity(intent);
    }
}
