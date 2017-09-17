package com.example.carlosandres.wasd_app.Fragment_Control_Data.Fragment_Control_Publication_Data;

public class Publication_Main_Screen {

    private int PublicationImg;
    private String PublicationText;
    private String NumComent;
    private String NumPro;

    public Publication_Main_Screen(int PublicationImg, String PublicationText, String NumComent, String NumPro){

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
