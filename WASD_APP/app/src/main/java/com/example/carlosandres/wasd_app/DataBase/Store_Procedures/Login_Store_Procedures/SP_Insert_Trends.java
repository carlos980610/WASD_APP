package com.example.carlosandres.wasd_app.DataBase.Store_Procedures.Login_Store_Procedures;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.carlosandres.wasd_app.DataBase.Data_Base_Management.Connection;
import com.example.carlosandres.wasd_app.DataBase.Data_Base_Management.DataBaseManager;
import com.example.carlosandres.wasd_app.DataBase.Definitions.Trend;
import com.example.carlosandres.wasd_app.DataBase.Definitions.User;
import com.example.carlosandres.wasd_app.DataBase.Entities.Trend_Entity;
import com.example.carlosandres.wasd_app.DataBase.Entities.User_Entity;

import java.util.List;

/**
 * Created by Carlos Andrés on 13/11/2017.
 */

public class SP_Insert_Trends {

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


    public SP_Insert_Trends(Context Get_App_Context) { //Class Constructor
        App_Context = Get_App_Context;
    }

    public boolean Insert_Trends (List<Trend_Entity> New_Trend_List){

        //Establish and open data base connection
        DataBaseManager DBManager = new DataBaseManager(App_Context);
        DBConnection = DBManager.OpenDataBase(App_Context);
        SQLDataBase = DBConnection.getWritableDatabase();

        for (Trend_Entity Trend_Definition_List: New_Trend_List){
            if (New_Trend_List != null){
                Long Check_New_User_Insert = SQLDataBase.insert(Trend.Trend_Table_Name, null, Content_Values_Trend(Trend_Definition_List));
                if (Check_New_User_Insert != -1){
                    Successful = true;
                }
            }
        }
        //Close data base connection
        try {
            DBManager.CloseDataBase(DBConnection);
        }catch (Exception exception){

        }
        return Successful;
    }




    public ContentValues Content_Values_Trend (Trend_Entity trend)
    {
        ContentValues values = new ContentValues();
        values.put(Trend.Trend_Title ,trend.Title_Trend);
        values.put(Trend.Trend_Content,trend.Content_Trend);
        return values;
    }
}
