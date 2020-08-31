package com.example.gadsleardersboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.os.Handler;
import android.widget.TableLayout;

import com.example.gadsleardersboard.ui.SectionsPageAdapter;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.tabs);

        getTabs();


    }

    private void getTabs() {
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                SectionsPageAdapter sectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());
                sectionsPageAdapter.addFragment(LearnersFragment.newInstance(),"Learning Leaders");
                sectionsPageAdapter.addFragment(SkillIQFragment.newInstance(),"Skill IQ Leaders");

                viewPager.setAdapter(sectionsPageAdapter);
                tabLayout.setupWithViewPager(viewPager);
            }
        });
    }
}