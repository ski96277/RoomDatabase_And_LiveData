package com.example.imransk.roomdatabase;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class AdapterClass extends BaseAdapter {

    List<UserInformation> userInformations;
    Context context;

    public AdapterClass(List<UserInformation> userInformations, Context context) {
        this.userInformations = userInformations;
        this.context = context;
    }

    @Override
    public int getCount() {
        return userInformations.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        view = layoutInflater.inflate(R.layout.item, null);
        TextView textView = view.findViewById(R.id.textView_ID);
        TextView textView_serial = view.findViewById(R.id.textView2_serial_ID);

        textView_serial.setText(String.valueOf(userInformations.get(i).getId()));
        textView.setText(userInformations.get(i).getemail());
        view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

//delete user using user information

                /*UserInformation userInformation = new UserInformation(userInformations.get(i).getemail(),
                        userInformations.get(i).getPassword(), userInformations.get(i).getId());
                UserDatabase.getInstance(context).getUser_Dao().delete_User(userInformation);*/

//delete user using user id
                UserDatabase.getInstance(context).getUser_Dao().delete_User_by_id(userInformations.get(i).getId());

                Toast.makeText(context, "Deleted", Toast.LENGTH_SHORT).show();

//Not need this if you use live data
                /*context.startActivity(new Intent(context, MainActivity.class));

                ((Activity) context).finish();*/
                return true;
            }
        });
        
        return view;
    }
}
