package com.example.assignment2;

import java.io.Serializable;

public class CycleCallback implements Serializable {
    private final String Callback;
    private final String Timestamp;

    public String getEvent() {
        return Callback;
    }

    public String getTime() {
        return Timestamp;
    }

    public CycleCallback(String callback, String time) {
        Callback = callback;
        Timestamp = time;
    }
}
