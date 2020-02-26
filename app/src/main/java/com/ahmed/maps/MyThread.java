package com.ahmed.maps;

import android.os.Handler;
import android.os.Looper;


public class MyThread extends Thread {

    private static final String TAG = "MyThread";
    public Handler handler;

    @Override
    public void run() {
        Looper.prepare();

        handler = new Handler();

        Looper.loop();

    }
}
