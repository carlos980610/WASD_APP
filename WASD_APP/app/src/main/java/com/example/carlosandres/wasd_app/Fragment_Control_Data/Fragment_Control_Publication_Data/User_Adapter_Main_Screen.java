package com.example.carlosandres.wasd_app.Fragment_Control_Data.Fragment_Control_Publication_Data;

/**
 * Created by hp on 20/11/2017.
 */

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import android.widget.BaseAdapter;

import com.example.carlosandres.wasd_app.DataBase.Entities.User_Entity;
import com.example.carlosandres.wasd_app.R;

public class User_Adapter_Main_Screen extends BaseAdapter{

    protected Activity activity;
    protected ArrayList<User_Entity> items;

    public User_Adapter_Main_Screen (Activity activity, ArrayList<User_Entity> items) {
        this.activity = activity;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    public void clear() {
        items.clear();
    }

    public void addAll(ArrayList<User_Entity> category) {
        for (int i = 0; i < category.size(); i++) {
            items.add(category.get(i));
        }
    }

    @Override
    public Object getItem(int arg0) {
        return items.get(arg0);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (convertView == null) {
            LayoutInflater inf = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inf.inflate(R.layout.user_card, null);
        }

        User_Entity UD = items.get(position);

        TextView UserName = (TextView) v.findViewById(R.id.UserName);
        UserName.setText(UD.Name_User);

        TextView NickName = (TextView) v.findViewById(R.id.NickName);
        NickName.setText(UD.NickName_User);

        //ImageView imagen = (ImageView) v.findViewById(R.id.imageView);
        //imagen.setImageDrawable(UD.);

        return v;
    }

}
