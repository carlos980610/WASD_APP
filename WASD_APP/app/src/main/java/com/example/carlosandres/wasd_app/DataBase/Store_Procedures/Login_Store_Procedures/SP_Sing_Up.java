package com.example.carlosandres.wasd_app.DataBase.Store_Procedures.Login_Store_Procedures;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ArrayAdapter;

import com.example.carlosandres.wasd_app.DataBase.Data_Base_Management.Connection;
import com.example.carlosandres.wasd_app.DataBase.Data_Base_Management.DataBaseManager;
import com.example.carlosandres.wasd_app.DataBase.Definitions.User;
import com.example.carlosandres.wasd_app.DataBase.Entities.User_Entity;

import java.util.ArrayList;

/**
 * Created by CarlosAndrés on 23/08/2017.
 */

public class SP_Sing_Up {

    /** Declare Variables **/
    //Context
    Context App_Context;
    //ArrayList
    ArrayList<User_Entity> New_User;

    //Data Base connection
    private Connection DBConnection;
    private SQLiteDatabase SQLDataBase;


    public SP_Sing_Up(Context Get_App_Context, ArrayList <User_Entity> New_User_List) {
        App_Context = Get_App_Context;
        New_User = New_User_List;

    }

    private void Add_New_User (){

        //Establish and open data base connection
        DataBaseManager DBManager = new DataBaseManager(App_Context);
        DBConnection = new Connection(App_Context);
        SQLDataBase = DBConnection.getWritableDatabase();




        //Close data base connection
        DBConnection.Close();

    }
}
