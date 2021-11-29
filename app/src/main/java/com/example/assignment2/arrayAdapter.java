package com.example.assignment2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class arrayAdapter extends ArrayAdapter<cyclecallback> {

    private int resource;
    private Context Con;

    public arrayAdapter(@NonNull Context context, int resource, List<cyclecallback> object) {
        super(context, resource, object);
        this.resource = resource;
        this.Con = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        if (view == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            view = layoutInflater.inflate(R.layout.listview, null);
        }
        cyclecallback text = getItem(position);


        if (text != null){
            TextView t1 = view.findViewById(R.id.tv1);
            TextView t2 = view.findViewById(R.id.tv2);
            t1.setText(text.getEvent());
            t2.setText(text.getTime());

        }
        return view;
    }


}
