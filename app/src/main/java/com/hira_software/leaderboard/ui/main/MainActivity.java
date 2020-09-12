package com.hira_software.leaderboard.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.hira_software.leaderboard.ProjectSubmission;
import com.hira_software.leaderboard.R;
import com.hira_software.leaderboard.adaptor.ViewPagerAdaptor;
import com.hira_software.leaderboard.ui.tabed_fragment.TopLearner_IQ;
import com.hira_software.leaderboard.ui.tabed_fragment.TopLearner_hour;

public class MainActivity extends AppCompatActivity {



    private TabLayout tabLayout;
    private AppBarLayout appBarLayout;
    private ViewPager viewPager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tablayout);
        appBarLayout = findViewById(R.id.appbar);
        viewPager = findViewById(R.id.vpager);

        String learninigTab="Learning Leaders";
        String IQtab="Skill IQ Leaders";
        ViewPagerAdaptor viewPagerAdaptor=new ViewPagerAdaptor(getSupportFragmentManager());

        viewPagerAdaptor.addFragment(new TopLearner_hour(),learninigTab);
        viewPagerAdaptor.addFragment(new TopLearner_IQ(),IQtab);

        viewPager.setAdapter(viewPagerAdaptor);
        tabLayout.setupWithViewPager(viewPager);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.main_menu,menu);
        return true;
    }


    public void submitProject(MenuItem item) {
        Intent intent=new Intent(this, ProjectSubmission.class);
        startActivity(intent);
    }
}