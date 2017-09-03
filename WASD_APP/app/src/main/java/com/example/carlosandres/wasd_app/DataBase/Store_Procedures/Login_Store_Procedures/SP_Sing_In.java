package com.example.carlosandres.wasd_app.DataBase.Store_Procedures.Login_Store_Procedures;

import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;

import com.example.carlosandres.wasd_app.DataBase.Data_Base_Management.Connection;
import com.example.carlosandres.wasd_app.DataBase.Data_Base_Management.DataBaseManager;
import com.example.carlosandres.wasd_app.DataBase.Definitions.User;
import com.example.carlosandres.wasd_app.DataBase.Entities.User_Entity;

import java.util.ArrayList;

/**
 * Created by CarlosAndrés on 23/08/2017.
 */

public class SP_Sing_In {
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

    public SP_Sing_In(Context Get_App_Context) { //Class Constructor
        App_Context = Get_App_Context;
    }


    public boolean Sing_In_Procedure (String User_Email, String User_Password)
    {
        //Establish and open data base connection
        DataBaseManager DBManager = new DataBaseManager(App_Context);
        DBConnection = DBManager.OpenDataBase(App_Context);
        SQLDataBase = DBConnection.getWritableDatabase();
        try {
            DBQuery = "select " + User.User_Email + ", " + User.User_Password + " from " + User.User_Table_Name + " where " +User.User_Email+ "='" + User_Email +"' and " + User.User_Password + "='" + User_Password + "'";
            DBcursor = SQLDataBase.rawQuery(DBQuery, null);
            if (DBcursor != null){
                if (DBcursor.moveToFirst())
                {
                    do
                    {
                        Conection_Status = true;
                    }while (DBcursor.moveToNext());
                }
                if (!DBcursor.isClosed()) {
                    DBcursor.close();
                }
                if (Conection_Status){
                    Successful = true;
                }
            }
        }
        catch (Exception exception){
            Conection_Status = false;
            new AlertDialog.Builder(App_Context)
                    .setTitle("Error de conexión")
                    .setMessage("No se logró establecer una conexión con la base de datos, intentelo de nuevo")
                    .setCancelable(true)
                    .setPositiveButton("Intentar de nuevo", new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    })
                    .show();
        }
        DBManager.CloseDataBase(DBConnection);
        return Successful;
    }
}
