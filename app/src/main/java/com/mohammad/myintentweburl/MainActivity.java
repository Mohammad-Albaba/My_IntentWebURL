package com.mohammad.myintentweburl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btn_Web_URL(View view) {
        Intent website=new Intent(Intent.ACTION_VIEW);
        website.setData(Uri.parse("https://www.youtube.com/c/salim3dd"));
        if(website.resolveActivity(getPackageManager()) != null){
            startActivity(website);
        }
    }

    public void btn_TEL(View view) {
        String phoneNumber="92929292";
        Intent intent=new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
    }
    public void btn_GoogleMap(View view) {
        Intent google_Map=new Intent(Intent.ACTION_VIEW);
        google_Map.setData(Uri.parse("geo:31.4418573,34.421304?z=10.6"));
        if (google_Map.resolveActivity(getPackageManager()) != null){
            startActivity(google_Map);
        }
    }


    public void btn_ShareImage(View view) {
        startActivity(new Intent(getApplication(),photo_Gallery.class));
    }
    public void btn_ShareMultiImage(View view) {
        startActivity(new Intent(getApplication(),photo_Gallery2.class));
    }
    public void btn_Email(View view) {
        try {
            Intent sendemail =new Intent(Intent.ACTION_SEND);
            sendemail.setData(Uri.parse("mailato"));
            sendemail.setType("message/rfc822");

            sendemail.putExtra(Intent.EXTRA_EMAIL,"albabam9@gmail.com");
            sendemail.putExtra(Intent.EXTRA_SUBJECT,"عنوان الرسالة");
            sendemail.putExtra(Intent.EXTRA_TEXT,"موضوع الرسالة");
            startActivity(sendemail);
        }catch (Exception e){
            Toast.makeText(this, "عذرا لا يوجد تطبيق البريد", Toast.LENGTH_SHORT).show();
        }


    }
    public void btn_ShareText(View view) {
        Intent sendIntent=new Intent(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT,"This is my text to send");
        sendIntent.setType("text/plain");
        startActivity(Intent.createChooser(sendIntent,"Send Text"));
    }


    public void btn_Alarm(View view) {
        Intent intent=new Intent(AlarmClock.ACTION_SET_TIMER);
        intent.putExtra(AlarmClock.EXTRA_MESSAGE,"Message");
        intent.putExtra(AlarmClock.EXTRA_LENGTH,10);
        intent.putExtra(AlarmClock.EXTRA_SKIP_UI,true);

        if (intent.resolveActivity(getPackageManager())!=null){
            startActivity(intent);
        }
    }
}
