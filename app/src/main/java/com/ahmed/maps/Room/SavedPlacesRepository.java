package com.ahmed.maps.Room;

import android.app.Application;
import android.os.AsyncTask;

import java.util.List;

import androidx.lifecycle.LiveData;

public class SavedPlacesRepository {


    private final SavedPlacesDAO savedPlacesDAO;
    private final LiveData<List<SavedPlacesModel>> allSavedPlaces;

    public SavedPlacesRepository(Application application) {
        RoomDataBaseInstance dataBase = RoomDataBaseInstance.getInstance(application);
        savedPlacesDAO = dataBase.savedPlacesDAO();
        allSavedPlaces = savedPlacesDAO.getAllSavedPlaces();
    }


    public void insertNewPlace(SavedPlacesModel savedPlacesModel) {
        new InsertSavedPlaceTask(savedPlacesDAO).execute(savedPlacesModel);
    }

    public void updateCurrentPlace(SavedPlacesModel savedPlacesModel) {
        new UpdatedSavedPlaceTask(savedPlacesDAO).execute(savedPlacesModel);
    }

    public void deleteSavedPlaceTask(SavedPlacesModel savedPlacesModel) {
        new DeleteSavedPlaceTask(savedPlacesDAO).execute(savedPlacesModel);
    }

    public void deleteAll_SavedPlaceTask() {
        new DeleteAllSavedPlacesTask(savedPlacesDAO).execute();
    }

    public LiveData<List<SavedPlacesModel>> getAllImages() {
        return allSavedPlaces;
    }







    private static class InsertSavedPlaceTask extends AsyncTask<SavedPlacesModel, Void, Void> {
        private final SavedPlacesDAO savedPlacesDAO;

        private InsertSavedPlaceTask(SavedPlacesDAO savedPlacesDAO) {
            this.savedPlacesDAO = savedPlacesDAO;
        }

        @Override
        protected Void doInBackground(SavedPlacesModel... savedPlacesModels) {
            savedPlacesDAO.insertNewPlace(savedPlacesModels[0]);
            return null;
        }
    }



    private static class UpdatedSavedPlaceTask extends AsyncTask<SavedPlacesModel, Void, Void> {
        private final SavedPlacesDAO savedPlacesDAO;

        private UpdatedSavedPlaceTask(SavedPlacesDAO savedPlacesDAO) {
            this.savedPlacesDAO = savedPlacesDAO;
        }

        @Override
        protected Void doInBackground(SavedPlacesModel... savedPlacesModels) {
            savedPlacesDAO.updateCurrentPlace(savedPlacesModels[0]);
            return null;
        }
    }



    private static class DeleteSavedPlaceTask extends AsyncTask<SavedPlacesModel, Void, Void> {
        private final SavedPlacesDAO savedPlacesDAO;

        private DeleteSavedPlaceTask(SavedPlacesDAO savedPlacesDAO) {
            this.savedPlacesDAO = savedPlacesDAO;
        }

        @Override
        protected Void doInBackground(SavedPlacesModel... savedPlacesModels) {
            savedPlacesDAO.deletePlace(savedPlacesModels[0]);
            return null;
        }
    }


    private static class DeleteAllSavedPlacesTask extends AsyncTask<SavedPlacesModel, Void, Void> {
        private final SavedPlacesDAO savedPlacesDAO;

        private DeleteAllSavedPlacesTask(SavedPlacesDAO savedPlacesDAO) {
            this.savedPlacesDAO = savedPlacesDAO;
        }

        @Override
        protected Void doInBackground(SavedPlacesModel... savedPlacesModels) {
            savedPlacesDAO.deleteAllSavedPlaces();
            return null;
        }
    }



}
