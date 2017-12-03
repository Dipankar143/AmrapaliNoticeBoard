package com.anb.amrapalinoticeboard;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class noticeBoard extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter myAdeptor;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Data> arrayList;
    DatabaseReference myRef;
    TextView error;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_board);
        error= (TextView) findViewById(R.id.error);
        arrayList= new ArrayList();
        progressDialog = new ProgressDialog(noticeBoard.this);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setTitle("New Notice Found");
        progressDialog.setMessage("Downloading Notice From Notice Board...");
        progressDialog.show();

        String dep=getIntent().getExtras().getString("dep");

        if (dep.equals("bca")) {

            myRef = FirebaseDatabase.getInstance().getReferenceFromUrl("https://amrapalinoticeboard.firebaseio.com").child("BCA");
        }


            if (dep.equals("bba")) {
                myRef = FirebaseDatabase.getInstance().getReferenceFromUrl("https://amrapalinoticeboard.firebaseio.com").child("BBA");
            }

        if (dep.equals("btech")) {

            myRef = FirebaseDatabase.getInstance().getReferenceFromUrl("https://amrapalinoticeboard.firebaseio.com").child("BTECH");
        }
        if (dep.equals("bhmku")) {

            myRef = FirebaseDatabase.getInstance().getReferenceFromUrl("https://amrapalinoticeboard.firebaseio.com").child("BHMKU");
        }
        if (dep.equals("bhmutu")) {

            myRef = FirebaseDatabase.getInstance().getReferenceFromUrl("https://amrapalinoticeboard.firebaseio.com").child("BHMUTU");
        }




        recyclerView= (RecyclerView) findViewById(R.id.rec);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        myAdeptor = new Adeptor(arrayList, getApplicationContext(),progressDialog);
        new getdata().execute();

    }
    public class getdata extends AsyncTask<Void,Void,Void>{


        @Override
        protected Void doInBackground(Void... params) {
            myRef.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                    urlData url=dataSnapshot.getValue(urlData.class);
                    String s1=url.getUrl();
                    Long s2=url.getTime();
                    arrayList.add(new Data(s1,s2));


                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {

                }

                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
            return null;
        }


        @Override
        protected void onPostExecute(Void aVoid) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    //Do your work
                    recyclerView.setAdapter(myAdeptor);
                    if (arrayList.size()==0){

                        Toast.makeText(getApplicationContext(),"No NOtice Found",Toast.LENGTH_LONG).show();
                        error.setVisibility(TextView.VISIBLE);
                        progressDialog.dismiss();

                    }
                }
            },5000);


        }
    }
}
