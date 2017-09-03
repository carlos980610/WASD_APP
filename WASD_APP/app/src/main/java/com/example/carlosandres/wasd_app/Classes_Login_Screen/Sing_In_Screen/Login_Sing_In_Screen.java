package com.example.carlosandres.wasd_app.Classes_Login_Screen.Sing_In_Screen;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.carlosandres.wasd_app.Classes_Login_Screen.Main_Login_Screen.Login_Main_Screen;
import com.example.carlosandres.wasd_app.Classes_Main_Screen.Main_Main_Screen;
import com.example.carlosandres.wasd_app.DataBase.Entities.User_Entity;
import com.example.carlosandres.wasd_app.DataBase.Store_Procedures.Login_Store_Procedures.SP_Sing_In;
import com.example.carlosandres.wasd_app.R;

public class Login_Sing_In_Screen extends AppCompatActivity {

    /**Declare variables**/
    //Variables for Sing In
    private String User_Email, User_Password;
    private boolean Keep_Logged_In = false;

    //Application context
    Context App_Context = this;

    //Cheked procedures
    boolean Cheked_Storage_Procedures = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_sing_in_screen);

        /** Search values in activity xml**/
        //TextBox in Sing Up
        final EditText txt_User_Email = (EditText) findViewById(R.id.txtUserEmail);
        final EditText txt_User_Password = (EditText) findViewById(R.id.txtUserPassword);

        //CheckBox to keep logged in
        final CheckBox ckbKeepLoggedIn = (CheckBox) findViewById(R.id.ckbKeepLoggedIn);


        final SP_Sing_In Sing_Ip_SP = new SP_Sing_In(App_Context);


        final Button btnLogIn = (Button) findViewById(R.id.btnSingIn);
        btnLogIn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //Get values from textbox
                    User_Email = txt_User_Email.getText().toString();
                    User_Password = txt_User_Password.getText().toString();

                    if (ckbKeepLoggedIn.isChecked()){
                        Keep_Logged_In = true;
                    }


                    Cheked_Storage_Procedures = Sing_Ip_SP.Sing_In_Procedure(User_Email, User_Password);
                    if (Cheked_Storage_Procedures){
                        Toast.makeText(getApplicationContext(), "Inicio de sesión realizada con exito", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), Main_Main_Screen.class);
                        startActivity(intent);
                    }else{

                    }
                }
        });
    }
}
