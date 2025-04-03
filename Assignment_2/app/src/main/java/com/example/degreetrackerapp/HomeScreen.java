package com.example.degreetrackerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;

public class HomeScreen extends AppCompatActivity {
    Button clickAccountButton;
    Button clickFoundationButton;
    Button clickUndergradButton;
    Button clickPostgradButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        clickAccountButton = findViewById(R.id.homeScreenAccountButton);
        clickFoundationButton = findViewById(R.id.homeScreenFoundationButton);
        clickUndergradButton = findViewById(R.id.homeScreenUndergradButton);
        clickPostgradButton = findViewById(R.id.homeScreenPostgradButton);
    }

    public void linkAccountScreen(View view) {
        Intent intent= new Intent(this, AccountScreen.class);
        startActivity(intent);
    }
    public void linkFoundationCalc(View view) {
        Intent intent= new Intent(this, FoundationCalc.class);
        startActivity(intent);
    }
    public void linkUndergradCalc(View view) {
        Intent intent= new Intent(this, UndergradCalc.class);
        startActivity(intent);
    }
    public void linkPostgradCalc(View view) {
        Intent intent= new Intent(this, PostgradCalc.class);
        startActivity(intent);
    }
}