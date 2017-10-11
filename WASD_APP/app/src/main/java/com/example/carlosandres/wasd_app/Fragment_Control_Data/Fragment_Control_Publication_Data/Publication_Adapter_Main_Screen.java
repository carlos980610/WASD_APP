package com.example.carlosandres.wasd_app.Fragment_Control_Data.Fragment_Control_Publication_Data;

import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.carlosandres.wasd_app.R;

import java.util.List;

public class Publication_Adapter_Main_Screen extends RecyclerView.Adapter<Publication_Adapter_Main_Screen.PublicationViewHolder>  {

    private List<Publication_Main_Screen> items;
    protected static int click = 0;


    public static class PublicationViewHolder extends RecyclerView.ViewHolder {

        public ImageView PublicationImg;
        public TextView PublicationText;
        public TextView NumComment;
        public TextView NumPro;
        public TextView Nick;
        public TextView Ubication;
        public ImageView ProfileImg;
        public ImageView Comment;
        public ImageView Pro;
        public ImageView Share;
        public ImageView Option;
        public ConstraintLayout LayoutUser;
        public RelativeLayout LayoutPublic;

        public PublicationViewHolder(View v) {
            super(v);

            PublicationImg = (ImageView) v.findViewById(R.id.imgPublcationS);
            PublicationText = (TextView) v.findViewById(R.id.txtPublicDescription);
            NumComment = (TextView) v.findViewById(R.id.txtNumComents);
            NumPro = (TextView) v.findViewById(R.id.txtNumberPro);
            Nick = (TextView) v.findViewById(R.id.txtUser);
            Ubication = (TextView) v.findViewById(R.id.txtUbication);
            ProfileImg = (ImageView) v.findViewById(R.id.imgbtnUser);
            Comment = (ImageView) v.findViewById(R.id.BtnComment);
            Pro = (ImageView) v.findViewById(R.id.BtnPro);
            Share = (ImageView) v.findViewById(R.id.BtnShare);
            Option = (ImageView) v.findViewById(R.id.imgOptionMenu);
            LayoutUser = (ConstraintLayout) v.findViewById(R.id.LayoutUser);
            LayoutPublic = (RelativeLayout) v.findViewById(R.id.LayoutPublic);
            PublicationText.setVisibility(v.INVISIBLE);
            NumComment.setVisibility(v.INVISIBLE);
            NumPro.setVisibility(v.INVISIBLE);
            Nick.setVisibility(v.INVISIBLE);
            Ubication.setVisibility(v.INVISIBLE);
            ProfileImg.setVisibility(v.INVISIBLE);
            Comment.setVisibility(v.INVISIBLE);
            Pro.setVisibility(v.INVISIBLE);
            Share.setVisibility(v.INVISIBLE);
            Option.setVisibility(v.INVISIBLE);
            LayoutUser.setVisibility(v.INVISIBLE);
            LayoutPublic.setVisibility(v.INVISIBLE);


            PublicationImg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    final int Duration = 350;
                    final  int Time_After = 100;

                    AlphaAnimation Animation = new AlphaAnimation(0.0f,1.0f);
                    Animation.setDuration(Duration);
                    Animation.setStartOffset(Time_After);



                        if(click==0){






                            PublicationText.setVisibility(v.INVISIBLE);
                            NumComment.setVisibility(v.INVISIBLE);
                            NumPro.setVisibility(v.INVISIBLE);
                            Nick.setVisibility(v.INVISIBLE);
                            Ubication.setVisibility(v.INVISIBLE);
                            ProfileImg.setVisibility(v.INVISIBLE);
                            Comment.setVisibility(v.INVISIBLE);
                            Pro.setVisibility(v.INVISIBLE);
                            Share.setVisibility(v.INVISIBLE);
                            Option.setVisibility(v.INVISIBLE);
                            LayoutUser.setVisibility(v.INVISIBLE);
                            LayoutPublic.setVisibility(v.INVISIBLE);
                            click = 1;

                        }else if (click==1){





                            LayoutPublic.setAnimation(Animation);
                            LayoutUser.setAnimation(Animation);
                            Option.setAnimation(Animation);
                            Share.setAnimation(Animation);
                            Pro.setAnimation(Animation);
                            Comment.setAnimation(Animation);
                            ProfileImg.setAnimation(Animation);
                            Ubication.setAnimation(Animation);
                            Nick.setAnimation(Animation);
                            NumPro.setAnimation(Animation);
                            NumComment.setAnimation(Animation);

                            PublicationText.setAnimation(Animation);



                            PublicationText.setVisibility(v.VISIBLE);
                            NumComment.setVisibility(v.VISIBLE);
                            NumPro.setVisibility(v.VISIBLE);
                            Nick.setVisibility(v.VISIBLE);
                            Ubication.setVisibility(v.VISIBLE);
                            ProfileImg.setVisibility(v.VISIBLE);
                            Comment.setVisibility(v.VISIBLE);
                            Pro.setVisibility(v.VISIBLE);
                            Share.setVisibility(v.VISIBLE);
                            Option.setVisibility(v.VISIBLE);
                            LayoutUser.setVisibility(v.VISIBLE);
                            LayoutPublic.setVisibility(v.VISIBLE);


                            click = 0;

                        }


                }
            });


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
            viewHolder.NumPro.setText(String.valueOf(items.get(i).getNumPro() + " Pro"));
            viewHolder.Nick.setText(items.get(i).getNick());
            viewHolder.Ubication.setText(items.get(i).getUbication());
            viewHolder.ProfileImg.setImageResource(items.get(i).getProfileImg());

        }



}
