package com.example.carlosandres.wasd_app.DataBase.Data_Base_Management;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.carlosandres.wasd_app.DataBase.Definitions.Comment;
import com.example.carlosandres.wasd_app.DataBase.Definitions.File_Gif;
import com.example.carlosandres.wasd_app.DataBase.Definitions.File_Image;
import com.example.carlosandres.wasd_app.DataBase.Definitions.File_Video;
import com.example.carlosandres.wasd_app.DataBase.Definitions.Personal_Chat;
import com.example.carlosandres.wasd_app.DataBase.Definitions.Personal_Chat_Message;
import com.example.carlosandres.wasd_app.DataBase.Definitions.Publication;
import com.example.carlosandres.wasd_app.DataBase.Definitions.User;

/**
 * Created by CarlosAndrés on 22/08/2017.
 */

public class DataBaseManager {


    /** Declare variables**/
    private Connection connection; //Variable with the connection to data base
    private SQLiteDatabase database; //Variable with thee data base in general


    /** Create tables in DataBase **/



    //Create tblUser - Ok
    public static final String Create_Table_User = "CREATE TABLE IF NOT EXISTS " + User.User_Table_Name + "(" +
            User.User_Id + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            User.User_Name + " TEXT, " +
            User.User_Last_Name + " TEXT, " +
            User.User_Nick_Name + " TEXT, " +
            User.User_Age + " TEXT, " +
            User.User_Email + " TEXT, " +
            User.User_Cellphone + " TEXT);";


    //Create tblPublication
    public static final String Create_Table_Publication = "CREATE TABLE IF NOT EXISTS " + Publication.Publication_Table_Name + "(" +
            Publication.Publication_Id + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            Publication.Publication_Nick_Name + " TEXT, " +
            Publication.Publication_DataTime + " TEXT, " +
            Publication.Publication_Id_File_Publication + " TEXT);";


    //Create tblComment
    public static final String Create_Table_Comment = "CREATE TABLE IF NOT EXISTS " + Comment.Publication_Table_Name + "(" +
            Comment.Comment_Id + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            Comment.Comment_User_Comment + " TEXT, " +
            Comment.Comment_DataTime + " TEXT, " +
            Comment.Comment_Content + " TEXT, " +
            Comment.Comment_Id_Publication + " TEXT);";

    //Create tblPersonalChat
    public static final String Create_Table_Personal_Chat = "CREATE TABLE IF NOT EXISTS " + Personal_Chat.Publication_Table_Name + "(" +
            Personal_Chat.Personal_Chat_Id + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            Personal_Chat.Personal_Chat_Id_User_1 + " TEXT, " +
            Personal_Chat.Personal_Chat_Id_User_2 + " TEXT);";

    //Create tblPersonalChatMessage
    public static final String Create_Table_Personal_Chat_Message = "CREATE TABLE IF NOT EXISTS " + Personal_Chat_Message.Publication_Table_Name + "(" +
            Personal_Chat_Message.Message_Personal_Chat_Id + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            Personal_Chat_Message.Message_Personal_Owner_Message + " TEXT, " +
            Personal_Chat_Message.Message_Personal_Id_Personal_Chat_Message + " TEXT, " +
            Personal_Chat_Message.Message_Personal_Content_Message + " TEXT);";

    //Create tblFile_Gif
    public static final String Create_Table_File_Gif = "CREATE TABLE IF NOT EXISTS " + File_Gif.File_Gif_Table_Name + "(" +
            File_Gif.Gif_Id_File_Publication + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            File_Gif.Gif_Publication + " TEXT);";

    //Create tblFile_Video
    public static final String Create_Table_File_Video = "CREATE TABLE IF NOT EXISTS " + File_Video.File_Video_Table_Name + "(" +
            File_Video.Vid_Id_File_Publication + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            File_Video.Vid_Publication + " TEXT);";

    //Create tblFile_Image
    public static final String Create_Table_File_Image = "CREATE TABLE IF NOT EXISTS " + File_Image.File_Image_Table_Name + "(" +
            File_Image.Img_Id_File_Publication + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            File_Image.Img_Publication + " TEXT);";









    /** Manage Data Base **/
    //Constructor Method
    public DataBaseManager (Context context) {
        connection = new Connection(context);
        database = connection.getWritableDatabase();
    }
/*
    //Method to open data base
    public void OpenDataBase (Context context){
        connection = new Connection(context);
        connection.getWritableDatabase();
    }

    //Method to close data base
    public void OpenDataBase (Context context){
        connection = new Connection(context);
        connection.getWritableDatabase();
    }*/













    /**Login Methods**/

    /**Publications Methods**/

    /**Profile Methods**/



}

