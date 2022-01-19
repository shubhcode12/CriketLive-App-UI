package com.criketliveapp.shubhcode.ui.home;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.criketliveapp.shubhcode.Adapter.NewsAdapter;
import com.criketliveapp.shubhcode.Model.MainNews;
import com.criketliveapp.shubhcode.Model.News;
import com.criketliveapp.shubhcode.R;
import com.criketliveapp.shubhcode.Utils.ApiUtils;
import com.criketliveapp.shubhcode.databinding.FragmentHomeBinding;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private String apiKey= "6dbce6158f6149f992b009b6bfb79b6a";
    ArrayList<News> newsArrayList;
    NewsAdapter newsAdapter;
    String country = "in";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        newsArrayList = new ArrayList<>();
        newsAdapter = new NewsAdapter(root.getContext(), newsArrayList);
        binding.rvNews.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.rvNews.setAdapter(newsAdapter);
        binding.rvNews.setOnClickListener(view -> {
            Toast.makeText(getActivity(), "rv clicked", Toast.LENGTH_SHORT).show();
        });
        getNews();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void getNews(){
        ApiUtils.getApiInterface().getCategoryNews(country, "sports",3, apiKey).enqueue(new Callback<MainNews>() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onResponse(Call<MainNews> call, Response<MainNews> response) {
                if (response.isSuccessful()){
                    newsArrayList.addAll(response.body().getArticles());
                    newsAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<MainNews> call, Throwable t) {
                Toast.makeText(getActivity(), "" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}