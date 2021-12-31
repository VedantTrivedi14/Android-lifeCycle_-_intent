package com.example.assignment2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    ListView mListView;
    ArrayList<CycleCallback> list = new ArrayList<>();
     android.widget.ListAdapter lAdapter;
    String currentTime="";

    public  String time(){
        Calendar cal = Calendar.getInstance();
        Date currentLocalTime = cal.getTime();
        DateFormat date = new SimpleDateFormat("HH:mm:ss a");

        return date.format(currentLocalTime);
    }
    public void setItem(String state,String time,String description)
    {

        list.add(new CycleCallback(state,time,description));
        lAdapter = new ListAdapter(this,R.layout.listview, list);
        mListView.setAdapter(lAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = findViewById(R.id.lifecycleList);
        Button mGride = findViewById(R.id.mGride);
        Button mSend = findViewById(R.id.btnDataSend);

        currentTime = time();
        setItem("onCreate",currentTime,"Activity is Created.");

        mGride.setOnClickListener(v -> {

            Intent intent = new Intent(MainActivity.this, GrideviewActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("callback",list);
            intent.putExtra("data", bundle);
            startActivity(intent);
        });


        mSend.setOnClickListener(v -> {

            StringBuilder s = new StringBuilder();
            for (CycleCallback i: list)
                s.append("{ ").append(i.getEvent()).append(" invoke at ").append(i.getTime()).append(".}");

            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.putExtra(Intent.EXTRA_TEXT, s.toString());
            intent.setType("text/plain");
            startActivity(intent);
        });
    }
    @Override
    protected void onStart() {
        super.onStart();

        currentTime = time();
        setItem("onStart",currentTime,"Activity is visible now.");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        currentTime = time();
        setItem("onRestart",currentTime,"Activity start again.");

    }

    @Override
    protected void onResume() {
        super.onResume();

        currentTime = time();
        setItem("onResume",currentTime,"Activity is user interctebale.");
    }

    @Override
    protected void onPause() {
        super.onPause();

        currentTime = time();
        setItem("onPause",currentTime,"Activity is in background.");

    }

    @Override
    protected void onStop() {
        super.onStop();

        currentTime = time();
        setItem("onStop",currentTime,"Activity not visible now.");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        currentTime = time();
        setItem("onDestroy",currentTime,"Activity closed.");
    }


}