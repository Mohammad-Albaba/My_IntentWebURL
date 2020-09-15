package com.mohammad.myintentweburl;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

public class photo_Gallery extends AppCompatActivity {
ImageView img;
Uri uri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo__gallery);
        img=findViewById(R.id.imageView1);
    }
    public void btn_Pick_Photo(View view) {
        Intent intent=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent,100);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==100 && resultCode==RESULT_OK){
            uri=data.getData();
            img.setImageURI(uri);
        }
    }

    public void btn_ShareImage(View view) {
        Intent intent=new Intent(Intent.ACTION_SEND);
        intent.setType("image/*");
        intent.putExtra(Intent.EXTRA_STREAM,uri);
        intent.putExtra(Intent.EXTRA_TEXT,"مشاركة صورة منم التطبيق");
        Intent chooser =Intent.createChooser(intent ,"مشاركة صورة");
        if (intent.resolveActivity(getPackageManager()) != null){
            startActivity(chooser);
        }
    }


}
