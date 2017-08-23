package com.example.carlosandres.wasd_app.Classes_Main_Screen;

import android.os.Bundle;
import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.carlosandres.wasd_app.Publication_Data.Publication;
import com.example.carlosandres.wasd_app.Publication_Data.Publication_Adapter;
import com.example.carlosandres.wasd_app.R;

import java.util.ArrayList;
import java.util.List;

public class Main_Main_Screen extends Activity {

    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager IManager;

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
    }







}
