package com.criketliveapp.shubhcode.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.criketliveapp.shubhcode.Model.News;
import com.criketliveapp.shubhcode.NewsDetailActivity;
import com.criketliveapp.shubhcode.R;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyVh> {
    Context context;
    ArrayList<News> newsArrayList = new ArrayList<>();
    String type;
    View view;

    public NewsAdapter(Context context, ArrayList<News> newsArrayList, String type) {
        this.context = context;
        this.newsArrayList = newsArrayList;
        this.type = type;
    }

    @NonNull
    @Override
    public MyVh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (type.equals("top")) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_top_stories_card, parent, false);

        } else if (type.equals("more")) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_more_news_card, parent, false);

        }


        return new MyVh(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyVh holder, int position) {
        holder.tvTitle.setText(newsArrayList.get(position).getTitle());
        holder.tvDescription.setText(newsArrayList.get(position).getDescription());
        Glide.with(context).load(newsArrayList.get(position).getUrlToImage()).diskCacheStrategy(DiskCacheStrategy.ALL).placeholder(R.drawable.newsplaceholder).into(holder.imageView);
        holder.imageView.setOnClickListener(view1 -> {
            Intent intent = new Intent(context, NewsDetailActivity.class);
            intent.putExtra("title", newsArrayList.get(position).getTitle());
            intent.putExtra("description", newsArrayList.get(position).getDescription());
            intent.putExtra("image", newsArrayList.get(position).getUrlToImage());
            intent.putExtra("url", newsArrayList.get(position).getUrl());
            context.startActivity(intent);

        });
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
            imageView = itemView.findViewById(R.id.ivStory);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDescription = itemView.findViewById(R.id.tvDescription);
        }
    }
}
