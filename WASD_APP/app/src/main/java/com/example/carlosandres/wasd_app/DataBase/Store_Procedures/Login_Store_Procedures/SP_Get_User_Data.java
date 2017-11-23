package com.example.carlosandres.wasd_app.DataBase.Store_Procedures.Login_Store_Procedures;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.carlosandres.wasd_app.DataBase.Data_Base_Management.Connection;
import com.example.carlosandres.wasd_app.DataBase.Data_Base_Management.DataBaseManager;
import com.example.carlosandres.wasd_app.DataBase.Definitions.User;
import com.example.carlosandres.wasd_app.Fragment_Control_Data.Fragment_Control_Publication_Data.User_Main_Screen;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Carlos Andrés on 13/11/2017.
 */

public class SP_Get_User_Data {

    /** Declare Variables **/
    //Context
    Context App_Context;

    //Cursor of data base
    Cursor DBcursor;

    //String with query
    String DBQuery;

    //Data Base connection
    private Connection DBConnection;
    private SQLiteDatabase SQLDataBase;
    private boolean Conection_Status = false; //Estado de la conexión

    //Checked procedure
    boolean Successful = false; //Checked correct sing in



    String name, nickname;

    public SP_Get_User_Data(Context context) {
        App_Context = context;
    }


    public String Get_Name (int id){

        DataBaseManager DBManager = new DataBaseManager(App_Context);
        DBConnection = DBManager.OpenDataBase(App_Context);
        SQLDataBase = DBConnection.getWritableDatabase();
        try {
            DBQuery = "select " + User.User_Name + " from " + User.User_Table_Name + " where " + User.User_Id + "='" + id + "'";
            DBcursor = SQLDataBase.rawQuery(DBQuery, null);
            if (DBcursor != null) {
                if (DBcursor.moveToFirst()) {
                    do {
                        Conection_Status = true;
                        name = DBcursor.getString(0);
                    } while (DBcursor.moveToNext());
                }
            }
        }
        catch(Exception exception){

        }
        return name;
    }



    public String Get_NickName (int id){

        DataBaseManager DBManager = new DataBaseManager(App_Context);
        DBConnection = DBManager.OpenDataBase(App_Context);
        SQLDataBase = DBConnection.getWritableDatabase();
        try {
            DBQuery = "select " + User.User_Nick_Name + " from " + User.User_Table_Name + " where " + User.User_Id + "='" + id + "'";
            DBcursor = SQLDataBase.rawQuery(DBQuery, null);
            if (DBcursor != null) {
                if (DBcursor.moveToFirst()) {
                    do {
                        Conection_Status = true;
                        nickname = DBcursor.getString(0);
                    } while (DBcursor.moveToNext());
                }
            }
        }
        catch(Exception exception){

        }
        return nickname;
    }

    public List<User_Main_Screen> Get_User_Data(){

        List<User_Main_Screen> item = new ArrayList<User_Main_Screen>();
        String Name_User = "";
        String Last_Name_User = "";
        String NickName_User = "";
        String Age_User = "";
        String Email_User = "";

        //int i=0;

        DataBaseManager DBManager = new DataBaseManager(App_Context);
        DBConnection = DBManager.OpenDataBase(App_Context);
        SQLDataBase = DBConnection.getWritableDatabase();
        try {
            DBQuery = "select " + User.User_Nick_Name + "," + User.User_Name + "," + User.User_Last_Name + "," + User.User_Age + "," + User.User_Email + " from " + User.User_Table_Name;
            DBcursor = SQLDataBase.rawQuery(DBQuery, null);
            if (DBcursor != null) {
                if (DBcursor.moveToFirst()) {
                    do {
                        Conection_Status = true;
                        NickName_User = DBcursor.getString(0);
                        Name_User = DBcursor.getString(1);
                        Last_Name_User = DBcursor.getString(2);
                        Age_User = DBcursor.getString(3);
                        Email_User = DBcursor.getString(4);
                        item.add(new User_Main_Screen(NickName_User, Name_User, Last_Name_User, Age_User, Email_User));

                    } while (DBcursor.moveToNext());
                }
            }
        }
        catch(Exception exception){

        }

        //item.add(new User_Main_Screen(NickName_User, Name_User, Last_Name_User, Age_User, Email_User));

        return item;
    }
}
