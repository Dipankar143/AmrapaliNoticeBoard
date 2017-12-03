package com.anb.amrapalinoticeboard;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by dipanker on 29/08/17.
 */

public class only_text_adeptor extends RecyclerView.Adapter<only_text_adeptor.ViewHolder> {
    public only_text_adeptor(ArrayList<only_text_Data> arrayList, Context context,ProgressDialog progressDialog) {
        this.arrayList = arrayList;
        this.context = context;
        this.progressDialog=progressDialog;
    }

    ArrayList<only_text_Data> arrayList;
    Context context;
    ProgressDialog progressDialog;
    int i;

    @Override
    public only_text_adeptor.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.noti_design,parent,false);
        ViewHolder viewHolder=new ViewHolder(view,arrayList,context);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(only_text_adeptor.ViewHolder holder, int position) {
        if (position==0) {
            i = arrayList.size()-1;
        }
        holder.title.setText(arrayList.get(i).getTitle());
        holder.msg.setText(arrayList.get(i).getMsg());
        holder.faculty.setText("By "+arrayList.get(i).getFaculty()+" Faculty");
        if (arrayList.size()==position+1){
            progressDialog.dismiss();

        }
        i--;
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView title,msg,faculty;
        ArrayList<only_text_Data> arrayList;
        Context context;
        public ViewHolder(View itemView,ArrayList<only_text_Data> arrayList,Context context) {
            super(itemView);
            title=(TextView) itemView.findViewById(R.id.txt_title);
            msg=(TextView) itemView.findViewById(R.id.txt_msg);
            faculty= (TextView) itemView.findViewById(R.id.faculty);
            this.arrayList=arrayList;
            this.context=context;
        }
    }
}
