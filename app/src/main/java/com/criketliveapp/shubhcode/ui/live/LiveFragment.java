package com.criketliveapp.shubhcode.ui.live;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.criketliveapp.shubhcode.databinding.FragmentLiveBinding;


public class LiveFragment extends Fragment {

     FragmentLiveBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentLiveBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        String btext = binding.cb.getText().toString();
        Toast.makeText(getActivity(), "" + btext, Toast.LENGTH_SHORT).show();

        return root;
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}