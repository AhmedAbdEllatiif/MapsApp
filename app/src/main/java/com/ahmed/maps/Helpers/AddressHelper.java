package com.ahmed.maps.Helpers;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.util.Log;

import com.google.android.gms.maps.model.LatLng;

import java.io.IOException;
import java.util.List;

public class AddressHelper {

    private static final String TAG = "AddressHelper";
    private Context context;
    private double latitude;
    private double longitude;

    public AddressHelper(Context context, double latitude, double longitude) {
        this.context = context;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    private Address getAddress(){
        Geocoder geocoder = new Geocoder(context);
        try {
            List<Address> addresses =
                    geocoder.getFromLocation(latitude, longitude, 1);
            return  addresses.get(0);
        } catch (IOException e) {
            Log.d(TAG, "getAddress: " + e.getMessage());
        }
        return null;
    }


    public LatLng getLocation(){
        return new LatLng(latitude,longitude);
    }


    public String getAddressTitle(){
        if (getAddress() != null){
            Address address = getAddress();
            String result = address.getLocality() + ":";
            result += address.getCountryName();
            result += " , " + address.getAdminArea();
            result +=  " , " + address.getSubAdminArea();
            return result;
        }

        return null;
    }


    public String getFullAddressLine(){
        if (getAddress() != null){
            Address address = getAddress();
            return address.getAddressLine(0);
        }

        return null;
    }


    public String getSubAdminArea(){
        if (getAddress() != null){
            Address address = getAddress();
            return address.getSubAdminArea();
        }

        return null;
    }


    public String getPlaceNum(){

        if (getAddress() != null){
            Address address = getAddress();
            return address.getPhone();
        }

        return null;
    }
}
