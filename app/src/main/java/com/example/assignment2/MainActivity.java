package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    ListView mListView;
    ArrayList<cyclecallback> list = new ArrayList<>();
    Button mGride,msend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView =(ListView) findViewById(R.id.lifecyclelist);
        mGride = (Button) findViewById(R.id.gride);
        msend = (Button) findViewById(R.id.sendData);

        Calendar cal = Calendar.getInstance();
        Date currentLocalTime = cal.getTime();
        DateFormat date = new SimpleDateFormat("HH:mm:ss a");
        String currentTime = date.format(currentLocalTime);

        list.add(new cyclecallback("onCreate",currentTime));
        ListAdapter adapter = new arrayAdapter(this, R.layout.listview, list);
        mListView.setAdapter(adapter);

        mGride.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, grideview.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("callback",list);
                intent.putExtra("data", bundle);
                startActivity(intent);
            }
        });


        msend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String s = new String() ;
                for (cyclecallback i: list)
                    s += "[ "+i.getEvent()+" invoke at "+i.getTime()+".]";

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT,s);
                intent.setType("text/plain");
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        mListView =(ListView) findViewById(R.id.lifecyclelist);
        Calendar cal = Calendar.getInstance();
        Date currentLocalTime = cal.getTime();
        DateFormat date = new SimpleDateFormat("HH:mm:ss a");
        String currentTime = date.format(currentLocalTime);
        list.add(new cyclecallback("onStart",currentTime));
        ListAdapter adapter = new arrayAdapter (this,R.layout.listview, list);
        mListView.setAdapter(adapter);

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        mListView =(ListView) findViewById(R.id.lifecyclelist);
        Calendar cal = Calendar.getInstance();
        Date currentLocalTime = cal.getTime();
        DateFormat date = new SimpleDateFormat("HH:mm:ss a");
        String currentTime = date.format(currentLocalTime);
        list.add(new cyclecallback("onRestart",currentTime));
        ListAdapter adapter = new arrayAdapter(this, R.layout.listview, list) ;
        mListView.setAdapter(adapter);

    }

    @Override
    protected void onResume() {
        super.onResume();
        mListView =(ListView) findViewById(R.id.lifecyclelist);
        Calendar cal = Calendar.getInstance();
        Date currentLocalTime = cal.getTime();
        DateFormat date = new SimpleDateFormat("HH:mm:ss a");
        String currentTime = date.format(currentLocalTime);
        list.add(new cyclecallback("activity is now user interactable and comes in forground state",currentTime));
        ListAdapter adapter = new arrayAdapter (this, R.layout.listview, list);
        mListView.setAdapter(adapter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mListView =(ListView) findViewById(R.id.lifecyclelist);
        Calendar cal = Calendar.getInstance();
        Date currentLocalTime = cal.getTime();
        DateFormat date = new SimpleDateFormat("HH:mm:ss a");
        String currentTime = date.format(currentLocalTime);
        list.add(new cyclecallback("activity goes in background state",currentTime));
        ListAdapter adapter = new arrayAdapter (this, R.layout.listview, list);
        mListView.setAdapter(adapter);

    }

    @Override
    protected void onStop() {
        super.onStop();
        mListView =(ListView) findViewById(R.id.lifecyclelist);
        Calendar cal = Calendar.getInstance();
        Date currentLocalTime = cal.getTime();
        DateFormat date = new SimpleDateFormat("HH:mm:ss a");
        String currentTime = date.format(currentLocalTime);
        list.add(new cyclecallback("activity is killed but store in chashe memory",currentTime));
        ListAdapter adapter = new arrayAdapter (this, R.layout.listview, list);
        mListView.setAdapter(adapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mListView =(ListView) findViewById(R.id.lifecyclelist);
        Calendar cal = Calendar.getInstance();
        Date currentLocalTime = cal.getTime();
        DateFormat date = new SimpleDateFormat("HH:mm:ss a");
        String currentTime = date.format(currentLocalTime);
        list.add(new cyclecallback("onDestroy",currentTime));
        ListAdapter adapter = new arrayAdapter (this,R.layout.listview, list);
        mListView.setAdapter(adapter);
    }


}