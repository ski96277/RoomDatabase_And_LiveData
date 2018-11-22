package com.example.imransk.roomdatabase;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {UserInformation.class}, version = 1)
public abstract class UserDatabase extends RoomDatabase {

    private static UserDatabase db;

    //get referance of DAO class
    public abstract User_DAO getUser_Dao();

    public static UserDatabase getInstance(Context context) {
        if (db != null) {
            return db;
        } else {

            db = Room.databaseBuilder(context, UserDatabase.class, "user_DB")
                    .allowMainThreadQueries()
                    .build();
            return db;
        }
    }
}
