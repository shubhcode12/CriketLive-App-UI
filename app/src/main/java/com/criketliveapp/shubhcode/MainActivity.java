package com.criketliveapp.shubhcode;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.criketliveapp.shubhcode.ui.live.LiveFragment;
import com.criketliveapp.shubhcode.ui.home.HomeFragment;
import com.criketliveapp.shubhcode.ui.matches.MatchesFragment;
import com.criketliveapp.shubhcode.ui.polls.PollsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.criketliveapp.shubhcode.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener , NavigationBarView.OnItemReselectedListener {

    ActivityMainBinding binding;
    BottomNavigationView navView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        toolbar = (Toolbar) findViewById(R.id.toolbarMain);
        setSupportActionBar(toolbar);
        navView = findViewById(R.id.nav_view);
        navView.setOnItemSelectedListener(this);
        navView.setOnItemReselectedListener(this);
        displayFragment(new HomeFragment());


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.maine_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.action_setting){
            startActivity(new Intent(MainActivity.this, SettingActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment;
        switch (item.getItemId()) {
            case R.id.navigation_home:
                fragment = new HomeFragment();
                break;
            case R.id.navigation_live:
                fragment = new LiveFragment();
                break;
            case R.id.navigation_matches:
                fragment = new MatchesFragment();
                break;
            case R.id.navigation_polls:
                fragment = new PollsFragment();
                break;
            default:
                fragment = new HomeFragment();
                break;
        }
        displayFragment(fragment);
        return true;
    }

    public void displayFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_container, fragment)
                .commit();
    }

    @Override
    public void onNavigationItemReselected(@NonNull MenuItem item) {

    }
}