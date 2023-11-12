package com.jaybothra.flutefusion.ViewPager;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.jaybothra.flutefusion.R;

public class CustomViewPagerAdapter extends FragmentStateAdapter {

    public CustomViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        position = position % 7;
        switch (position){
            case 0: return MaintainFragment.newInstance("", R.mipmap.ic_launcher, "", "", "");
            case 1: return MaintainFragment.newInstance(" ", R.mipmap.ic_launcher, "", "", "");
            case 2: return MaintainFragment.newInstance("   ", R.mipmap.ic_launcher, "", "", "");
            case 3: return MaintainFragment.newInstance("  ", R.mipmap.ic_launcher, "", "", "");
            case 4: return MaintainFragment.newInstance(" m", R.mipmap.ic_launcher, "", "", "");
            case 5: return MaintainFragment.newInstance(" a", R.mipmap.ic_launcher, "", "", "");
            case 6: return MaintainFragment.newInstance(" e", R.mipmap.ic_launcher, "", "", "");
            default: return MaintainFragment.newInstance("404 Error", R.mipmap.ic_launcher, "", "", "");
        }
    }

    @Override
    public int getItemCount() {
        return Integer.MAX_VALUE;
//        return 7;
    }
}
