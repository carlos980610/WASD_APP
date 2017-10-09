package com.example.carlosandres.wasd_app.Fragment_Control_Data.Fragment_Control_Publication_Data;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.carlosandres.wasd_app.R;

import java.util.ArrayList;
import java.util.List;

import static com.example.carlosandres.wasd_app.R.id.imgPublcationS;

/**
 * Created by hp on 4/09/2017.
 */

public class First_Fragment_Main_Screen extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.content_main__main__screen,container, false);
        return rootView;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final List<Publication_Main_Screen> items = new ArrayList<Publication_Main_Screen>();

        items.add(new Publication_Main_Screen(R.drawable.f, "Esto es un texto de publicacion", "45", "87", "Iva025", "Envigado", R.drawable.l));
        items.add(new Publication_Main_Screen(R.drawable.l, "Esto es OTRO text de prueba para una publicacion", "80", "357", "CAMC", "IUE", R.drawable.f));


        final Publication_Adapter_Main_Screen itemsAdapter = new Publication_Adapter_Main_Screen(items);
        final RecyclerView clv = (RecyclerView) view.findViewById(R.id.recycler);
        clv.setLayoutManager(new LinearLayoutManager(First_Fragment_Main_Screen.this.getActivity()));
        clv.setHasFixedSize(true);
        clv.setAdapter(itemsAdapter);

    }
}