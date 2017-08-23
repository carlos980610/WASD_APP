package com.example.carlosandres.wasd_app.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by CarlosAndrés on 22/08/2017.
 */

public class DataBaseManager {


    /** Declare variables**/
    private Connection connection; //Variable with the connection to data base
    private SQLiteDatabase database; //Variable with thee data base in general


    /** Create tables in DataBase **/
/*
    //Create tblUser
    public static final String CREATE_TABLE_USERS = "CREATE TABLE IF NOT EXISTS " + Users.TABLE_NAME_USERS + "(" +
            Users.CN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            Users.CN_IdCard + " TEXT, " +
            Users.CN_Name + " TEXT, " +
            Users.CN_Password + " TEXT, " +
            Users.CN_Carrer + " TEXT, " +
            Users.CN_Email + " TEXT);";*/

    /** Manage Data Base **/
    //Constructor Method
 /*   public DataBaseManager (Context context) {
        connection = new Connection(context);
        database = connection.getWritableDatabase();
    }

 /*   //Method to open data base
  /*  public void OpenDataBase (Context context){
        connection = new Connection(context);
        connection.getWritableDatabase();
    }*/

    //Method to close data base
  /*  public void OpenDataBase (Context context){
        connection = new Connection(context);
        connection.getWritableDatabase();
    }
*/



    /**Login Methods**/

    /**Publications Methods**/

    /**Profile Methods**/



}

