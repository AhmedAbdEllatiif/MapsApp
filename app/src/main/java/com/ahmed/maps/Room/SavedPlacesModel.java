package com.ahmed.maps.Room;


import com.ahmed.maps.R;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "savedPlacesTable")
public class SavedPlacesModel {


    @PrimaryKey(autoGenerate = true)
    private int id;

    private Double lat;
    private Double lng;
    private String country;
    private String lable;

    private ArrayList<String> notes;
    private ArrayList<String> images;
    private int priority;

    @Ignore
    public SavedPlacesModel() {}

    public SavedPlacesModel(int id, Double lat, Double lng, String country, String lable, ArrayList<String> notes, ArrayList<String> images, int priority) {
        this.id = id;
        this.lat = lat;
        this.lng = lng;
        this.country = country;
        this.lable = lable;

        this.notes = notes;
        this.images = images;
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLable() {
        return lable;
    }

    public void setLable(String lable) {
        this.lable = lable;
    }


    public ArrayList<String> getNotes() {
        return notes;
    }

    public void setNotes(ArrayList<String> notes) {
        this.notes = notes;
    }

    public ArrayList<String> getImages() {
        return images;
    }

    public void setImages(ArrayList<String> images) {
        this.images = images;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
