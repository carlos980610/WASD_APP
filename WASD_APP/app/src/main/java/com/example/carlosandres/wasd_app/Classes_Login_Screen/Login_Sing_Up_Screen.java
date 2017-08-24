package com.example.carlosandres.wasd_app.Classes_Login_Screen;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.carlosandres.wasd_app.DataBase.Data_Base_Management.DataBaseManager;
import com.example.carlosandres.wasd_app.DataBase.Entities.User_Entity;
import com.example.carlosandres.wasd_app.R;

public class Login_Sing_Up_Screen extends AppCompatActivity {

    /** Declare variables**/

    //Receive data from form
    private String User_Name, User_Last_Name, User_NickName, User_Age, User_Email, User_Password, User_Cellphone;


    //Get app context
    Context App_Context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_sing_up_screen);


        /** Search values in activity xml**/


        //TextBox in Sing Up
        final EditText txtUser_Name = (EditText) findViewById(R.id.txtUserName);
        final EditText txtUser_Last_Name = (EditText) findViewById(R.id.txtUserLastName);
        final EditText txtUser_NickNAme = (EditText) findViewById(R.id.txtUserNickName);
        final EditText txtUser_Age = (EditText) findViewById(R.id.txtUserAge);
        final EditText txtUser_Email = (EditText) findViewById(R.id.txtUserEmail);
        final EditText txtUser_Password = (EditText) findViewById(R.id.txtUserPassword);
        final EditText txtUser_Cellphone = (EditText) findViewById(R.id.txtUserCellphone);

        //CheckBox to accept terms and conditions
        final CheckBox ckbAcceptConditions = (CheckBox) findViewById(R.id.ckbAcceptConditions);


        //SIng Up button
        final Button btnSingIn = (Button) findViewById(R.id.btnSingIn);
        btnSingIn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {


                if (ckbAcceptConditions.isChecked()){
                    try {
                        //Get Data
                        User_Name = txtUser_Name.getText().toString();
                        User_Last_Name = txtUser_Last_Name.getText().toString();
                        User_NickName = txtUser_NickNAme.getText().toString();
                        User_Age = txtUser_Age.getText().toString();
                        User_Email = txtUser_Email.getText().toString();
                        User_Password = txtUser_Password.getText().toString();
                        User_Cellphone = txtUser_Cellphone.getText().toString();


                        //Fill in ArrayList

                        User_Entity new_user = new User_Entity();
                        new_user.Id_User = User_Name;
                        new_user.Name= name.getText().toString();
                        new_user.Password= password.getText().toString();
                        new_user.Email= email.getText().toString();
                        new_user.Carrer=carrer.getSelectedItem().toString();
                        lstusers.add(user);



                    }catch (Exception exception){
                        Toast.makeText(getApplicationContext(), "No se ha logrado establecer la conexión, intentelo de nuevo más tarde", Toast.LENGTH_SHORT).show();

                    }
                }else{
                    Toast.makeText(getApplicationContext(), "No se han aceptado los terminos y condiciones de WASD", Toast.LENGTH_SHORT).show();
                }
                    Intent intent = new Intent(getApplicationContext(), Login_Main_Screen.class);
                    startActivity(intent);

            }
        });

    }



}
