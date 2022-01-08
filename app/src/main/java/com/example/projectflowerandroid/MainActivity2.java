package com.example.projectflowerandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        prepareListView();
    }

    private void prepareListView(){
        RecyclerView recyclerView = findViewById(R.id.activity_main2_recycler_view);
        ArrayList<FlowerData> flowerData = new ArrayList<>();
        flowerData.add(new FlowerData("Baby Shower", "bla bla bla", R.drawable.babyshowerflower));
        flowerData.add(new FlowerData("Funeral", "bla bla bla", R.drawable.funeralflower));
        flowerData.add(new FlowerData("Graduation", "bla bla bla", R.drawable.graduationflower));
        flowerData.add(new FlowerData("Wedding", "bla bla bla", R.drawable.weddingflower));

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        CustomAdapter customAdapter = new CustomAdapter(flowerData);

        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(layoutManager);

    }
}

class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder> {

    ArrayList<FlowerData> flowerData;
    public CustomAdapter(ArrayList<FlowerData> flowerData) {
        this.flowerData = flowerData;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.activity_listview, parent, false);

        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        FlowerData fd = flowerData.get(position);

        holder.titleTextView.setText(fd.getTitle());
        holder.subTitleTextView.setText(fd.getSubTitle());
        holder.imageView.setImageResource(fd.getImageId());
    }

    @Override
    public int getItemCount() {
        return flowerData.size();
    }
}

class CustomViewHolder extends RecyclerView.ViewHolder {
    TextView titleTextView;
    TextView subTitleTextView;
    ImageView imageView;

    public CustomViewHolder(@NonNull View itemView) {
        super(itemView);
        titleTextView = itemView.findViewById(R.id.activity_listview_holder_title_view);
        subTitleTextView = itemView.findViewById(R.id.activity_listview_holder_sub_title_view);
        imageView = itemView.findViewById(R.id.activity_listview_holder_image_view);
    }
}

class FlowerData {

    private final String title;
    private final String subTitle;

    private final int imageId;
    public FlowerData(String title, String subTitle, int imageId) {
        this.title = title;
        this.subTitle = subTitle;
        this.imageId = imageId;
    }

    public String getTitle() {
        return title;
    }

    /*public void setTitle(String title) {
        this.title = title;
    }*/

    public String getSubTitle() {
        return subTitle;
    }

    /*public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }*/

    public int getImageId() {
        return imageId;
    }

    /*public void setImageId(int ImageId) {
        this.imageId = imageId;
    }*/
}
