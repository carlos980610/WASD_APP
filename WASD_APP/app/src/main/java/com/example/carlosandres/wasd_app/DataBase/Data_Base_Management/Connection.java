package com.example.carlosandres.wasd_app.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by CarlosAndrés on 22/08/2017.
 */

public class Connection extends SQLiteOpenHelper {
    private  static final String DataBase_Name = "WASD_APP_SQLiteDataBase.sqlite";
    private static final  int DataBase_Chema_Version = 1;

    public Connection(Context context) {
        super(context, DataBase_Name, null, DataBase_Chema_Version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        /** Crear tablas de la base de datos **/
        //User table create
        db.execSQL(DataBaseManager.Create_Table_User);
        //Publication and Comment table create
        db.execSQL(DataBaseManager.Create_Table_Publication);
        db.execSQL(DataBaseManager.Create_Table_Comment);
        //Personal Chat table create
        db.execSQL(DataBaseManager.Create_Table_Personal_Chat);
        db.execSQL(DataBaseManager.Create_Table_Personal_Chat_Message);
        //Publication Files table create
        db.execSQL(DataBaseManager.Create_Table_File_Image);
        db.execSQL(DataBaseManager.Create_Table_File_Video);
        db.execSQL(DataBaseManager.Create_Table_File_Gif);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        /** Actualizar tablas de la base de datos si no estan creadas **/
        //User table update
        db.execSQL("DROP TABLE IF EXISTS " + DataBaseManager.Create_Table_User);
        //Publication and Comment table update
        db.execSQL("DROP TABLE IF EXISTS " + DataBaseManager.Create_Table_Publication);
        db.execSQL("DROP TABLE IF EXISTS " + DataBaseManager.Create_Table_Comment);
        //Personal Chat update
        db.execSQL("DROP TABLE IF EXISTS " + DataBaseManager.Create_Table_Personal_Chat);
        db.execSQL("DROP TABLE IF EXISTS " + DataBaseManager.Create_Table_Personal_Chat_Message);
        //Publication Files table update
        db.execSQL("DROP TABLE IF EXISTS " + DataBaseManager.Create_Table_File_Image);
        db.execSQL("DROP TABLE IF EXISTS " + DataBaseManager.Create_Table_File_Video);
        db.execSQL("DROP TABLE IF EXISTS " + DataBaseManager.Create_Table_File_Gif);
        //Execute update process
        onCreate(db);
    }
}
