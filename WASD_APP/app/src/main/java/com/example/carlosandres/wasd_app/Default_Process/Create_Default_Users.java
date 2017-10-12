package com.example.carlosandres.wasd_app.Default_Process;

import com.example.carlosandres.wasd_app.DataBase.Entities.User_Entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Carlos Andrés on 11/10/2017.
 */

public class Create_Default_Users {
    private String User_Name, User_Last_Name, User_NickName, User_Age, User_Email, User_Password, User_Cellphone;

    public Create_Default_Users() {

    }

    public void Create_Users (String n, String ln, String nn, String a, String e,String p,String c){

        User_Name = n;
        User_Last_Name = ln;
        User_NickName = nn;
        User_Age = a;
        User_Email = e;
        User_Password = p;
        User_Cellphone = c;

        //Fill in ArrayList
        List<User_Entity> List_New_User = new ArrayList<>();

        User_Entity new_user = new User_Entity();
        new_user.Name_User = User_Name;
        new_user.Last_Name_User = User_Last_Name;
        new_user.Password_User= User_Password;
        new_user.Email_User= User_Email;
        new_user.NickName_User = User_NickName;
        new_user.Age_User = User_Age;
        new_user.CellPhone_User = User_Cellphone;
        List_New_User.add(new_user);
    }
}
