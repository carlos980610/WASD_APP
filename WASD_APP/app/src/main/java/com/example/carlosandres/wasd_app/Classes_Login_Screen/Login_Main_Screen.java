package com.example.carlosandres.wasd_app.Classes_Login_Screen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.carlosandres.wasd_app.R;

public class Login_Main_Screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_main_screen);

        final Button btnLogIn = (Button) findViewById(R.id.btnSingIn);
        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (getApplicationContext(), Login_Sing_In_Screen.class);
                startActivity(intent);
            }
        });

        final Button btnSingUp = (Button) findViewById(R.id.btnSingUp);
        btnSingUp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent (getApplicationContext(), Login_Sing_Up_Screen.class);
                startActivity(intent);
            }

        });
    }
}
