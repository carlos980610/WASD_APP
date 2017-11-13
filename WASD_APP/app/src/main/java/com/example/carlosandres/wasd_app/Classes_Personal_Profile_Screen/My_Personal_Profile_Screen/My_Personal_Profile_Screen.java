package com.example.carlosandres.wasd_app.Classes_Personal_Profile_Screen.My_Personal_Profile_Screen;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.example.carlosandres.wasd_app.Classes_Login_Screen.Sing_In_Screen.Login_Sing_In_Screen;
import com.example.carlosandres.wasd_app.DataBase.Data_Base_Management.Connection;
import com.example.carlosandres.wasd_app.DataBase.Store_Procedures.Login_Store_Procedures.SP_Get_User_Data;
import com.example.carlosandres.wasd_app.R;
import com.example.carlosandres.wasd_app.Sesion_Start.Sesion_Start;

public class My_Personal_Profile_Screen extends AppCompatActivity {

    int id;
    String name, nickname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_personal_profile_screen);


        final TextView lbl_User_Name = (TextView) findViewById(R.id.lblUserName_P);
        final TextView lbl_User_NickName = (TextView) findViewById(R.id.lblNickName_P);


        Login_Sing_In_Screen LS = new Login_Sing_In_Screen();
        id = LS.Set_Id();

        SP_Get_User_Data GUD = new SP_Get_User_Data(getApplicationContext());
        name = GUD.Get_Name(id);
        nickname =GUD.Get_NickName(id);

        lbl_User_Name.setText(name);
        lbl_User_NickName.setText(nickname);

    }
}
