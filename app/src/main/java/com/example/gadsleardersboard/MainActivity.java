package com.example.gadsleardersboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import com.example.gadsleardersboard.ui.ProjectSubmissionActivity;
import com.example.gadsleardersboard.ui.learning.LearnersFragment;
import com.example.gadsleardersboard.ui.SectionsPageAdapter;
import com.example.gadsleardersboard.ui.SkillIQFragment;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private Button mSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.tabs);

        mSubmit = findViewById(R.id.submit);
        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ProjectSubmissionActivity.class);
                startActivity(intent);
            }
        });

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