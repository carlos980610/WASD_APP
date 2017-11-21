package com.example.carlosandres.wasd_app.DataBase.Store_Procedures.Login_Store_Procedures;

import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import com.example.carlosandres.wasd_app.DataBase.Data_Base_Management.Connection;
import com.example.carlosandres.wasd_app.DataBase.Data_Base_Management.DataBaseManager;
import com.example.carlosandres.wasd_app.DataBase.Definitions.File_Image;
import com.example.carlosandres.wasd_app.DataBase.Definitions.User;

/**
 * Created by CarlosAndrés on 21/11/2017.
 */

public class SP_Check_Insert_Image {



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


    String image_url;



    public SP_Check_Insert_Image(Context App_Con) {
        this.App_Context = App_Con;
    }

    public boolean getImageUrl (){
        //Establish and open data base connection
        DataBaseManager DBManager = new DataBaseManager(App_Context);
        DBConnection = DBManager.OpenDataBase(App_Context);
        SQLDataBase = DBConnection.getWritableDatabase();
        try {
            DBQuery = "select " + File_Image.Img_Publication + " from " + File_Image.File_Image_Table_Name;
            DBcursor = SQLDataBase.rawQuery(DBQuery, null);
            if (DBcursor != null){
                if (DBcursor.moveToFirst())
                {
                    do
                    {
                        image_url = DBcursor.getString(0);
                        Toast.makeText(App_Context, "URL get: " + image_url, Toast.LENGTH_SHORT).show();
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
