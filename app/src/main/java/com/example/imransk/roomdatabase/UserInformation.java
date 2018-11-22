package com.example.imransk.roomdatabase;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class UserInformation {

    @PrimaryKey(autoGenerate = true)
    int id;
    @ColumnInfo(name = "user_email_column")
    String email;
    String password;

    @Ignore
    public UserInformation(String email, String password, int id) {
        this.email = email;
        this.password = password;
        this.id = id;
    }

    public UserInformation(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getemail() {
        return email;
    }

    public void setemail(String name) {
        this.email = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
