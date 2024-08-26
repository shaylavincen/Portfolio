package com.example.projecttwocs360shayla;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projecttwocs360shayla.model.Event;
import com.example.projecttwocs360shayla.repo.EventDatabase;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;
    FloatingActionButton addButton;

    EventDatabase myDb;
    ArrayList<Event> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);



        myDb = new EventDatabase(getApplicationContext());
        arrayList = myDb.returnEvents();

        recyclerAdapter = new RecyclerAdapter(arrayList);

        recyclerView = findViewById(R.id.event_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recyclerAdapter);


        addButton = findViewById(R.id.add_event_button);
        addButton.setOnClickListener(view -> {
            Intent intent = new Intent(HomeActivity.this, AddEventActivity.class);
            startActivity(intent);
        });

        //will need to add menu inflation override for menu to work
        // when a subject is long clicked it must call getSupportActionBar().setDisplayShowTitleEnabled(false)
    }

    @Override
    protected void onResume() {
        super.onResume();
        refreshEvents();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuforhome, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Event event = recyclerAdapter.getSelectedEvent();
        long eventID = event.get_ID();
        if(item.getItemId() == R.id.action_edit){
            Intent intent = new Intent(HomeActivity.this, AddEventActivity.class);
            intent.putExtra("eventID",eventID);
            startActivity(intent);
            //myDb.updateEvent(event.get_ID());
            return true;
        }

        if(item.getItemId() == R.id.action_delete)
        {
            myDb.deleteEvent(eventID);
            refreshEvents();
            return true;
        }

        else{
            return super.onOptionsItemSelected(item);
        }

    }


    private void refreshEvents() {
        arrayList = myDb.returnEvents();
        recyclerAdapter.setEventList(arrayList);
        recyclerAdapter.notifyDataSetChanged();
    }

}