package com.example.photoediter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.net.URI;
import java.util.List;

public class RecyclerAdaptor extends RecyclerView.Adapter<RecyclerAdaptor.viewModel> {
List<Uri> photolist;
Context context;

    public RecyclerAdaptor(List<Uri> photolist, Context context) {
        this.photolist = photolist;
        this.context = context;
    }

    @NonNull

    @Override
    public viewModel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.image_item,parent,false);

        return new viewModel(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdaptor.viewModel holder, int position) {
        holder.imageView.setImageURI(photolist.get(position));
    }

    @Override
    public int getItemCount() {
        if (photolist.size()==0)
        {
            return 0;
        }
        return photolist.size();
    }

    public class viewModel extends RecyclerView.ViewHolder{
        ImageView imageView;
        public viewModel(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.item_imageview);
        }
    }
}
