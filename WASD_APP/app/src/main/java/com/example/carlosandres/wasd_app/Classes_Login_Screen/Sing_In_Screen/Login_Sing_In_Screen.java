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

import com.example.carlosandres.wasd_app.Classes_Main_Screen.Main_Main_Screen;
import com.example.carlosandres.wasd_app.Classes_Main_Screen.Main_Main_Screen;
import com.example.carlosandres.wasd_app.DataBase.Store_Procedures.Login_Store_Procedures.SP_Sing_In;
import com.example.carlosandres.wasd_app.Default_Process.Create_Default_Users;
import com.example.carlosandres.wasd_app.R;
import com.example.carlosandres.wasd_app.Sesion_Start.Sesion_Start;

public class Login_Sing_In_Screen extends AppCompatActivity {

    /**Declare variables**/
    //Variables for Sing In
    private String User_Email, User_Password;
    private boolean Keep_Logged_In = false;

    //Application context
    Context App_Context = this;

    //Cheked procedures
    boolean Cheked_Storage_Procedures = false;

    int temporal_id;

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


        final SP_Sing_In Sing_In_SP = new SP_Sing_In(App_Context);


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


                    Cheked_Storage_Procedures = Sing_In_SP.Sing_In_Procedure(User_Email, User_Password);
                    if (Cheked_Storage_Procedures){
                        Toast.makeText(getApplicationContext(), "Inicio de sesión realizada con exito", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), Main_Main_Screen.class);
                        startActivity(intent);

                        Sesion_Start SS = new Sesion_Start(User_Email, getApplicationContext());
                        temporal_id = SS.Get_User_By_Email();
                        Toast.makeText(getApplicationContext(), "Id a enviar: "  + temporal_id, Toast.LENGTH_SHORT).show();


                        Create_Default_Users cdu = new Create_Default_Users();
                        cdu.Create_Users("Juan","Perez","jp","23","j@g.c","1","3"); //User 1
                        cdu.Create_Users("Maria","Ochoa","mo","23","m@g.c","1","3"); //User 2
                        cdu.Create_Users("Pedro","Builes","pb","23","p@g.c","1","3"); //User 3


                    }else{

                    }
                    txt_User_Email.setText("");
                    txt_User_Password.setText("");

                }
        });
    }

    public int Set_Id (){
        return temporal_id + 1;
    }
}
