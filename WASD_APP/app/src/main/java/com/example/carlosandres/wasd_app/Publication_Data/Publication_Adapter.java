package com.example.carlosandres.wasd_app.Publication_Data;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.carlosandres.wasd_app.R;

import java.util.List;

public class Publication_Adapter extends RecyclerView.Adapter<Publication_Adapter.PublicationViewHolder>  {

    private List<Publication> items;

    public static class PublicationViewHolder extends RecyclerView.ViewHolder {

        public ImageView PublicationImg;
        public TextView PublicaciontText;
        public TextView NumComent;
        public TextView NumPro;

        public PublicationViewHolder(View v) {
            super(v);

            PublicationImg = (ImageView) v.findViewById(R.id.PublicationImg);
            PublicaciontText = (TextView) v.findViewById(R.id.PublicationText);
            NumComent = (TextView) v.findViewById(R.id.NumComent);
            NumPro = (TextView) v.findViewById(R.id.NumPro);
        }
    }
        public Publication_Adapter(List<Publication> items) {
            this.items = items;
        }

        @Override
        public int getItemCount(){
            return items.size();
        }

        @Override
        public PublicationViewHolder onCreateViewHolder(ViewGroup viewGroup, int i){

            View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.publication_card, viewGroup, false);
            return new PublicationViewHolder(v);
        }

        @Override
        public void onBindViewHolder(PublicationViewHolder viewHolder, int i){

            viewHolder.PublicationImg.setImageResource(items.get(i).getPublicationImg());
            viewHolder.PublicaciontText.setText(items.get(i).getPublicationText());
            viewHolder.NumComent.setText(String.valueOf(items.get(i).getNumComent() + " Comentarios."));
            viewHolder.NumPro.setText(String.valueOf(items.get(i).getNumPro()));

        }

}
