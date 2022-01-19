package com.example.projectflowerandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        prepareListView();

    }

    private void prepareListView(){

        RecyclerView rv = findViewById(R.id.activity_list_view_recycler_view);
        ArrayList<DataModel> dataModels = new ArrayList<>();

        dataModels.add(new DataModel("Title 1", "Lorem Ipsum Dolor si Amet", R.drawable.babyshowerflower));
        dataModels.add(new DataModel("Title 2", "Lorem Ipsum Dolor si Amet", R.drawable.babyshowerflower));
        dataModels.add(new DataModel("Title 3", "Lorem Ipsum Dolor si Amet", R.drawable.babyshowerflower));
        dataModels.add(new DataModel("Title 4", "Lorem Ipsum Dolor si Amet", R.drawable.babyshowerflower));
        dataModels.add(new DataModel("Title 5", "Lorem Ipsum Dolor si Amet", R.drawable.funeralflower));
        dataModels.add(new DataModel("Title 6", "Lorem Ipsum Dolor si Amet", R.drawable.funeralflower));
        dataModels.add(new DataModel("Title 7", "Lorem Ipsum Dolor si Amet", R.drawable.funeralflower));
        dataModels.add(new DataModel("Title 8", "Lorem Ipsum Dolor si Amet", R.drawable.funeralflower));
        dataModels.add(new DataModel("Title 9", "Lorem Ipsum Dolor si Amet", R.drawable.graduationflower));
        dataModels.add(new DataModel("Title 10", "Lorem Ipsum Dolor si Amet", R.drawable.graduationflower));
        dataModels.add(new DataModel("Title 11", "Lorem Ipsum Dolor si Amet", R.drawable.graduationflower));
        dataModels.add(new DataModel("Title 12", "Lorem Ipsum Dolor si Amet", R.drawable.graduationflower));
        dataModels.add(new DataModel("Title 13", "Lorem Ipsum Dolor si Amet", R.drawable.weddingflower));
        dataModels.add(new DataModel("Title 14", "Lorem Ipsum Dolor si Amet", R.drawable.weddingflower));
        dataModels.add(new DataModel("Title 15", "Lorem Ipsum Dolor si Amet", R.drawable.weddingflower));
        dataModels.add(new DataModel("Title 16", "Lorem Ipsum Dolor si Amet", R.drawable.weddingflower));


        //LinearLayoutManager -> Diatur kiri ke kanan, atau atas bawah, tapi per "bagian" hanya ada satu yang di render
        //GridLayoutManager -> Satu row, bisa lebih dari satu item

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        DataModelAdapter dataModelAdapter = new DataModelAdapter(dataModels, this);

        rv.setAdapter(dataModelAdapter);
        rv.setLayoutManager(layoutManager);

    }
}

class DataModelAdapter extends RecyclerView.Adapter<DataModelViewHolder> {

    ArrayList<DataModel> dataModels;
    Context context;

    public DataModelAdapter(ArrayList<DataModel> dataModels, Context context){
        this.dataModels = dataModels;
        this.context = context;
    }

    @NonNull
    @Override
    public DataModelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.activity_listview, parent, false);

        return new DataModelViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataModelViewHolder holder, int position) {
        DataModel dm = dataModels.get(position);

        holder.titleTextView.setText(dm.getTitle());
        holder.subTitleTextView.setText(dm.getSubTitle());
        holder.imageView.setImageResource(dm.getImageId());

        holder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(String.valueOf(context));

                Bundle params = new Bundle();

                params.putString("tilte", dm.getTitle());
                params.putString("subtitle", dm.getSubTitle());
                params.putInt("DrawableId", dm.getImageId());

                intent.putExtras(params);
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return dataModels.size();
    }
}

class DataModelViewHolder extends RecyclerView.ViewHolder {

    TextView titleTextView;
    TextView subTitleTextView;
    ImageView imageView;

    View rootView;

    public DataModelViewHolder(@NonNull View itemView) {
        super(itemView);
        rootView = itemView;
        titleTextView = itemView.findViewById(R.id.activity_listview_holder_title_view);
        subTitleTextView = itemView.findViewById(R.id.activity_listview_holder_sub_title_view);
        imageView = itemView.findViewById(R.id.profile_picture_image_view);
    }
}


class DataModel {

    private String title;
    private String subTitle;

    private int imageId;

    public DataModel(String title, String subTitle, int imageId) {
        this.title = title;
        this.subTitle = subTitle;
        this.imageId = imageId;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}