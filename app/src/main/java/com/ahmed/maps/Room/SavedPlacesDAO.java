package com.ahmed.maps.Room;


import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface SavedPlacesDAO {


    @Insert
    void insertNewPlace(SavedPlacesModel savedPlacesModel);

    @Update
    void updateCurrentPlace(SavedPlacesModel savedPlacesModel);

    @Delete
    void deletePlace(SavedPlacesModel savedPlacesModel);

    @Query("DELETE FROM savedPlacesTable")
    void deleteAllSavedPlaces();

    @Query("SELECT * FROM  savedPlacesTable")
    LiveData<List<SavedPlacesModel>> getAllSavedPlaces();


}
