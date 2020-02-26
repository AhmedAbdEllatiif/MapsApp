package com.ahmed.maps.ViewModels;

import android.app.Application;

import com.ahmed.maps.Room.SavedPlacesModel;
import com.ahmed.maps.Room.SavedPlacesRepository;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class MapsViewModel extends AndroidViewModel {


    private SavedPlacesRepository  placesRepository;
    private final LiveData<List<SavedPlacesModel>> allSavedPlaces;

    public MapsViewModel(@NonNull Application application) {
        super(application);

        placesRepository = new SavedPlacesRepository(application);
        this.allSavedPlaces = placesRepository.getAllImages();
    }






    public void insertNewPlace(SavedPlacesModel savedPlacesModel){
        placesRepository.insertNewPlace(savedPlacesModel);
    }

    public void updateCurrentPlace(SavedPlacesModel savedPlacesModel){
        placesRepository.updateCurrentPlace(savedPlacesModel);
    }

    public void deletePlace(SavedPlacesModel savedPlacesModel){
        placesRepository.deleteSavedPlaceTask(savedPlacesModel);
    }

    public void deleteAllSavedPlaces(){
        placesRepository.deleteAll_SavedPlaceTask();
    }

    public LiveData<List<SavedPlacesModel>> getAllSavedPalces(){
        return allSavedPlaces;
    }
}
