package com.rahul.recyclerviewexmp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.courseViewHolder> {

    private String[] data;

    public CourseAdapter(String[] data){
        this.data=data;
    }

    @NonNull
    @Override
    public courseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item,parent,false);
        return new courseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull courseViewHolder holder, int position) {
        String title=data[position];

        holder.textView.setText(title);

    }

    @Override
    public int getItemCount() {
        return data.length;
    }


    public class courseViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public courseViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageView);
            textView=itemView.findViewById(R.id.textView);
        }
    }
}

