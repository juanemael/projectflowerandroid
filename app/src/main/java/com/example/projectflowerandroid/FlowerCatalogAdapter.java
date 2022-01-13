package com.example.projectflowerandroid;

//import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

//import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

import java.util.List;

public class FlowerCatalogAdapter extends ArrayAdapter<FlowerCatalog> {
    Context context;

    public FlowerCatalogAdapter(Context context, int resource, List<FlowerCatalog> flowers) {
        super(context, resource, flowers);
        this.context = context;
    }

    /*private view holder class*/
    private class Viewholder {
        TextView tvTitle;
        TextView tvSubtitle;
        ImageView ivFlowerCatalog;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Viewholder holder = null;
        FlowerCatalog fc = getItem(position);
        LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.activity_flower_catalog, null);
            holder = new Viewholder();
            holder.tvTitle = (TextView) convertView.findViewById(R.id.textViewTitle);
            holder.tvSubtitle = (TextView) convertView.findViewById(R.id.textViewSubtitle);
            holder.ivFlowerCatalog = (ImageView) convertView.findViewById(R.id.imageViewFlowerCatalog);
            convertView.setTag(holder);
        }else {
            holder = (Viewholder) convertView.getTag();
        }
        holder.tvTitle.setText(fc.getTitle());
        holder.tvSubtitle.setText(fc.getSubtitle());
        int imageid = context.getResources().getIdentifier(fc.getImage(), "drawable", context.getPackageName());
        try {
            Picasso.get().load(imageid).fit().centerInside().into(holder.ivFlowerCatalog);
        }catch (Exception e) {
            Log.d("TAG", "flower:" + fc.getTitle());
        }
        return convertView;
    }
}