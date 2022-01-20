package com.criketliveapp.shubhcode;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.criketliveapp.shubhcode.databinding.ActivityNewsDetailBinding;

public class NewsDetailActivity extends AppCompatActivity {
    ActivityNewsDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNewsDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            binding.tvTitleNews.setText(extras.getString("title"));
            binding.tvDescription.setText(extras.getString("description"));
            Glide.with(getApplicationContext()).load(extras.getString("image")).into(binding.ivNewsDetail);
        } else {
            Toast.makeText(getApplicationContext(), "error while getting values : null extras", Toast.LENGTH_SHORT).show();
        }


    }
}