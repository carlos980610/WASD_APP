package com.example.carlosandres.wasd_app.Classes_Splash_Screen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import com.example.carlosandres.wasd_app.Classes_Login_Screen.Login_Main_Screen;
import com.example.carlosandres.wasd_app.Classes_Main_Screen.Main_Main_Screen;
import com.example.carlosandres.wasd_app.R;

public class Splash_Main_Screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);   //Se elimina el toolbar de la actividad de inicio.
        setContentView(R.layout.activity_splash_main_screen);


        Thread myThread = new Thread(){

            @Override
            public void run() {
                try {
                    sleep(1500);
                    Intent intent = new Intent(getApplicationContext(), Login_Main_Screen.class);
                    startActivity(intent);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        myThread.start();
    }
}
