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

        items.add(new Publication_Main_Screen(R.drawable.f, "Esto es un texto de publicacion", "45", "87", "Iva025", "Envigado", R.drawable.i));
        items.add(new Publication_Main_Screen(R.drawable.l, "Esto es OTRO text de prueba para una publicacion", "80", "357", "CAMC", "IUE", R.drawable.u));
        items.add(new Publication_Main_Screen(R.drawable.q, "Esto es un texto de publicacion", "78", "504", "Granaada", "Sabaneta", R.drawable.i));
        items.add(new Publication_Main_Screen(R.drawable.w, "Esto es OTRO text de prueba para una publicacion", "140", "34", "Karrim058", "Poblado", R.drawable.u));
        items.add(new Publication_Main_Screen(R.drawable.e, "Esto es un texto de publicacion", "95", "147", "ConNvidia4", "En la Grieta", R.drawable.i));
        items.add(new Publication_Main_Screen(R.drawable.r, "Esto es OTRO text de prueba para una publicacion", "870", "3757", "Larrys69", "En too lado", R.drawable.u));
        items.add(new Publication_Main_Screen(R.drawable.t, "Esto es un texto de publicacion", "35", "78", "TheJimmyNeut74", "Itagui", R.drawable.i));
        items.add(new Publication_Main_Screen(R.drawable.a, "Esto es OTRO text de prueba para una publicacion", "860", "3507", "IoCiBi", "San Jose", R.drawable.u));
        items.add(new Publication_Main_Screen(R.drawable.z, "Esto es un texto de publicacion", "489", "787", "TheChapther1", "Envigado", R.drawable.i));
        items.add(new Publication_Main_Screen(R.drawable.x, "Esto es OTRO text de prueba para una publicacion", "880", "457", "CAMC", "IUE", R.drawable.u));


        final Publication_Adapter_Main_Screen itemsAdapter = new Publication_Adapter_Main_Screen(items);
        final RecyclerView clv = (RecyclerView) view.findViewById(R.id.recycler);
        clv.setLayoutManager(new LinearLayoutManager(First_Fragment_Main_Screen.this.getActivity()));
        clv.setHasFixedSize(true);
        clv.setAdapter(itemsAdapter);

    }
}