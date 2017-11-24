package com.example.carlosandres.wasd_app.Fragment_Control_Data.Fragment_Control_Publication_Data;

import java.net.URI;

/**
 * Created by hp on 24/11/2017.
 */

public class Video_Publication_Main_Screen {

    private String PublicationVid;
    private String PublicationText;
    private String NumComent;
    private String NumPro;
    private String Nick;
    private String Ubication;
    private int ProfileImg;

    public Video_Publication_Main_Screen(String PublicationVid, String PublicationText, String NumComent, String NumPro, String Nick, String Ubication, int ProfileImg){

        this.PublicationVid = PublicationVid;
        this.PublicationText = PublicationText;
        this.NumComent = NumComent;
        this.NumPro = NumPro;
        this.Nick = Nick;
        this.Ubication = Ubication;
        this.ProfileImg = ProfileImg;
    }

    public String getPublicationVid() {
        return PublicationVid;
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
