package com.example.carlosandres.wasd_app.Fragment_Control_Data.Fragment_Control_Publication_Data;

/**
 * Created by hp on 20/11/2017.
 */

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

import android.widget.BaseAdapter;

import com.example.carlosandres.wasd_app.DataBase.Entities.User_Entity;
import com.example.carlosandres.wasd_app.R;

public class User_Adapter_Main_Screen extends RecyclerView.Adapter<User_Adapter_Main_Screen.UserViewHolder>{

    private List<User_Main_Screen> items;

    public static class UserViewHolder extends RecyclerView.ViewHolder {

        public TextView NickName_User;
        public TextView Name_User;
        public TextView Last_Name_User;
        public TextView Age_User;
        public TextView Email_User;
        public ImageView Profile_User_Img;


        public UserViewHolder (View v){
            super(v);

            Profile_User_Img = (ImageView) v.findViewById(R.id.imageUser);
            Name_User = (TextView) v.findViewById(R.id.UserName);
            Last_Name_User = (TextView) v.findViewById(R.id.LastUserName);
            Age_User = (TextView) v.findViewById(R.id.ageUser);
            Email_User = (TextView) v.findViewById(R.id.EmailUser);
            NickName_User = (TextView) v.findViewById(R.id.NickName);
        }

    }

    public User_Adapter_Main_Screen(List<User_Main_Screen> items) {
        this.items = items;
    }

    @Override //Ok
    public int getItemCount(){
        return items.size();
    }

    @Override //Ok
    public User_Adapter_Main_Screen.UserViewHolder onCreateViewHolder(ViewGroup viewGroup, int i){

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.user_card, viewGroup, false);
        return new UserViewHolder(v);
    }
    @Override //Ok
    public void onBindViewHolder(UserViewHolder viewHolder, int i){

        viewHolder.Name_User.setText(items.get(i).getName_User());
        viewHolder.NickName_User.setText(items.get(i).getNickName_User());
        viewHolder.Last_Name_User.setText(items.get(i).getLast_Name_User());
        viewHolder.Age_User.setText(items.get(i).getAge_User());
        viewHolder.Email_User.setText(items.get(i).getEmail_User());

    }
}
