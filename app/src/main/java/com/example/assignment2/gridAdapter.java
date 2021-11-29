package com.example.assignment2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class gridAdapter extends ArrayAdapter<cyclecallback> {
    List<cyclecallback> listofcyclecallback = new ArrayList<cyclecallback>();
    int Resource;

    public gridAdapter(@NonNull Context context, int resource, List<cyclecallback> obj) {
        super(context, resource, obj);
        listofcyclecallback = obj;
         Resource = resource;
    }

    @Override
    public int getCount() {
        return listofcyclecallback.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            v = inflater.inflate(R.layout.grideview, null);
        }

        TextView textView1 = v.findViewById(R.id.tv1);
        TextView textView2 = v.findViewById(R.id.tv2);

        cyclecallback item = listofcyclecallback.get(position);

        textView1.setText(item.getEvent());
        textView2.setText(item.getTime());
        return v;
    }
}
