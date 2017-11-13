package com.example.carlosandres.wasd_app.DataBase.Store_Procedures.Login_Store_Procedures;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.carlosandres.wasd_app.DataBase.Data_Base_Management.Connection;
import com.example.carlosandres.wasd_app.DataBase.Data_Base_Management.DataBaseManager;
import com.example.carlosandres.wasd_app.DataBase.Definitions.User;

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
}
