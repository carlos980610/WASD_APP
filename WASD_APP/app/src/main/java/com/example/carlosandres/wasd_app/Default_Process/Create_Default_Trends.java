package com.example.carlosandres.wasd_app.Default_Process;

import com.example.carlosandres.wasd_app.DataBase.Entities.Trend_Entity;
import com.example.carlosandres.wasd_app.DataBase.Entities.User_Entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Carlos Andrés on 13/11/2017.
 */

public class Create_Default_Trends {

    private String Trend_Title, Trend_Content;

    public Create_Default_Trends() {
    }

    public void Create_Trends (String title, String content){

        Trend_Title = title;
        Trend_Content = content;

        //Fill in ArrayList
        List<Trend_Entity> List_New_Trend = new ArrayList<>();

        Trend_Entity new_trend = new Trend_Entity();
        new_trend.Title_Trend = Trend_Title;
        new_trend.Content_Trend = Trend_Content;
        List_New_Trend.add(new_trend);
    }
}
