package com.example.carlosandres.wasd_app.Support_Classes;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

import com.example.carlosandres.wasd_app.Classes_Login_Screen.Sing_In_Screen.Login_Sing_In_Screen;
import com.example.carlosandres.wasd_app.R;

public class support_screen extends AppCompatActivity {

    String url;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support_screen);

        final Button btnFace = (Button) findViewById(R.id.btnFace);
        btnFace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                url = "https://www.facebook.com/";
                i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
                Toast.makeText(getApplicationContext(), "Redireccionando a Facebook", Toast.LENGTH_SHORT).show();

            }
        });

        final Button btnGmail = (Button) findViewById(R.id.btnGmail);
        btnGmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                url = "https://accounts.google.com/signin/v2/identifier?hl=ES&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
                i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
                Toast.makeText(getApplicationContext(), "Redireccionando a Gmail", Toast.LENGTH_SHORT).show();

            }
        });

        final Button btnGit = (Button) findViewById(R.id.btnGit);
        btnGit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                url = "https://github.com/";
                i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
                Toast.makeText(getApplicationContext(), "Redireccionando a GitHub", Toast.LENGTH_SHORT).show();

            }
        });


        final Switch swhPrivacity = (Switch) findViewById(R.id.swhPrivacity);
        swhPrivacity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (swhPrivacity.isChecked()) {
                    swhPrivacity.setText("Pública");
                    Toast.makeText(getApplicationContext(), "Cambió la privacidad a pública", Toast.LENGTH_SHORT).show();
                } else {
                    swhPrivacity.setText("Privada");
                    Toast.makeText(getApplicationContext(), "Cambió la privacidad a privada", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}
