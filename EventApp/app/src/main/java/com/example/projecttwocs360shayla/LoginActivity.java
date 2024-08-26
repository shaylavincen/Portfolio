package com.example.projecttwocs360shayla;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.projecttwocs360shayla.repo.EventDatabase;

public class LoginActivity extends AppCompatActivity {

    Button createButton;
    Button loginButton;
    Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        //change this to data bind
        setContentView(R.layout.activity_loginscreen);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        createButton = findViewById(R.id.createbutton);
        loginButton = findViewById(R.id.loginbutton);
        db = new Database(getApplicationContext());

            loginButton.setOnClickListener(view -> {
                EditText usernameView = findViewById(R.id.Username);
                String username = usernameView.getText().toString();

                EditText passwordView = findViewById(R.id.Password);
                String password = passwordView.getText().toString();


                if (db.checkData(username, password)) {
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(intent);

                }
                else {
                    CharSequence text = "Wrong email/password, please try again. ";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(this /* MyActivity */, text, duration);
                    toast.show();

                }
            });

            createButton.setOnClickListener(view -> {
                Intent intent = new Intent(LoginActivity.this, CreateAccount.class);
                startActivity(intent);

            });


        }
    }





