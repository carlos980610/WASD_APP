package com.example.carlosandres.wasd_app.Fragment_Control_Data.Fragment_Control_Publication_Data;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.carlosandres.wasd_app.R;

import java.util.List;

public class Publication_Adapter_Main_Screen extends RecyclerView.Adapter<Publication_Adapter_Main_Screen.PublicationViewHolder>  {

    private List<Publication_Main_Screen> items;



    public static class PublicationViewHolder extends RecyclerView.ViewHolder {

        public ImageView PublicationImg;
        public TextView PublicationText;
        public TextView NumComment;
        public TextView NumPro;

        public PublicationViewHolder(View v) {
            super(v);

            PublicationImg = (ImageView) v.findViewById(R.id.imgPublication);
            PublicationText = (TextView) v.findViewById(R.id.txtPublishDescription);
            NumComment = (TextView) v.findViewById(R.id.txtNumComments);
            NumPro = (TextView) v.findViewById(R.id.txtNumberPro);
        }
    }
        public Publication_Adapter_Main_Screen(List<Publication_Main_Screen> items) {
            this.items = items;
        }

        @Override //Ok
        public int getItemCount(){
            return items.size();
        }

        @Override //Ok
        public PublicationViewHolder onCreateViewHolder(ViewGroup viewGroup, int i){

            View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.publication_card, viewGroup, false);
            return new PublicationViewHolder(v);
        }

        @Override //Ok
        public void onBindViewHolder(PublicationViewHolder viewHolder, int i){

            viewHolder.PublicationImg.setImageResource(items.get(i).getPublicationImg());
            viewHolder.PublicationText.setText(items.get(i).getPublicationText());
            viewHolder.NumComment.setText(String.valueOf(items.get(i).getNumComent() + " Comentarios"));
            viewHolder.NumPro.setText(String.valueOf(items.get(i).getNumPro()));

        }

}
