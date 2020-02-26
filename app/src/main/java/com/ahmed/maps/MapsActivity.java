package com.ahmed.maps;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import de.hdodenhof.circleimageview.CircleImageView;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ahmed.maps.Helpers.AddressHelper;
import com.ahmed.maps.Room.SavedPlacesModel;
import com.ahmed.maps.ViewModels.MapsViewModel;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.widget.AutocompleteSupportFragment;
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MapsActivity extends FragmentActivity implements LocationListener, OnMapReadyCallback, OnUpdateUiReady {


    //30.046714,31.194940

    /*
     * TODO:
     *  Location manager , SearchBar , Design , continue
     *  */

/*

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.

        //To initialize viewModel
        viewModel = new ViewModelProvider(this).get(MapsViewModel.class);

        //To initialize views
        initViews();
        //To initialize Fragments
        initFragments();




        // Specify the types of place data to return.
        autocompleteFragment.setPlaceFields(Arrays.asList(Place.Field.ID, Place.Field.NAME));

        // Set up a PlaceSelectionListener to handle the response.
        autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(Place place) {
                // TODO: Get info about the selected place.
                Log.e(TAG, "Place: " + place.getName() + ", " + place.getId());
            }

            @Override
            public void onError(Status status) {
                // TODO: Handle the error.
                Log.e(TAG, "An error occurred: " + status);
            }
        });


        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]
                            {Manifest.permission.ACCESS_FINE_LOCATION},
                    REQUEST_LOCATION_PERMISSION);
        } else {

            locationListener = new LocationListener() {
                @Override
                public void onLocationChanged(Location location) {
                    double latitude = location.getLatitude();
                    double longitude = location.getLongitude();
                    //get the location name from latitude and longitude
                    Geocoder geocoder = new Geocoder(getApplicationContext());
                    try {
                        List<Address> addresses =
                                geocoder.getFromLocation(latitude, longitude, 1);
                        result = addresses.get(0).getLocality() + ":";
                        result += addresses.get(0).getCountryName();
                        latLng = new LatLng(latitude, longitude);
                        if (marker != null) {
                            marker.remove();
                            marker = mMap.addMarker(new MarkerOptions().position(latLng).title(result));
                            mMap.setMaxZoomPreference(20);
                            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 12.0f));
                        } else {
                            marker = mMap.addMarker(new MarkerOptions().position(latLng).title(result));
                            mMap.setMaxZoomPreference(20);
                            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 21.0f));
                        }


                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onStatusChanged(String provider, int status, Bundle extras) {

                }

                @Override
                public void onProviderEnabled(String provider) {

                }

                @Override
                public void onProviderDisabled(String provider) {

                }
            };
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
        }


    }


    */


/**
 * When user press on btn current location
 * Move the camera to the current location
 *//*

    private void onBtnCurrentLocationClickListener() {
        btn_currentLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ActivityCompat.checkSelfPermission(MapsActivity.this,
                        Manifest.permission.ACCESS_FINE_LOCATION)
                        == PackageManager.PERMISSION_GRANTED) {
                    locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
                    locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);

                }

                marker = mMap.addMarker(new MarkerOptions().position(latLng).title(result));
                mMap.setMaxZoomPreference(20);
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 12.0f));
                //mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                //MAP_TYPE_SATELLITE
                //MAP_TYPE_TERRAIN
                //MAP_TYPE_HYBRID

            }
        });

    }


    */


/**
 * onRequestPermissionsResult
 * *//*

    private String result;
    private LatLng latLng;
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {

            locationListener = new LocationListener() {
                @Override
                public void onLocationChanged(Location location) {
                    double latitude = location.getLatitude();
                    double longitude = location.getLongitude();
                    //get the location name from latitude and longitude
                    Geocoder geocoder = new Geocoder(getApplicationContext());
                    try {
                        List<Address> addresses =
                                geocoder.getFromLocation(latitude, longitude, 1);
                        result = addresses.get(0).getLocality() + ":";
                        result += addresses.get(0).getCountryName();
                        latLng = new LatLng(latitude, longitude);
                        if (marker != null) {
                            marker.remove();
                            marker = mMap.addMarker(new MarkerOptions().position(latLng).title(result));
                            mMap.setMaxZoomPreference(20);
                            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 12.0f));
                        } else {
                            marker = mMap.addMarker(new MarkerOptions().position(latLng).title(result));
                            mMap.setMaxZoomPreference(20);
                            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 21.0f));
                        }


                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onStatusChanged(String provider, int status, Bundle extras) {

                }

                @Override
                public void onProviderEnabled(String provider) {

                }

                @Override
                public void onProviderDisabled(String provider) {

                }
            };
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);


        }
    }





    */
    /************************************************************************Activity lifeCycle****************************************************//*

    @Override
    protected void onStop() {
        super.onStop();
        locationManager.removeUpdates(locationListener);
    }
*/




    private static final String TAG = "MapsActivity";

    //viewModel
    private MapsViewModel viewModel;

    //Views
    private FrameLayout searchView;
    private ImageButton btn_currentLocation;

    //Google Map
    private GoogleMap mMap;

    //Fragments
    private SupportMapFragment mapFragment;
    private AutocompleteSupportFragment autocompleteFragment;
    private BottomSheetBehavior bottomSheetBehavior;

    private LocationManager locationManager;
    private Marker marker;
    private LocationListener locationListener;

    private static final int REQUEST_LOCATION_PERMISSION = 1;

    private LinearLayout bottomSheet;
    private FloatingActionButton fab;

    private AnimationHelper animationHelper;

    //BottomSheet
    private TextView bottom_sheet_title;
    private TextView txt_fullAddress;
    private TextView txt_place_num;
    private Button btn_savePlace;
    private CardView cardView;


    private List<SavedPlacesModel> myPlaces;
    private CircleImageView profile_image;

    private AddressHelper addressHelper;


    private String result;
    private LatLng latLng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        if (BuildConfig.DEBUG) {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                    .detectAll()
                    .penaltyLog()
                    .build());
        }


        //To initialize viewModel
        viewModel = new ViewModelProvider(this).get(MapsViewModel.class);

        animationHelper = new AnimationHelper();

        initViews();
        initFragments();
        initBottomSheetBehavior();
        //onViewsClickedAfterMapIsReady();

        onViewsClicked();


    }


    /**
     * To get the current location and move the camera
     */
    private int startOfApp = -1;
    private void detectCurrentLocation() {
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]
                            {Manifest.permission.ACCESS_FINE_LOCATION},
                    REQUEST_LOCATION_PERMISSION);
        } else {
            locationListener = this;
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
        }
    }






    /**
     * To initialize views
     */
    private void initViews() {
        //btn_currentLocation = findViewById(R.id.btn_currentLocation);
        searchView = findViewById(R.id.searchView);
        fab = findViewById(R.id.fab_directions);

        profile_image = findViewById(R.id.profile_image);

        bottomSheet = findViewById(R.id.bottom_sheet);
        bottom_sheet_title = findViewById(R.id.bottom_sheet_title);
        btn_savePlace = findViewById(R.id.btn_savePlace);
        txt_fullAddress = findViewById(R.id.txt_fullAddress);
        txt_place_num = findViewById(R.id.txt_place_num);

        cardView = findViewById(R.id.bottomCard);
    }

    /**
     * To initialize Fragments
     */
    private void initFragments() {
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
                mapFragment.getMapAsync(MapsActivity.this);
            }
        });


        new Handler().post(new Runnable() {
            @Override
            public void run() {
                Places.initialize(getApplicationContext(), getString(R.string.google_maps_key));
                autocompleteFragment = (AutocompleteSupportFragment)
                        getSupportFragmentManager().findFragmentById(R.id.autocomplete_fragment);

                // Specify the types of place data to return.
                autocompleteFragment.setPlaceFields(Arrays.asList(Place.Field.ID, Place.Field.NAME));

                // Set up a PlaceSelectionListener to handle the response.
                autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
                    @Override
                    public void onPlaceSelected(Place place) {
                        // TODO: Get info about the selected place.
                        Log.e(TAG, "Place: " + place.getName() + ", " + place.getId());
                        Log.e(TAG, "PlaceLocation: " + place.getLatLng());

                        moveCameraToPosition(latLng);
                    }

                    @Override
                    public void onError(Status status) {
                        // TODO: Handle the error.
                        Log.e(TAG, "An error occurred: " + status);
                    }
                });
            }
        });


    }

    /**
     * OnViews Clicked
     */
    private void onViewsClicked() {
        profile_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MapsActivity.this, "Image asdfsadasd", Toast.LENGTH_SHORT).show();
            }
        });

    }

    /**
     * To initialize bottomSheetBehavior
     */
    private void initBottomSheetBehavior() {
        // init the bottom sheet behavior
        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);

        // change the state of the bottom sheet
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        cardView.setCardBackgroundColor(getColor(R.color.light_off_white));

        // set callback for changes
        bottomSheetBehavior.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                if (newState == BottomSheetBehavior.STATE_COLLAPSED){
                    cardView.setCardBackgroundColor(getColor(R.color.light_off_white));
                    //cardView.setRadius(150);
                }else {
                    cardView.setCardBackgroundColor(getColor(R.color.white));
                    //cardView.setRadius(150);
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });
    }


    /**
     * To get All saved places from room dataBase
     * Then fill myPlaces with saved places from RoomDataBase
     */
    private void fetchSavedPlaces() {
        viewModel.getAllSavedPalces().observe(this, new Observer<List<SavedPlacesModel>>() {
            @Override
            public void onChanged(List<SavedPlacesModel> savedPlacesModels) {
                if (savedPlacesModels != null) {
                    myPlaces = savedPlacesModels;
                    setPlacesOnMap();
                } else {
                    Log.e(TAG, "setSavedPlacedOnMap: savedPlaces null");
                }
            }

        });
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        //mMap = Tools.configActivityMaps(googleMap);
        mMap = Tools.configActivityMaps(googleMap);
        //MarkerOptions markerOptions = new MarkerOptions().position(new LatLng(37.7610237, -122.4217785));
        //mMap.addMarker(markerOptions);
        //mMap.moveCamera(zoomingLocation(new LatLng(37.76496792, -122.42206407)));

        onViewsClickedAfterMapIsReady();

        //To detect the current location and move the camera
        detectCurrentLocation();

        //To fetch all saved places from room dataBase
        fetchSavedPlaces();

    }


    /**
     * To add places on the map
     */
    private void setPlacesOnMap() {
        for (SavedPlacesModel savedPlacesModel : myPlaces) {
            LatLng savedPlaceLatLng = new LatLng(savedPlacesModel.getLat(), savedPlacesModel.getLng());
            String label = savedPlacesModel.getLable();
            if (mMap != null) {
                Marker newMarker = mMap.addMarker(new MarkerOptions().position(savedPlaceLatLng).title(label));
                newMarker.showInfoWindow();

                if (savedPlacesModel.getNotes() != null) {
                    if (savedPlacesModel.getNotes().size() > 0) {
                        for (String note : savedPlacesModel.getNotes()) {
                            Log.e(TAG, "id: " + savedPlacesModel.getId() + "RoomNotes: " + note);
                        }
                    }
                }
            } else {
                Log.e(TAG, "setSavedPlacedOnMap: map null ");
            }
        }
    }


    /**
     * To handle when views clicked
     */
    private void onViewsClickedAfterMapIsReady() {
        //When map clicked
        onMapSingleClick();

        //When map long clicked
        onMapLongPressed();

        //When user press on any marker
        onMarkerPressed();
    }


    /**
     * To handle when user press on marker
     */
    private void onMarkerPressed() {
        if (mMap != null) {
            mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                @Override
                public boolean onMarkerClick(Marker marker) {
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                    marker.showInfoWindow();
                    try {
                        mMap.animateCamera(zoomingLocation(marker.getPosition()));
                        setBottomSheetInfo(marker);
                    } catch (Exception e) {
                    }
                    return true;
                }
            });
        } else {
            Log.e(TAG, "onMarkerPressed: map null");
        }
    }


    /**
     * When FloatingActionButton clicked
     * move to the current location
     */
    private void onFabClicked(final LatLng latLng) {
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                try {
                    mMap.animateCamera(zoomingLocation(latLng));

                } catch (Exception e) {
                }
            }
        });
    }


    /**
     * When map single clicked hide all view
     */
    private void onMapSingleClick() {
        if (mMap != null) {
            mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
                @Override
                public void onMapClick(LatLng latLng) {

                    hideAndShowViewsWhenMapClicked();
                }
            });
        } else {
            Log.e(TAG, "onMapSingleClick: map is null");
        }
    }


    /**
     * When map long clicked set a new pinMark
     */
    private void onMapLongPressed() {
        if (mMap != null) {
            mMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
                @Override
                public void onMapLongClick(final LatLng latLng) {

                    addressHelper = new AddressHelper(MapsActivity.this, latLng.latitude, latLng.longitude);

                    //To show marker on the map and update  bottom sheet info
                    new UpdateUiTask(latLng, MapsActivity.this, MapsActivity.this).execute();

                    //To saved the place model to the room data base when user press save
                    onBtnSavePlaceClicked(latLng);

                }
            });
        }
    }


    /**
     * To update ui after markerOptions is ready
     * Fill bottom sheet with place info
     * Add marker on the map
     */
    @Override
    public void updateUiOnLongPress(MarkerOptions markerOptions) {
        removeMarker();
        marker = mMap.addMarker(markerOptions);
        mMap.addPolygon(new PolygonOptions()
                .fillColor(ContextCompat.getColor(MapsActivity.this, R.color.grey_3))
                .addAll(createOuterBounds())
                .addHole(createHole(latLng, 30))
                .strokeWidth(0));
        marker.setTitle(addressHelper.getSubAdminArea());
        bottom_sheet_title.setText(addressHelper.getAddressTitle());
        txt_fullAddress.setText(addressHelper.getFullAddressLine());
        txt_place_num.setText(addressHelper.getPlaceNum());
    }

    /**
     * To remove the marker if marker exists
     */
    private void removeMarker() {
        if (marker != null) marker.remove();
    }


    /**
     * To set bottomSheet info with marker
     * change info user press on a marker
     */
    private void setBottomSheetInfo(Marker marker) {
        double latitude = marker.getPosition().latitude;
        double longitude = marker.getPosition().longitude;

        addressHelper = new AddressHelper(MapsActivity.this, latitude, longitude);

        bottom_sheet_title.setText(addressHelper.getAddressTitle());
        txt_fullAddress.setText(addressHelper.getFullAddressLine());
        txt_place_num.setText(addressHelper.getPlaceNum());
    }


    /**
     * To save place
     * The method used when user longPress on the map
     */
    private void onBtnSavePlaceClicked(final LatLng latLng) {

        btn_savePlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SavedPlacesModel savedPlacesModel = new SavedPlacesModel();
                savedPlacesModel.setLable(addressHelper.getSubAdminArea());
                savedPlacesModel.setLat(latLng.latitude);
                savedPlacesModel.setLng(latLng.longitude);
                ArrayList notesList = new ArrayList();
                notesList.add("Note 1");
                notesList.add("Note 2");
                notesList.add("Note 3");
                savedPlacesModel.setNotes(notesList);
                viewModel.insertNewPlace(savedPlacesModel);
            }
        });


    }






    /**
     * To move the camera to a position
     * */
    private void moveCameraToPosition(LatLng latLng){
        mMap.setMaxZoomPreference(20);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 12.0f));
    }


    /**
     * To set
     * */
    private void setMakerOnCurrentLocationAndMoveTheCamera(LatLng latLng){
        if (startOfApp == -1) {
            if (marker != null) {
                marker.remove();
                //mMap.addCircle(new CircleOptions().center(latLng).radius(20).strokeColor(3));
              /*  mMap.addPolygon(new PolygonOptions()
                        .fillColor(ContextCompat.getColor(MapsActivity.this, R.color.grey_3))
                        .addAll(createOuterBounds())
                        .addHole(createHole(latLng, 30))
                        .strokeWidth(0));*/
               // marker = mMap.addMarker(new MarkerOptions().position(latLng).title(result));
                //marker.showInfoWindow();
              moveCameraToPosition(latLng);

                startOfApp++;
            } else {
               // marker = mMap.addMarker(new MarkerOptions().position(latLng).title(result));
                //marker.showInfoWindow();
                //mMap.addCircle(new CircleOptions().center(latLng).radius(20).strokeColor(3));
               /* mMap.addPolygon(new PolygonOptions()
                        .fillColor(ContextCompat.getColor(MapsActivity.this, R.color.grey_3))
                        .addAll(createOuterBounds())
                        .addHole(createHole(latLng, 30))
                        .strokeWidth(0));*/
                drawMarkerWithCircle(latLng);
                moveCameraToPosition(latLng);
                startOfApp++;
            }
        }
    }



    @Override
    public void onLowMemory() {
        super.onLowMemory();


    }
    private Circle mCircle;
    private Marker mMarker;
    private void updateMarkerWithCircle(LatLng position) {
        mCircle.setCenter(position);
        mMarker.setPosition(position);
    }

    private void drawMarkerWithCircle(LatLng position){
        double radiusInMeters = 100.0;
        int strokeColor = 0xffff0000; //red outline
        int shadeColor = 0x44ff0000; //opaque red fill

        CircleOptions circleOptions = new CircleOptions().center(position).radius(radiusInMeters).fillColor(shadeColor).strokeColor(strokeColor).strokeWidth(8);
        mCircle = mMap.addCircle(circleOptions);

        MarkerOptions markerOptions = new MarkerOptions().position(position);
        mMarker = mMap.addMarker(markerOptions);
    }

    private static final int EARTH_RADIUS = 6371;
    private static Iterable<LatLng> createHole(LatLng center, int radius) {
        int points = 50; // number of corners of inscribed polygon

        double radiusLatitude = Math.toDegrees(radius / (float) EARTH_RADIUS);
        double radiusLongitude = radiusLatitude / Math.cos(Math.toRadians(center.latitude));

        List<LatLng> result = new ArrayList<>(points);

        double anglePerCircleRegion = 2 * Math.PI / points;

        for (int i = 0; i < points; i++) {
            double theta = i * anglePerCircleRegion;
            double latitude = center.latitude + (radiusLatitude * Math.sin(theta));
            double longitude = center.longitude + (radiusLongitude * Math.cos(theta));

            result.add(new LatLng(latitude, longitude));
        }

        return result;
    }
    float delta = 0.01f;
    private  List<LatLng> createOuterBounds() {
        return new ArrayList<LatLng>() {{
            add(new LatLng(90 - delta, -180 + delta));
            add(new LatLng(0, -180 + delta));
            add(new LatLng(-90 + delta, -180 + delta));
            add(new LatLng(-90 + delta, 0));
            add(new LatLng(-90 + delta, 180 - delta));
            add(new LatLng(0, 180 - delta));
            add(new LatLng(90 - delta, 180 - delta));
            add(new LatLng(90 - delta, 0));
            add(new LatLng(90 - delta, -180 + delta));
        }};
    }

    /**
     * Call back on {@link com.google.android.gms.location.LocationListener}
     * Call back of location listener
     * When location changed
     * */
    @Override
    public void onLocationChanged(Location location) {
        double latitude = location.getLatitude();
        double longitude = location.getLongitude();
        addressHelper = new AddressHelper(MapsActivity.this, latitude, longitude);
        latLng = addressHelper.getLocation();
        //get the location name from latitude and longitude

        onFabClicked(latLng);

        setMakerOnCurrentLocationAndMoveTheCamera(latLng);
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }














    /**
     * To Deal with views when map clicked
     */
    private void hideAndShowViewsWhenMapClicked() {
        hideAndShowSearchBar();
        hideAndShowBottomSheet();
        hideAndShowBtn();
    }


    /**
     * To hide and show bottomSheet
     */
    private void hideAndShowBottomSheet() {
        // change the state of the bottom sheet
        if (isSearchBarShown) {
            bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        } else if (bottomSheetBehavior.getState() == BottomSheetBehavior.STATE_HIDDEN) {
            bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);

        } else {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
                }
            }, 300);
        }


    }

    private boolean isSearchBarShown = true;
    private boolean isBtnShown = true;

    /**
     * To hide and show search bar
     */
    private void hideAndShowSearchBar() {
        //slideUp();
        if (isSearchBarShown) {
            animationHelper.slideUp(searchView);
            isSearchBarShown = false;
        } else {
            animationHelper.slideDown(searchView);
            isSearchBarShown = true;
        }
    }


    /**
     * To hide and show fab
     */
    private void hideAndShowBtn() {
        if (isBtnShown) {
            animationHelper.slideBottomRight(fab);
            isBtnShown = false;
        } else {
            animationHelper.slideBottomLeft(fab);
            isBtnShown = true;
        }
    }


    private CameraUpdate zoomingLocation(LatLng latLng) {
        return CameraUpdateFactory.newLatLngZoom(latLng, 13);
    }


}
