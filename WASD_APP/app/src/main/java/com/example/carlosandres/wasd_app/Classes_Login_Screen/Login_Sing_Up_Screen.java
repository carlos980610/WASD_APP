package com.example.carlosandres.wasd_app.Classes_Login_Screen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

import com.example.carlosandres.wasd_app.Classes_Main_Screen.Main_Main_Screen;
import com.example.carlosandres.wasd_app.R;

public class Login_Sing_Up_Screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_sing_up_screen);


        final Button btnSingIn = (Button) findViewById(R.id.btnSingIn);
        btnSingIn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                    Intent intent = new Intent (getApplicationContext(), Login_Main_Screen.class);
                    startActivity(intent);

            }
        });

    }



}
