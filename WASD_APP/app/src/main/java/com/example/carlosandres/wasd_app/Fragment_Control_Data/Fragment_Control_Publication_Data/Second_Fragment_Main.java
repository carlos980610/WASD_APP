package com.example.carlosandres.wasd_app.Fragment_Control_Data.Fragment_Control_Publication_Data;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.carlosandres.wasd_app.DataBase.Entities.User_Entity;
import com.example.carlosandres.wasd_app.R;

import java.util.ArrayList;
import java.util.List;

import static android.R.layout.simple_list_item_1;

/**
 * Created by hp on 10/10/2017.
 */

public class Second_Fragment_Main extends Fragment {

    public ListView lv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.profile_tab, container, false);
        return rootView;
    }

    public void onViewCreated(View v, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(v, savedInstanceState);

        /*ArrayList<User_Entity> User = new ArrayList<User_Entity>();
        lv = (ListView) lv.findViewById(R.id.UserView);

        User_Adapter_Main_Screen adapter = new User_Adapter_Main_Screen(this.getActivity(), User);

        lv.setAdapter(adapter);
*/


        /*
        ListView miLista = (ListView) getView().findViewById(R.id.ListView_1);
        ArrayList<String> coleccion = new ArrayList<>();
        coleccion.add(0, "Noticia 1");
        coleccion.add(1, "Noticia 2");
        coleccion.add(2, "Noticia 3");
        coleccion.add(3, "Noticia 4");
        coleccion.add(4, "Noticia 5");

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(getActivity().getApplicationContext(), android.R.layout.simple_list_item_1);
        miLista.setAdapter(adaptador);
*/
    }

}