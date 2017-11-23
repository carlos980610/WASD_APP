package com.example.carlosandres.wasd_app.Fragment_Control_Data.Fragment_Control_Publication_Data;

/**
 * Created by hp on 21/11/2017.
 */

public class User_Main_Screen {

    private String Name_User;
    private String Last_Name_User;
    private String NickName_User;
    private String Age_User;
    private String Email_User;

    public User_Main_Screen(String Name_User, String Last_Name_User, String NickName_User, String Age_User, String Email_User){

        this.Name_User = Name_User;
        this.Last_Name_User = Last_Name_User;
        this.NickName_User = NickName_User;
        this.Age_User = Age_User;
        this.Email_User = Email_User;

    }

    public String getName_User() {
        return Name_User;
    }

    public String getLast_Name_User() {
        return Last_Name_User;
    }

    public String getNickName_User() {
        return NickName_User;
    }

    public String getAge_User() {
        return Age_User;
    }

    public String getEmail_User() {
        return Email_User;
    }
}
