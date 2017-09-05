package com.example.carlosandres.wasd_app.Publication_Data;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.carlosandres.wasd_app.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hp on 4/09/2017.
 */

public class First_Fragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.content_main__main__screen,container, false);
        return rootView;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final List<Publication> items = new ArrayList<Publication>();

        items.add(new Publication(R.drawable.f, "Esto es un texto de publicacion", "45", "87"));
        items.add(new Publication(R.drawable.l, "Esto es OTRO text de prueba para una publicacion", "80", "357"));


        final Publication_Adapter itemsAdapter = new Publication_Adapter(items);
        final RecyclerView clv = (RecyclerView) view.findViewById(R.id.recycler);
        clv.setLayoutManager(new LinearLayoutManager(First_Fragment.this.getActivity()));
        clv.setHasFixedSize(true);
        clv.setAdapter(itemsAdapter);

    }
}