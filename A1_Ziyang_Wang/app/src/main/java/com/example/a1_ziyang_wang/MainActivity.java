package com.example.a1_ziyang_wang;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.content.Intent;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {



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
    }

    public void showToast(View view) {
        Toast toast = Toast.makeText(this,R.string.toast_msg,Toast.LENGTH_LONG);
        toast.show();
    }

    public void showRegisterForm(View view) {
        Intent intent = new Intent(this,RegistrationFormOne.class);
        startActivity(intent);
    }

    public void explorePage(View view) {
        Intent intent = new Intent(this,Explore.class);
        startActivity(intent);
    }

    public void feedbackPage(View view) {
        Intent intent = new Intent(this,Feedback.class);
        startActivity(intent);
    }

    public void homePage(View view) {
        Intent intent = new Intent(this,Home.class);
        startActivity(intent);
    }
}