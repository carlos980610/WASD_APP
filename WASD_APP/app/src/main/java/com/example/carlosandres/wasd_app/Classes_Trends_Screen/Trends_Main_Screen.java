package com.example.carlosandres.wasd_app.Classes_Trends_Screen;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.carlosandres.wasd_app.DataBase.Store_Procedures.Login_Store_Procedures.SP_Insert_Trends;
import com.example.carlosandres.wasd_app.Default_Process.Create_Default_Trends;
import com.example.carlosandres.wasd_app.Default_Process.Create_Default_Users;
import com.example.carlosandres.wasd_app.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Trends_Main_Screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trends_main_screen);

        ListView lv = (ListView) findViewById(R.id.lvTrends);
        
        Create_Default_Trends cdt = new Create_Default_Trends();
        cdt.Create_Trends("Trend 1","Este es el contenido de la tendencia 1"); //Trend 1
        cdt.Create_Trends("Trend 2","Este es el contenido de la tendencia 2"); //Trend 2
        cdt.Create_Trends("Trend 3 ","Este es el contenido de la tendencia 3"); //Trend 3


        ArrayList<String> Lista = new ArrayList<>();
        Lista.add("Las herramientas de creación de juegos como Unreal Engine se ponen al servicio de los arquitectos");
        Lista.add("Juegos Xbox Gold gratis para One y 360 en noviembre 2017");
        Lista.add("'Juego de Tronos', George R. R. Martin y la incertidumbre en los lanzamientos de los libros");

        ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Lista);

        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override//
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String url;
                Intent i;
                switch (position){
                    case 0:
                        url = "https://www.xataka.com/videojuegos/las-herramientas-de-creacion-de-juegos-como-unreal-engine-se-ponen-al-servicio-de-los-arquitectos";
                        i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(url));
                        startActivity(i);
                        break;
                    case 1:
                        url = "https://www.xataka.com/basics/juegos-xbox-gold-gratis-para-one-y-360-en-noviembre-2017";
                        i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(url));
                        startActivity(i);
                        break;
                    case 2:
                        url = "https://www.xataka.com/literatura-comics-y-juegos/juego-de-tronos-george-r-r-martin-y-la-incertidumbre-en-los-lanzamientos-de-los-libros";
                        i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(url));
                        startActivity(i);
                        break;
                }
            }
        });
    }
}
