package com.example.degreetrackerapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class RegisterScreen extends AppCompatActivity {
    Button RegisterButton, accountScreenSaveChangesButton;
    FirebaseFirestore firestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_screen);

        RegisterButton = findViewById(R.id.RegisterButton);
        firestore = FirebaseFirestore.getInstance();

        Map<String, Object> user = new HashMap<>();
        user.put("firstname", "Lizzy");
        user.put("lastname", "McGuire");
        user.put("degree", "Computer Science");
        user.put("education level", "Foundation");
        user.put("email", "lm123@gmail.com");
        user.put("password", "password123");

        firestore.collection("users").add(user).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Toast.makeText(RegisterScreen.this, "Success", Toast.LENGTH_LONG).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(RegisterScreen.this, "Failure: " + e.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

        RegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linkHomeScreen(v);
            }
        });
    }

    public void linkHomeScreen(View view) {
        Intent intent = new Intent(this, HomeScreen.class);
        startActivity(intent);
    }
    public void createAccountButton(View view) {
        Intent intent = new Intent(this, LoginScreen.class);
        startActivity(intent);
    }
}
