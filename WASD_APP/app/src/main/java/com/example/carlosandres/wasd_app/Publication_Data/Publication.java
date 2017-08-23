package com.example.carlosandres.wasd_app.Publication_Data;

import com.example.carlosandres.wasd_app.Classes_Main_Screen.*;

public class Publication {

    private int PublicationImg;
    private String PublicationText;
    private String NumComent;
    private String NumPro;

    public Publication(int PublicationImg, String PublicationText, String NumComent, String NumPro){

        this.PublicationImg = PublicationImg;
        this.PublicationText = PublicationText;
        this.NumComent = NumComent;
        this.NumPro = NumPro;
    }

    public int getPublicationImg() {
        return PublicationImg;
    }

    public String getPublicationText() {
        return PublicationText;
    }

    public String getNumComent() {
        return NumComent;
    }

    public String getNumPro() {
        return NumPro;
    }
}
