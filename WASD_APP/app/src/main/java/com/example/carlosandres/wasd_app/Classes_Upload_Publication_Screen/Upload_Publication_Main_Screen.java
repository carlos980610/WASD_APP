package com.example.carlosandres.wasd_app.Classes_Upload_Publication_Screen;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.carlosandres.wasd_app.DataBase.Data_Base_Management.DataBaseManager;
import com.example.carlosandres.wasd_app.DataBase.Entities.Image_File_Publication;
import com.example.carlosandres.wasd_app.DataBase.Store_Procedures.Login_Store_Procedures.SP_UpLoad_Publication;
import com.example.carlosandres.wasd_app.Fragment_Control_Data.Fragment_Control_Publication_Data.View_Pager_Adapter;
import com.example.carlosandres.wasd_app.R;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import static android.Manifest.permission.CAMERA;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class Upload_Publication_Main_Screen extends AppCompatActivity {

    private String APP_DIRECTORY  ="myPictureApp/";
    private String MEDIA_DIRECTORY =APP_DIRECTORY + "media";
    private String TEMPORAL_PICTURE_NAME = "temporal.jpg";
    private final int PHOTO_CODE=100;
    private final int SELECT_PICTURE=200;
    private ImageView imageView;
    private ImageView imageView1;
    private final int MY_PERMISSIONS = 100;

    //private EditText editText;


    private ImageView mSetImage;
    private Button mOptionButton;
    private RelativeLayout mRlView;
    private String mPath; //Variable que guarda la ruta de la imagen en el celular

    Context App_Context = this;
    boolean successful = false;

    Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_publication_main_screen);

        final List<Image_File_Publication> List_New_Img_Public = new ArrayList<>(); //Final (?)

        Image_File_Publication new_img_publ = new Image_File_Publication();
        new_img_publ.File_Publication = mPath;
        List_New_Img_Public.add(new_img_publ);

        final SP_UpLoad_Publication SP_U_P = new SP_UpLoad_Publication(App_Context);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.UpButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                successful = SP_U_P.Save_Image_Procedure(List_New_Img_Public);
                imageView1 = (ImageView)findViewById(R.id.imageView5);
                Uri mu = Uri.parse(mPath);
                imageView1.setImageURI(mu);
                if (successful){
                    Snackbar.make(view, "Insert realizado: " + successful, Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }else{
                    Snackbar.make(view, "NO NO " + successful, Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
                Snackbar.make(view, "Path de la imagen: " + mPath, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        



        Button button_photo = (Button)findViewById(R.id.btnSelect_From_Gallery);
        button_photo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final CharSequence [] options = {"Galería", "Camara", "Cancelar"};
                imageView = (ImageView)findViewById(R.id.imageView4);
                //editText = (EditText)findViewById(R.id.editText);

                final AlertDialog.Builder builder = new AlertDialog.Builder(Upload_Publication_Main_Screen.this);
                builder.setTitle("Seleccione la fuente");
                builder.setItems(options  , new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int selectOP){
                        if(options[selectOP]=="Galería"){
                            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                            intent.setType("image/*");
                            startActivityForResult(intent.createChooser(intent, "Select image"), SELECT_PICTURE);
                        }else if(options[selectOP]=="Cancelar"){
                            dialog.dismiss();
                        }else if(options[selectOP]=="Camara"){
                            openCamera();
                        }
                    }
                });
                builder.show();


                }
        });


    }


    private boolean mayRequestStoragePermission() {

        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.M)
            return true;

        if((checkSelfPermission(WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) &&
                (checkSelfPermission(CAMERA) == PackageManager.PERMISSION_GRANTED))
            return true;

        if((shouldShowRequestPermissionRationale(WRITE_EXTERNAL_STORAGE)) || (shouldShowRequestPermissionRationale(CAMERA))){
            Snackbar.make(mRlView, "Los permisos son necesarios para poder usar la aplicación",
                    Snackbar.LENGTH_INDEFINITE).setAction(android.R.string.ok, new View.OnClickListener() {
                @TargetApi(Build.VERSION_CODES.M)
                @Override
                public void onClick(View v) {
                    requestPermissions(new String[]{WRITE_EXTERNAL_STORAGE, CAMERA}, MY_PERMISSIONS);
                }
            });
        }else{
            requestPermissions(new String[]{WRITE_EXTERNAL_STORAGE, CAMERA}, MY_PERMISSIONS);
        }
        return false;
    }

    private void openCamera() {
        mayRequestStoragePermission();
        File file = new File(Environment.getExternalStorageDirectory(), MEDIA_DIRECTORY);
        boolean isDirectoryCreated = file.exists();

        if(!isDirectoryCreated)
            isDirectoryCreated = file.mkdirs();

        if(isDirectoryCreated){
            Long timestamp = System.currentTimeMillis() / 1000;
            String imageName = timestamp.toString() + ".jpg";

            mPath = Environment.getExternalStorageDirectory() + File.separator + MEDIA_DIRECTORY
                    + File.separator + imageName;

            File newFile = new File(mPath);

            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(newFile));
            startActivityForResult(intent, PHOTO_CODE);
        }
    }







    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK){
            switch (requestCode){
                case SELECT_PICTURE:
                    Uri path = data.getData();
                    Toast.makeText(getApplicationContext(), "Path path: " + path, Toast.LENGTH_SHORT).show();
                    mPath = path.toString();
                    //imageView.setImageURI(path);
                    //imageView1.setImageURI(path);

                    break;
                 /*
                case PHOTO_CODE:
                    MediaScannerConnection.scanFile(this,
                            new String[]{mPath}, null,
                            new MediaScannerConnection.OnScanCompletedListener() {
                                @Override
                                public void onScanCompleted(String path, Uri uri) {
                                    Log.i("ExternalStorage", "Scanned " + path + ":");
                                    Log.i("ExternalStorage", "-> Uri = " + uri);
                                }
                            });


                    bitmap = BitmapFactory.decodeFile(mPath);
                    mSetImage.setImageBitmap(bitmap);
                    imageView1.setImageBitmap(bitmap);
                    break;*/
            }
        }
    }


    /*public static byte[] getBytesFromBitmap(Bitmap bitmap) {
        if (bitmap!=null) {
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 70, stream);
            return stream.toByteArray();
        }else{
            return null;
        }
    }*/
}
