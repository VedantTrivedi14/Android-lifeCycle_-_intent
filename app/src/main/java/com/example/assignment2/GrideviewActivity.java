package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;

public class GrideviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grideview);
        Intent intent = getIntent();
        Bundle Bundle = intent.getBundleExtra("data");
        ArrayList<CycleCallback> callback = (ArrayList<CycleCallback>) Bundle.getSerializable("callback");


        GridView gridView = findViewById(R.id.gridView);
        ListAdapter adapter = new ListAdapter(this, R.layout.listview,callback);
        gridView.setAdapter(adapter);
    }
}