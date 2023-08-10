package com.example.myapplication.UserInterface;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.adapter.NewsAdapter;
import com.example.myapplication.data.Article;
import com.example.myapplication.network.ApiManager;
import com.example.myapplication.viewmodel.MyViewModel;

import java.util.List;

public class HomePageActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private NewsAdapter newsAdapter;
    ApiManager apiManager;

    private MyViewModel viewModel;

    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        viewModel = new ViewModelProvider(this).get(MyViewModel.class);
        viewModel.fetchData().subscribe(responseModel -> {
            recyclerView = findViewById(R.id.newsRecyclerView);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            List<Article> newsItems = responseModel.getArticles();
            newsAdapter = new NewsAdapter(newsItems);
            recyclerView.setAdapter(newsAdapter);
        }, throwable -> {
            Toast.makeText(this,"Something went wrong",Toast.LENGTH_SHORT).show();
        });

       /* apiManager.makeApiCall()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        response -> {

                        },
                        throwable -> {

                        }
                );*/

    }
}