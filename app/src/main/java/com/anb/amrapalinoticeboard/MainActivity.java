package com.anb.amrapalinoticeboard;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.github.chrisbanes.photoview.PhotoView;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.kosalgeek.android.photoutil.GalleryPhoto;
import com.kosalgeek.android.photoutil.ImageLoader;

import java.io.FileNotFoundException;

public class MainActivity extends AppCompatActivity {

    int i =0;
    private InterstitialAd interstitialAd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        AdRequest newad=new AdRequest.Builder().build();
//        interstitialAd=new InterstitialAd(getApplicationContext());
//        interstitialAd.setAdUnitId("ca-app-pub-4787614537130897/7207118716");
//        interstitialAd.loadAd(newad);
//        interstitialAd.setAdListener(new AdListener() {
//            @Override
//            public void onAdLoaded() {
//                displayAd();
//                i++;
//            }
//            public void onAdClosed() {
//                // Load the next interstitial.
//                if (i<2) {
//                    interstitialAd.loadAd(new AdRequest.Builder().build());
//                }
//            }
//        });




        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(android.Manifest.permission.READ_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) {
            } else {
                ActivityCompat.requestPermissions(this,new String[]{android.Manifest.permission.READ_EXTERNAL_STORAGE},1);
            }
        }
        FirebaseMessaging.getInstance().subscribeToTopic("news");


    }


    private void displayAd() {
        if (interstitialAd.isLoaded()){
            interstitialAd.show();
        }
    }


    public void noti(View view){
         Intent intent=new Intent(this,only_text_noti.class);
         startActivity(intent);

    }
    public void intent(String dep){
        Intent i=new Intent(this,noticeBoard.class);
        i.putExtra("dep",dep);
        startActivity(i);
    }

    public void bca(View view){
        intent("bca");

    }
    public void bba(View view){
        intent("bba");

    }
    public void btech(View view){
        intent("btech");

    }
    public void bhm_ku(View view){
        intent("bhmku");

    }
    public void bhm_utu(View view){
        intent("bhmutu");

    }


}
