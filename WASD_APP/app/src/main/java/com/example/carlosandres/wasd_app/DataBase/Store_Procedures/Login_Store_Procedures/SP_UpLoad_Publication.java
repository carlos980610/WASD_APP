package com.example.carlosandres.wasd_app.DataBase.Store_Procedures.Login_Store_Procedures;

import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;

import com.example.carlosandres.wasd_app.DataBase.Data_Base_Management.Connection;
import com.example.carlosandres.wasd_app.DataBase.Data_Base_Management.DataBaseManager;
import com.example.carlosandres.wasd_app.DataBase.Definitions.File_Image;
import com.example.carlosandres.wasd_app.DataBase.Definitions.User;
import com.example.carlosandres.wasd_app.DataBase.Entities.Image_File_Publication;
import com.example.carlosandres.wasd_app.DataBase.Entities.User_Entity;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

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

    public boolean Save_Image_Procedure (List<Image_File_Publication> image_publication){

        /*List<Image_File_Publication> List_New_Img_Public = new ArrayList<>();

        Image_File_Publication new_img_publ = new Image_File_Publication();
        new_img_publ.File_Publication = image_publication;
        List_New_Img_Public.add(new_img_publ);*/

        //Establish and open data base connection
        DataBaseManager DBManager = new DataBaseManager(App_Context);
        DBConnection = DBManager.OpenDataBase(App_Context);
        SQLDataBase = DBConnection.getWritableDatabase();
        try {

            for (Image_File_Publication Img_Publication_List: image_publication){
                if (image_publication != null){
                    Long Check_New_User_Insert = SQLDataBase.insert(File_Image.File_Image_Table_Name, null, Content_Values_Publication(Img_Publication_List));
                    if (Check_New_User_Insert != -1){
                        Successful = true;
                    }
                }
            }

            /*DBQuery = "Insert into " + File_Image.File_Image_Table_Name + " Values " + image_publication;
            SQLDataBase.insert(File_Image.Img_Publication, null, Content_Values_Publication(image_publication));
            //DBcursor = SQLDataBase.rawQuery(DBQuery, null);
            Successful = true;*/
        }
        catch (Exception exception){
            Conection_Status = false;
            new AlertDialog.Builder(App_Context)
                    .setTitle("Error de conexión al subir publicación")
                    .setMessage("No se logró establecer una conexión con la base de datos, intentelo de nuevo" + exception)
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

    public ContentValues Content_Values_Publication(Image_File_Publication Img)
    {
        ContentValues values = new ContentValues();
        values.put(File_Image.Img_Publication ,Img.File_Publication);
        return values;
    }
}
