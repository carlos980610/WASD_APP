package com.example.carlosandres.wasd_app.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by CarlosAndrés on 22/08/2017.
 */

public class Connection extends SQLiteOpenHelper {
    private  static final String DB_NAME="WASD_APP_SQLiteDataBase.sqlite";
    private static final  int DB_CHEMA_VERSION = 1;

    public Connection(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DB_NAME, null, DB_CHEMA_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        /* Crear tablas de la base de datos
        db.execSQL(DataBaseManager.CREATE_TABLE_USERS);
        db.execSQL(DataBaseManager.CREATE_TABLE_BOOKS);
        db.execSQL(DataBaseManager.CREATE_TABLE_CHANGE);
        */
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        /* Actualizar tablas de la base de datos si no estan creadas
        db.execSQL("DROP TABLE IF EXISTS " + DataBaseManager.CREATE_TABLE_USERS);
        db.execSQL("DROP TABLE IF EXISTS " + DataBaseManager.CREATE_TABLE_BOOKS);
        db.execSQL("DROP TABLE IF EXISTS " + DataBaseManager.CREATE_TABLE_CHANGE);
        onCreate(db);*/
    }
}
