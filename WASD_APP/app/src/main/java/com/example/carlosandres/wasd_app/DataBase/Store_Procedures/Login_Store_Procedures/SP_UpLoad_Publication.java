package com.example.carlosandres.wasd_app.DataBase.Store_Procedures.Login_Store_Procedures;

import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;

import com.example.carlosandres.wasd_app.DataBase.Data_Base_Management.Connection;
import com.example.carlosandres.wasd_app.DataBase.Data_Base_Management.DataBaseManager;
import com.example.carlosandres.wasd_app.DataBase.Definitions.File_Image;
import com.example.carlosandres.wasd_app.DataBase.Definitions.User;

import java.sql.Blob;

/**
 * Created by Carlos Andrés on 30/10/2017.
 */

public class SP_UpLoad_Publication {

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

    public SP_UpLoad_Publication(Context Get_App_Context) {
        App_Context = Get_App_Context;
    }

    public boolean Save_Image_Procedure (byte[] image_publication){

        //Establish and open data base connection
        DataBaseManager DBManager = new DataBaseManager(App_Context);
        DBConnection = DBManager.OpenDataBase(App_Context);
        SQLDataBase = DBConnection.getWritableDatabase();
        try {
            DBQuery = "Insert into" + File_Image.File_Image_Table_Name + " Values " + image_publication;
            DBcursor = SQLDataBase.rawQuery(DBQuery, null);
            Successful = true;
        }
        catch (Exception exception){
            Conection_Status = false;
            new AlertDialog.Builder(App_Context)
                    .setTitle("Error de conexión al subir publicación")
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
