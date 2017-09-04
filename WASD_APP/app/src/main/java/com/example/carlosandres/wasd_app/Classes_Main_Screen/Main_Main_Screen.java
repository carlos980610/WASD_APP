package com.example.carlosandres.wasd_app.Classes_Main_Screen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.carlosandres.wasd_app.Publication_Data.Publication;
import com.example.carlosandres.wasd_app.Publication_Data.Publication_Adapter;
import com.example.carlosandres.wasd_app.R;

import java.util.ArrayList;
import java.util.List;

public class Main_Main_Screen extends AppCompatActivity {

    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager IManager;

    private Toolbar toolbar;


    private static ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_main_screen);


        List<Publication> items = new ArrayList<>();

        items.add(new Publication(R.drawable.f, "Esto es un texto de publicacion", "45", "87"));
        items.add(new Publication(R.drawable.l, "Esto es OTRO text de prueba para una publicacion", "80", "357"));

        recycler = (RecyclerView) findViewById(R.id.recycler);
        recycler.setHasFixedSize(true);

        IManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(IManager);

        adapter = new Publication_Adapter(items);
        recycler.setAdapter(adapter);


        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("WASD");

        /*TabLayout tabs = (TabLayout) findViewById(R.id.tabs);

        tabs.addTab(tabs.newTab().setText("Main"));
        tabs.addTab(tabs.newTab().setText("Chat"));
        tabs.addTab(tabs.newTab().setText("Profile"));
*/
        //tabs.setTabMode(TabLayout.MODE_SCROLLABLE);


        final Button btnTemporary = (Button) findViewById(R.id.btnTemporalProfileAccess);
        btnTemporary.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent (getApplicationContext(), My_Personal_Profile_Screen.class);
                startActivity(intent);
            }

        });

    }

}
