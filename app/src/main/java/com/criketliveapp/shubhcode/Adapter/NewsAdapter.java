package com.criketliveapp.shubhcode.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.criketliveapp.shubhcode.Model.News;
import com.criketliveapp.shubhcode.R;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyVh> {
    Context context;
    ArrayList<News> newsArrayList= new ArrayList<>();

    public NewsAdapter(Context context, ArrayList<News> newsArrayList) {
        this.context = context;
        this.newsArrayList = newsArrayList;
    }

    @NonNull
    @Override
    public MyVh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_top_stories_card, parent, false);


        return new MyVh(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyVh holder, int position) {
        holder.tvTitle.setText(newsArrayList.get(position).getTitle());
        holder.tvDescription.setText(newsArrayList.get(position).getDescription());
        Glide.with(context).load(newsArrayList.get(position).getUrlToImage()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return newsArrayList.size();
    }

    public class MyVh extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView tvTitle, tvDescription;

        public MyVh(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.ivTopStory);
            tvTitle = itemView.findViewById(R.id.tvTopTitle);
            tvDescription = itemView.findViewById(R.id.tvTopDescription);
        }
    }
}
