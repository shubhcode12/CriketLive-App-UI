package com.criketliveapp.shubhcode.ui.home;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import com.criketliveapp.shubhcode.Adapter.NewsAdapter;
import com.criketliveapp.shubhcode.Model.MainNews;
import com.criketliveapp.shubhcode.Model.News;
import com.criketliveapp.shubhcode.Utils.ApiUtils;
import com.criketliveapp.shubhcode.databinding.FragmentHomeBinding;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    ArrayList<News> newsArrayList, moreNewsArrayList;
    NewsAdapter newsAdapter, moreAdapter;
    String country = "in";
    String topType = "top";
    String moreType = "more";
    String category ="sports";
    private FragmentHomeBinding binding;
    private final String apiKey = "6dbce6158f6149f992b009b6bfb79b6a";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        newsArrayList = new ArrayList<>();
        newsAdapter = new NewsAdapter(root.getContext(), newsArrayList, topType);
        binding.rvTopNews.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.rvTopNews.setAdapter(newsAdapter);

        moreNewsArrayList = new ArrayList<>();
        moreAdapter = new NewsAdapter(root.getContext(), moreNewsArrayList, moreType);
        binding.rvMoreNews.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.rvMoreNews.setAdapter(moreAdapter);

        getNews(newsAdapter);
        getMoreNews(moreAdapter);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void getNews(Adapter adapter) {
        ApiUtils.getApiInterface().getCategoryNews(country, category, 3, apiKey).enqueue(new Callback<MainNews>() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onResponse(Call<MainNews> call, Response<MainNews> response) {
                if (response.isSuccessful()) {
                    newsArrayList.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<MainNews> call, Throwable t) {
                Toast.makeText(getActivity(), "" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    void getMoreNews(Adapter adapter) {
        ApiUtils.getApiInterface().getCategoryNews("", category, 10, apiKey).enqueue(new Callback<MainNews>() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onResponse(Call<MainNews> call, Response<MainNews> response) {
                if (response.isSuccessful()) {
                    moreNewsArrayList.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<MainNews> call, Throwable t) {
                Toast.makeText(getActivity(), "" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}