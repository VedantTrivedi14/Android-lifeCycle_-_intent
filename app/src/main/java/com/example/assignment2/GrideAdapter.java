package com.example.assignment2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class GrideAdapter extends ArrayAdapter<CycleCallback> {

    public GrideAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    @SuppressLint("InflateParams")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        if (view == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            view = layoutInflater.inflate(R.layout.listview, null);
        }
        CycleCallback text = getItem(position);


        if (text != null) {
            TextView t1 = view.findViewById(R.id.tv1);
            TextView t2 = view.findViewById(R.id.tv2);
            t1.setText(text.getEvent());
            t2.setText(text.getTime());

        }
        return view;
    }
}
