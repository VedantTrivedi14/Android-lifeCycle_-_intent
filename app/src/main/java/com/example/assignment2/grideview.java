package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListAdapter;

import java.util.ArrayList;

public class grideview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grideview);
        Intent intent = getIntent();
        Bundle Bundle = intent.getBundleExtra("data");
        ArrayList<cyclecallback> callback = (ArrayList<cyclecallback>) Bundle.getSerializable("callback");


        GridView gridView = findViewById(R.id.gride);
        ListAdapter adapter = new arrayAdapter(this, R.layout.listview,callback);
        gridView.setAdapter(adapter);
    }
}