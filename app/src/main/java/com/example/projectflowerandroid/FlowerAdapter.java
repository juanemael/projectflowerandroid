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

public class FlowerAdapter extends ArrayAdapter<FlowerCatalog> {
    Context context;

    public FlowerAdapter(Context context, int resource, List<FlowerCatalog> flowers) {
        super(context, resource, flowers);
        this.context = context;
    }

    /*private view holder class*/
    private class Viewholder {
        TextView tvName;
        TextView tvPrice;
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
            holder.tvName = (TextView) convertView.findViewById(R.id.textViewName);
            holder.tvPrice = (TextView) convertView.findViewById(R.id.textViewPrice);
            holder.ivFlowerCatalog = (ImageView) convertView.findViewById(R.id.imageViewFlowerCatalog);
            convertView.setTag(holder);
        }else {
            holder = (Viewholder) convertView.getTag();
        }
        holder.tvName.setText(fc.getName());
        holder.tvPrice.setText("Rp" + fc.getPrice());
        int imageid = context.getResources().getIdentifier(fc.getImage(), "drawable", context.getPackageName());
        try {
            Picasso.get().load(imageid).fit().centerInside().into(holder.ivFlowerCatalog);
        }catch (Exception e) {
            Log.d("TAG", "flower:" + fc.getName());
        }
        return convertView;
    }
}