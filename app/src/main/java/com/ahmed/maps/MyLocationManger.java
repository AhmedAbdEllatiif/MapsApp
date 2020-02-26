package com.ahmed.maps;


import android.content.Context;
import android.location.LocationManager;

public class MyLocationManger {

    private Context context;
    public LocationManager locationManager;

    public MyLocationManger(Context context) {
        this.context = context;


    }

    private void initLocationManager(){
        locationManager = (LocationManager) context.getSystemService(context.LOCATION_SERVICE);
    }
}
