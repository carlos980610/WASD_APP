package com.example.carlosandres.wasd_app.Fragment_Control_Data.Fragment_Control_Publication_Data;

public class Publication_Main_Screen {

    private int PublicationImg;
    private String PublicationText;
    private String NumComent;
    private String NumPro;
    private String Nick;
    private String Ubication;
    private int ProfileImg;

    public Publication_Main_Screen(int PublicationImg, String PublicationText, String NumComent, String NumPro, String Nick, String Ubication, int ProfileImg){

        this.PublicationImg = PublicationImg;
        this.PublicationText = PublicationText;
        this.NumComent = NumComent;
        this.NumPro = NumPro;
        this.Nick = Nick;
        this.Ubication = Ubication;
        this.ProfileImg = ProfileImg;
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

    public String getNick() { return Nick; }

    public String getUbication() { return Ubication; }

    public int getProfileImg() { return ProfileImg; }

}