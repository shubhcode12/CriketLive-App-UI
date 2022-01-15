package com.criketliveapp.shubhcode.ui.more;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.criketliveapp.shubhcode.R;


public class MoreFragment extends Fragment {


    public MoreFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static com.criketliveapp.shubhcode.ui.polls.PollsFragment newInstance(String param1, String param2) {
        com.criketliveapp.shubhcode.ui.polls.PollsFragment fragment = new com.criketliveapp.shubhcode.ui.polls.PollsFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_polls, container, false);
    }
}