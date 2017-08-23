package com.example.carlosandres.wasd_app.Classes_Login_Screen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.carlosandres.wasd_app.Classes_Main_Screen.Main_Main_Screen;
import com.example.carlosandres.wasd_app.R;

public class Login_Sing_In_Screen extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_sing_in_screen);

        final EditText User = (EditText) findViewById(R.id.txtUser);
        final EditText Pass = (EditText) findViewById(R.id.txtPassword);

        final Button btnLogIn = (Button) findViewById(R.id.btnSingIn);
        btnLogIn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(User.getText().toString().equals("") && Pass.getText().toString().equals("")){
                        Intent intent = new Intent (getApplicationContext(), Main_Main_Screen.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(getApplicationContext(), "Try Again...",Toast.LENGTH_SHORT).show();
                    }
                }
        });
    }
}
