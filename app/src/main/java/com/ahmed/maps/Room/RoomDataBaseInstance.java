package com.ahmed.maps.Room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = {SavedPlacesModel.class},version = 2,exportSchema = false)
@TypeConverters({Converters.class})
public  abstract class RoomDataBaseInstance extends RoomDatabase {

    private static RoomDataBaseInstance dataBaseinstance;


    public abstract SavedPlacesDAO savedPlacesDAO();



    public static synchronized RoomDataBaseInstance getInstance(Context context){
        if (dataBaseinstance == null){
            dataBaseinstance = Room.databaseBuilder(context.getApplicationContext(),
                    RoomDataBaseInstance.class,"RoomDataBase")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return dataBaseinstance;
    }
}
