package com.example.carlosandres.wasd_app.Fragment_Control_Data.Fragment_Control_Publication_Data;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.carlosandres.wasd_app.R;

import java.util.ArrayList;
import java.util.List;

public class Second_Fragment_Main_Screen extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.content_main__main__screen,container, false);
        return rootView;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final List<Video_Publication_Main_Screen> items = new ArrayList<Video_Publication_Main_Screen>();

        items.add(new Video_Publication_Main_Screen("android.resource://com.example.carlosandres.wasd_app/"+R.raw.bteaser, "Teaser B1", "145", "87", "JdeJOhn", "Poblado", R.drawable.newuser01));
        items.add(new Video_Publication_Main_Screen("android.resource://com.example.carlosandres.wasd_app/"+R.raw.ascteaser, "Teaser del origen (Assassins Creed: Origins)", "785", "657", "Rodolfio02", "Itagui", R.drawable.newuser01));
        items.add(new Video_Publication_Main_Screen("android.resource://com.example.carlosandres.wasd_app/"+R.raw.nfsteaser, "Uno más para este año", "28", "74", "Eltio01", "Los Angeles", R.drawable.newuser01));
        items.add(new Video_Publication_Main_Screen("android.resource://com.example.carlosandres.wasd_app/"+R.raw.codteaser, "Esto es la verdadera guerra - CODWWII", "423", "120", "Iva025", "Envigado", R.drawable.newuser01));


        final Video_Publication_Adapter_Main_Screen itemsAdapter = new Video_Publication_Adapter_Main_Screen(items);
        final RecyclerView clv = (RecyclerView) view.findViewById(R.id.recycler);
        clv.setLayoutManager(new LinearLayoutManager(Second_Fragment_Main_Screen.this.getActivity()));
        clv.setHasFixedSize(true);
        clv.setAdapter(itemsAdapter);

    }
}
