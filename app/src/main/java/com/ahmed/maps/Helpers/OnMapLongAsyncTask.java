package com.ahmed.maps.Helpers;

import android.os.AsyncTask;

import com.ahmed.maps.Room.SavedPlacesModel;
import com.google.android.gms.maps.model.LatLng;

public class OnMapLongAsyncTask extends AsyncTask<SavedPlacesModel,Void,SavedPlacesModel> {

    private LatLng latLng;
    private OnMapLongPressedHelper onMapLongPressedHelper;

    public OnMapLongAsyncTask(LatLng latLng, OnMapLongPressedHelper onMapLongPressedHelper) {
        this.latLng = latLng;
        this.onMapLongPressedHelper = onMapLongPressedHelper;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }



    @Override
    protected SavedPlacesModel doInBackground(SavedPlacesModel[] placesModels) {
        return placesModels[0];
    }

    @Override
    protected void onPostExecute(SavedPlacesModel savedPlacesModel) {
        super.onPostExecute(savedPlacesModel);
        //onMapLongPressedHelper.onSavedPlaceModelIsReady(savedPlacesModel);
    }
}
