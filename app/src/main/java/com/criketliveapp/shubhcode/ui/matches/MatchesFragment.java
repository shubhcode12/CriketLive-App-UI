package com.criketliveapp.shubhcode.ui.matches;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.criketliveapp.shubhcode.databinding.FragmentMatchesBinding;
import com.google.android.material.tabs.TabLayout;

public class MatchesFragment extends Fragment {

    private FragmentMatchesBinding binding;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentMatchesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();



        binding.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == 0) {
                    binding.rvAllMatches.setVisibility(View.VISIBLE);
                    binding.rvT20Matches.setVisibility(View.GONE);
                    binding.rvTOdiMatches.setVisibility(View.GONE);
                    binding.rvTestMatches.setVisibility(View.GONE);
                } else if (tab.getPosition() == 1) {
                    binding.rvT20Matches.setVisibility(View.VISIBLE);
                    binding.rvAllMatches.setVisibility(View.GONE);
                    binding.rvTOdiMatches.setVisibility(View.GONE);
                    binding.rvTestMatches.setVisibility(View.GONE);
                } else if (tab.getPosition() == 2) {
                    binding.rvTOdiMatches.setVisibility(View.VISIBLE);
                    binding.rvAllMatches.setVisibility(View.GONE);
                    binding.rvT20Matches.setVisibility(View.GONE);
                    binding.rvTestMatches.setVisibility(View.GONE);
                } else if (tab.getPosition() == 3) {
                    binding.rvTestMatches.setVisibility(View.VISIBLE);
                    binding.rvAllMatches.setVisibility(View.GONE);
                    binding.rvT20Matches.setVisibility(View.GONE);
                    binding.rvTOdiMatches.setVisibility(View.GONE);
                }


            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        return root;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}