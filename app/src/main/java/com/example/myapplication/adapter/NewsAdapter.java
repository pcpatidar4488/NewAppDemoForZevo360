package com.example.myapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.data.Article;
import com.example.myapplication.imagecache.ImageUtils;

import java.util.List;

import io.reactivex.rxjava3.annotations.NonNull;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private List<Article> newsItems;

    public NewsAdapter(List<Article> newsItems) {
        this.newsItems = newsItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Article newsItem = newsItems.get(position);

        holder.titleTextView.setText(newsItem.getTitle());
        ImageUtils.loadImage(newsItem.urlToImage, holder.newsImageView);
        holder.descriptionTextView.setText(newsItem.getDescription());
    }

    @Override
    public int getItemCount() {
        return newsItems.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView;
        ImageView newsImageView;
        TextView descriptionTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.newsTitleTextView);
            newsImageView = itemView.findViewById(R.id.newsImageView);
            descriptionTextView = itemView.findViewById(R.id.newsDetailsTextView);
        }
    }
}
