package com.example.imransk.roomdatabase;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface User_DAO {
    @Insert
    long insert_User(UserInformation userInformation);

    @Query("select * from UserInformation")
    List<UserInformation>getALlUserInformation();

    @Query("select * from UserInformation")
    LiveData<List<UserInformation>>getALl_Live_User();

    @Query("Select * from UserInformation where id like:id")
    UserInformation getUserByID(int id);

    @Update
    int update_User(UserInformation userInformation);

    @Delete
    int delete_User(UserInformation userInformation);

    @Query("DELETE FROM UserInformation WHERE id like :id")
    int delete_User_by_id(int id);

    @Query("delete from UserInformation")
    void delete_All();



}
