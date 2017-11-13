package com.example.carlosandres.wasd_app.DataBase.Store_Procedures.Login_Store_Procedures;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.carlosandres.wasd_app.DataBase.Data_Base_Management.Connection;
import com.example.carlosandres.wasd_app.DataBase.Data_Base_Management.DataBaseManager;
import com.example.carlosandres.wasd_app.DataBase.Definitions.User;

/**
 * Created by Carlos Andrés on 13/11/2017.
 */

public class SP_Get_User_By_Email {

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


    public int id;

    public SP_Get_User_By_Email(Context context) {
        App_Context = context;
    }

    public int Get_Id (String email) {
        //Establish and open data base connection
        DataBaseManager DBManager = new DataBaseManager(App_Context);
        DBConnection = DBManager.OpenDataBase(App_Context);
        SQLDataBase = DBConnection.getWritableDatabase();
        try {
            DBQuery = "select " + User.User_Id + " from " + User.User_Table_Name + " where " + User.User_Email + "='" + email + "'";
            DBcursor = SQLDataBase.rawQuery(DBQuery, null);
            if (DBcursor != null) {
                if (DBcursor.moveToFirst()) {
                    do {
                        Conection_Status = true;
                        id = DBcursor.getInt(0);
                    } while (DBcursor.moveToNext());
                }
                if (!DBcursor.isClosed()) {
                    DBcursor.close();
                }
                if (Conection_Status) {
                    Successful = true;
                }
            }
        }
        catch(Exception exception){

        }
        return id;
    }
}
