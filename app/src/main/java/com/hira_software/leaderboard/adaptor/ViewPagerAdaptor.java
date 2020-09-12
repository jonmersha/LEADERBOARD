package com.hira_software.leaderboard.adaptor;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdaptor extends FragmentPagerAdapter {
            private final  List<Fragment> fragmentList=new ArrayList<>();
            private final List<String> fragmentTitle=new ArrayList<>();

    public ViewPagerAdaptor(FragmentManager fm) {
        super(fm);
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    public String getFragmentTitle(int position) {
        return fragmentTitle.get(position);
    }
    public void addFragment(Fragment fragment,String title){
        fragmentList.add(fragment);
        fragmentTitle.add(title);


    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentTitle.get(position);
    }
}
