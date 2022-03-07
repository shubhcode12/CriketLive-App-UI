package com.criketliveapp.shubhcode.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.criketliveapp.shubhcode.R;
import com.criketliveapp.shubhcode.databinding.ItemScoreboardBinding;
import com.smarteist.autoimageslider.SliderViewAdapter;

public class ScoreSliderAdapter extends SliderViewAdapter<ScoreSliderAdapter.SliderViewHolder> {
    ItemScoreboardBinding itemScoreboardBinding;

    @Override
    public ScoreSliderAdapter.SliderViewHolder onCreateViewHolder(ViewGroup parent) {
        itemScoreboardBinding = ItemScoreboardBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        //View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_scoreboard, null);
        return new SliderViewHolder(itemScoreboardBinding);
    }

    @Override
    public void onBindViewHolder(ScoreSliderAdapter.SliderViewHolder viewHolder, int position) {

    }

    @Override
    public int getCount() {
        return 0;
    }

    public static class SliderViewHolder extends SliderViewAdapter.ViewHolder {
        ItemScoreboardBinding scoreboardBinding;

        public SliderViewHolder(ItemScoreboardBinding binding) {
            super(binding.getRoot());
            scoreboardBinding = binding;
        }
    }
}
