package com.example.carlosandres.wasd_app.Classes_Upload_Publication_Screen;

import android.content.DialogInterface;
import android.content.Intent;
import android.provider.MediaStore;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.carlosandres.wasd_app.Fragment_Control_Data.Fragment_Control_Publication_Data.View_Pager_Adapter;
import com.example.carlosandres.wasd_app.R;

public class Upload_Publication_Main_Screen extends AppCompatActivity {

    private String APP_DIRECTORY  ="myPictureApp/";
    private String MEDIA_DIRECTORY =APP_DIRECTORY + "media";
    private String TEMPORAL_PICTURE_NAME = "temporal.jpg";
    private final int PHOTO_CODE=100;
    private final int SELECT_PICTURE=200;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_publication_main_screen);

        final CharSequence [] options = {"Gallery", "Cancel"};
        imageView = (ImageView)findViewById(R.id.imageView4);
        Button button_photo = (Button)findViewById(R.id.btnSelect_From_Gallery);
        button_photo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                final AlertDialog.Builder builder = new AlertDialog.Builder(Upload_Publication_Main_Screen.this);
                builder.setTitle("Choose    an option");
                builder.setItems(options  , new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int selectOP){
                        if(options[selectOP]=="Gallery"){
                            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                            intent.setType("image/*");
                            startActivityForResult(intent.createChooser(intent, "Cancel"), SELECT_PICTURE);
                        }else if(options[selectOP]=="Cancel"){
                            dialog.dismiss();
                        }
                    }
                });
                builder.show();
            }
        });

    }
}
