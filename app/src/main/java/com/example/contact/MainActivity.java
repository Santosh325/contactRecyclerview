package com.example.contact;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;


import com.example.contact.Adapter.RecyclerViewAdapter;
import com.example.contact.data.DatabaseHandler;
import com.example.contact.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private ArrayList<Contact> contactArrayList;
    private ArrayAdapter<String> arrayAdapter;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        contactArrayList = new ArrayList<>();
        DatabaseHandler db = new DatabaseHandler(MainActivity.this);
        List<Contact> contactList = db.getAllContacts();
        for (Contact contact : contactList) {
            Log.d("MainActivity", "onCreate: " + contact.getName());
            contactArrayList.add(contact);


        }

        // setting up adapter
        recyclerViewAdapter = new RecyclerViewAdapter(this,contactArrayList);
        recyclerView.setAdapter(recyclerViewAdapter);
    }
}