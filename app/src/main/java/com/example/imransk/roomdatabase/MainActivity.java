package com.example.imransk.roomdatabase;

import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private android.widget.EditText emailETID;
    private android.widget.EditText passETID;
    private ListView listView;
    AdapterClass adapter;

    List<UserInformation> userInformations = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.passETID = (EditText) findViewById(R.id.pass_ET_ID);
        this.emailETID = (EditText) findViewById(R.id.email_ET_ID);
        listView = findViewById(R.id.list_view_ID);

        getAlluser();

    }

    void getAlluser() {
       /* userInformations=UserDatabase.getInstance(this).getUser_Dao().getALlUserInformation();
        Toast.makeText(this, ""+userInformations.size(), Toast.LENGTH_SHORT).show();*/

        UserDatabase.getInstance(this).getUser_Dao().getALl_Live_User().observe(this, new Observer<List<UserInformation>>() {
            @Override
            public void onChanged(@Nullable List<UserInformation> userInformations) {

                adapter = new AdapterClass(userInformations, MainActivity.this);

                listView.setAdapter(adapter);
            }
        });

    }

    public void submitInformation(View view) {

        String email = emailETID.getText().toString();
        String password = passETID.getText().toString();
        UserInformation userInformation = new UserInformation(email, password);

        long inserted_row = UserDatabase.getInstance(this).getUser_Dao().insert_User(userInformation);
        if (inserted_row > 0) {
            Toast.makeText(this, "save", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "failed", Toast.LENGTH_SHORT).show();
        }
//        getAlluser();

    }

    public void Delete_all(View view) {

        UserDatabase.getInstance(MainActivity.this).getUser_Dao().delete_All();
        Toast.makeText(this, "ALL deleted", Toast.LENGTH_SHORT).show();
//        startActivity(new Intent(this, MainActivity.class));

    }

}
