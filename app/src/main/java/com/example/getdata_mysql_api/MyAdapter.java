package com.example.getdata_mysql_api;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.viewholder> {

    Context context;
    List<Postpojo> list;

    public MyAdapter(Context context, List<Postpojo> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_design,parent,false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        Postpojo m = list.get(position);
        holder.heading.setText(m.getTitle());
        holder.textline.setText(m.getBody());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class viewholder extends RecyclerView.ViewHolder {

        TextView heading, textline;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            heading = itemView.findViewById(R.id.heading);
            textline = itemView.findViewById(R.id.textline);
        }
    }

}
