package com.ahmed.maps;

import android.os.AsyncTask;

import com.ahmed.maps.Helpers.AddressHelper;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.lang.ref.WeakReference;

public class UpdateUiTask extends AsyncTask<MarkerOptions,Void,MarkerOptions> {

    private static final String TAG = "UpdateUiTask";
    private LatLng latLng;
    private AddressHelper addressHelper;
    private WeakReference<MapsActivity> weakReference;
    private OnUpdateUiReady onUpdateUiReady;

    public UpdateUiTask(LatLng latLng, OnUpdateUiReady onUpdateUiReady, MapsActivity activity) {
        this.latLng = latLng;
        this.weakReference = new WeakReference<MapsActivity>(activity);
        this.onUpdateUiReady = onUpdateUiReady;
    }

    @Override
    protected MarkerOptions doInBackground(MarkerOptions[] markerOptions) {
        MapsActivity mapsActivity = weakReference.get();
        if (mapsActivity != null && !mapsActivity.isFinishing()){
            addressHelper = new AddressHelper(mapsActivity, latLng.latitude, latLng.longitude);
        }

        MarkerOptions markerOptions1 = new MarkerOptions().position(latLng);

        return markerOptions1;
    }

    @Override
    protected void onPostExecute(MarkerOptions markerOptions) {
        onUpdateUiReady.updateUiOnLongPress(markerOptions);

    }

}
