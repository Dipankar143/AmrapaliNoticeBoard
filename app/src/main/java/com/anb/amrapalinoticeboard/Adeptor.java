package com.anb.amrapalinoticeboard;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.github.chrisbanes.photoview.PhotoView;
import com.kosalgeek.android.photoutil.ImageLoader;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by dipanker on 19/08/17.
 */

public class Adeptor extends RecyclerView.Adapter<Adeptor.ViewHolder> {
    ArrayList<Data> arrayList;
    Context context;
    int i=0;
    ProgressDialog pr;

    public Adeptor(ArrayList<Data> arrayList,Context context,ProgressDialog pr) {
        this.arrayList = arrayList;
        this.context=context;
        this.pr=pr;
    }


    @Override
    public Adeptor.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.design,parent,false);
        ViewHolder viewHolder=new ViewHolder(view,arrayList,context);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final Adeptor.ViewHolder holder, final int position) {




                holder.imageView.setImageResource(R.drawable.placeholder);

                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                String dateString = formatter.format(new Date(arrayList.get(position).getTime()));

                holder.time.setText(dateString);
                Glide.with(context).load(arrayList.get(position).getUrl()).asBitmap().centerCrop()
                        .into(new SimpleTarget<Bitmap>() {
                            @Override
                            public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                                holder.imageView.setImageBitmap(resource);
                                if (position==arrayList.size()-1) {
                                    pr.dismiss();
                                }

                            }
                        });
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(context.getApplicationContext(),notification.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                i.putExtra("url",arrayList.get(position).getUrl());
                context.startActivity(i);
            }
        });








    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ArrayList<Data> arrayList;
        PhotoView imageView;
        Context context;
        TextView time;

        public ViewHolder(View itemView, ArrayList<Data> arrayList,Context context) {
            super(itemView);
            this.arrayList=arrayList;
            this.context=context;
            imageView=(PhotoView) itemView.findViewById(R.id.img);
            time= (TextView) itemView.findViewById(R.id.time);

        }
    }
}
