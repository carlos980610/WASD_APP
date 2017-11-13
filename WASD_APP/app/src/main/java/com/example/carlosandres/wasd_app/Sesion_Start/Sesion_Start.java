package com.example.carlosandres.wasd_app.Sesion_Start;

import android.content.Context;
import android.widget.Toast;

import com.example.carlosandres.wasd_app.DataBase.Store_Procedures.Login_Store_Procedures.SP_Get_User_By_Email;

/**
 * Created by Carlos Andrés on 13/11/2017.
 */

public class Sesion_Start {

    public Context AppContext;
    public int User_Id;
    public String User_Email;

    public Sesion_Start(String email, Context context) {
        User_Email = email;
        AppContext = context;
        Get_User_By_Email();
    }


    public int Get_User_By_Email ()
    {
        SP_Get_User_By_Email SP_Get_User = new SP_Get_User_By_Email(AppContext);
        User_Id = SP_Get_User.Get_Id(User_Email);
        Toast.makeText(AppContext, "Id recibido: " + User_Id, Toast.LENGTH_SHORT).show();
        return User_Id;
    }
}
