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

import com.example.projecttwocs360shayla.model.Event;
import com.example.projecttwocs360shayla.repo.EventDatabase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class AddEventActivity extends AppCompatActivity {

    Button saveButton;
    EventDatabase myDb;
    SimpleDateFormat format = new SimpleDateFormat("MM-dd-yy", Locale.US);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_event);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        myDb = new EventDatabase(getApplicationContext());
        Bundle extras = getIntent().getExtras();
        if( extras != null) {
            long value = extras.getLong("eventID");
            //set values to screen

            Event event = myDb.returnEvent(value);

            SimpleDateFormat format = new SimpleDateFormat("MM-dd-yy", Locale.US);
            String dateString = format.format(new Date(event.getMyDate()));

            EditText dateView = findViewById(R.id.date);
            dateView.setText(dateString);
            EditText titleView = findViewById(R.id.eventTitle);
            titleView.setText(event.getEventTitle());
            EditText eventDescription = findViewById(R.id.eventDescription);
            eventDescription.setText(event.getEventDescription());
        }

        //save event
        saveButton = findViewById(R.id.savebutton);
        saveButton.setOnClickListener(view -> {
            EditText dateView = findViewById(R.id.date);
            String dateString = dateView.getText().toString();

            EditText titleView = findViewById(R.id.eventTitle);
            String eventTitle = titleView.getText().toString();

            EditText eventDescription = findViewById(R.id.eventDescription);
            String eventDesc = eventDescription.getText().toString();

            Date date = null;
            try {
                date = format.parse(dateString);
            } catch (ParseException e) {
                CharSequence text = "Please enter correct Date format (Ex: '01-01-20') ";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(this /* MyActivity */, text, duration);
                toast.show();
                return;
            }

            //get information from HomeActivity
            if( extras != null){
                long value = extras.getLong("eventID");
                //update event
                myDb.updateEvent(value, eventTitle, eventDesc, date);
            }
            else {
                //insert data into database
                myDb.insertEvent(eventTitle, eventDesc, date);
            }
            finish();
        });



    }

}
