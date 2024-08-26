package com.example.projecttwocs360shayla;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CreateAccount extends AppCompatActivity {
    Button createButton;
    Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_create_account);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        createButton = findViewById(R.id.createbutton);
        db = new Database(getApplicationContext());

        createButton.setOnClickListener(view -> {
            EditText usernameView = findViewById(R.id.Username);
            String username = usernameView.getText().toString();

            EditText passwordView = findViewById(R.id.Password);
            String password = passwordView.getText().toString();

            db.insertData(username, password);

            finish();

        });
    }
}