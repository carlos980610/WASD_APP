package com.example.carlosandres.wasd_app.DataBase.Store_Procedures.Login_Store_Procedures;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ArrayAdapter;

import com.example.carlosandres.wasd_app.DataBase.Data_Base_Management.Connection;
import com.example.carlosandres.wasd_app.DataBase.Data_Base_Management.DataBaseManager;
import com.example.carlosandres.wasd_app.DataBase.Definitions.User;
import com.example.carlosandres.wasd_app.DataBase.Entities.User_Entity;

import java.util.ArrayList;
import java.util.List;

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

    //Checked procedure
    boolean Successful = false; //Checked correct sing up


    public SP_Sing_Up(Context Get_App_Context) { //Class Constructor
        App_Context = Get_App_Context;

    }

    public boolean Sing_Up_Procedure (List<User_Entity> New_User_List){

        //Establish and open data base connection
        DataBaseManager DBManager = new DataBaseManager(App_Context);
        DBConnection = DBManager.OpenDataBase(App_Context);
        SQLDataBase = DBConnection.getWritableDatabase();

        for (User_Entity User_Definition_List: New_User_List){
            if (New_User_List != null){
                Long Check_New_User_Insert = SQLDataBase.insert(User.User_Table_Name, null, Content_Values_User(User_Definition_List));
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


    public ContentValues Content_Values_User(User_Entity user)
    {
        ContentValues values = new ContentValues();
        values.put(User.User_Name ,user.Name_User);
        values.put(User.User_Last_Name,user.Last_Name_User);
        values.put(User.User_Nick_Name,user.NickName_User);
        values.put(User.User_Age,user.Age_User);
        values.put(User.User_Email,user.Email_User);
        values.put(User.User_Password,user.Password_User);
        values.put(User.User_Cellphone,user.CellPhone_User);
        return values;
    }
}
