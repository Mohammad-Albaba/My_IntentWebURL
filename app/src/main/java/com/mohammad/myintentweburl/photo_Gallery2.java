package com.mohammad.myintentweburl;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class photo_Gallery2 extends AppCompatActivity {
ImageView img1,img2,img3,img4;
ArrayList<Uri> imageUris=new ArrayList<Uri>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo__gallery2);
        img1=findViewById(R.id.imageView1);
        img2=findViewById(R.id.imageView2);
        img3=findViewById(R.id.imageView3);
        img4=findViewById(R.id.imageView4);

    }


    public void img_1(View view) {
        Intent intent=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent,1);
    }

    public void img_2(View view) {
        Intent intent=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent,2);
    }

    public void img_3(View view) {
        Intent intent=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent,3);
    }

    public void img_4(View view) {
        Intent intent=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent,4);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode ==RESULT_OK){
            if (requestCode==1){
                imageUris.add(data.getData());
            img1.setImageURI(data.getData());
            }
            if (requestCode==2){
                imageUris.add(data.getData());
                img2.setImageURI(data.getData());
            }
            if (requestCode==3){
                imageUris.add(data.getData());
                img3.setImageURI(data.getData());
            }
            if (requestCode==4){
                imageUris.add(data.getData());
                img4.setImageURI(data.getData());
            }
        }
    }

    public void btn_ShareMultiImage(View view) {
        Intent shareIntent=new Intent(Intent.ACTION_SEND_MULTIPLE);
        shareIntent.putParcelableArrayListExtra(Intent.EXTRA_STREAM,imageUris);
        shareIntent.setType("image/*");
        startActivity(Intent.createChooser(shareIntent,"مشاركة مجموعة صور"));
    }

}
