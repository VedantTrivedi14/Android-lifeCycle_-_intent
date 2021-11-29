package com.example.assignment2;

import android.os.Parcel;

import java.io.Serializable;

public class cyclecallback implements Serializable {
    private String Callback;
    private String Timestamp;

    protected cyclecallback(Parcel in) {
        Callback = in.readString();
        Timestamp = in.readString();
    }
    public String getEvent() {
        return Callback;
    }

    public void setEvent(String callback) {
        Callback = callback;
    }
    public String getTime() {
        return Timestamp;
    }
    public void setTime(String time) {
        Timestamp = time;
    }
    public cyclecallback() {
    }
    public cyclecallback(String callback, String time) {
        Callback = callback;
        Timestamp = time;
    }
}
