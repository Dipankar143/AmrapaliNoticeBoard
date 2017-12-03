package com.anb.amrapalinoticeboard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.github.chrisbanes.photoview.PhotoView;

public class notification extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

            String value = getIntent().getExtras().getString("url");
            PhotoView photoView = (PhotoView) findViewById(R.id.photo);
            Glide.with(this).load(value).into(photoView);

    }
}
