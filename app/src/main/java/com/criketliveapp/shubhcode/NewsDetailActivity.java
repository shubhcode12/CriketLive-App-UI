package com.criketliveapp.shubhcode;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;
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
        setSupportActionBar(binding.toolbarDetail);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);




        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            binding.tvTitleNews.setText(extras.getString("title"));
            binding.tvDescription.setText(extras.getString("description"));
            Glide.with(getApplicationContext()).load(extras.getString("image")).into(binding.ivNewsDetail);

            binding.webView.loadUrl(extras.getString("url"));
            binding.webView.setFocusable(true);
            binding.webView.setFocusableInTouchMode(true);
            binding.webView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
            binding.webView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
            binding.webView.getSettings().setDomStorageEnabled(true);
            binding.webView.getSettings().setDatabaseEnabled(true);
            binding.webView.getSettings().setAppCacheEnabled(true);
            binding.webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
            binding.webView.setWebViewClient(new WebViewClient());
        } else {
            Toast.makeText(getApplicationContext(), "error while getting values : null extras", Toast.LENGTH_SHORT).show();
        }


    }
}