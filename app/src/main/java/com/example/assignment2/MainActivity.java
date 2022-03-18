package com.example.assignment2;

import android.annotation.SuppressLint;
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
    public String Localtime() {
        Calendar cal = Calendar.getInstance();
        Date currentLocalTime = cal.getTime();
        @SuppressLint("SimpleDateFormat") DateFormat date = new SimpleDateFormat("HH:mm:ss a");
        return date.format(currentLocalTime);
    }

    public void setItem(String time, String description) {
        list.add(new CycleCallback(time, description));
        ListAdapter lAdapter = new ListAdapter(this, R.layout.listview, list);
        mListView.setAdapter(lAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = findViewById(R.id.lifecycleList);
        Button mGrid = findViewById(R.id.mGrid);
        Button mSend = findViewById(R.id.btnDataSend);


        setItem(Localtime(), "onCreate:Activity is Created.");

        mGrid.setOnClickListener(v -> {

            Intent intent = new Intent(MainActivity.this, GridViewActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("callback", list);
            intent.putExtra("data", bundle);
            startActivity(intent);
        });

        mSend.setOnClickListener(v -> {

            StringBuilder s = new StringBuilder();
            for (CycleCallback i : list)
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

        setItem(Localtime(), "onStart:Activity is visible now.");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        setItem(Localtime(), "onRestart:Activity start again.");
    }

    @Override
    protected void onResume() {
        super.onResume();

        setItem(Localtime(), "onResume:user can interact with UI.");
    }

    @Override
    protected void onPause() {
        super.onPause();

        setItem(Localtime(), "onPause:Activity is in background.");
    }

    @Override
    protected void onStop() {
        super.onStop();

        setItem(Localtime(), "onStop:Activity not visible now.");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        setItem(Localtime(), "onDestroy:Activity closed.");
    }


}