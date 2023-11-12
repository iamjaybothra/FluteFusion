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
        position = position % 6;
        switch (position){
            case 0: return MaintainFragment.newInstance(MaintainConsts.VP_TITLE1, MaintainConsts.VP_IMG1, "1. "+MaintainConsts.VP_TEXT1_1, "2. "+MaintainConsts.VP_TEXT2_1, "3. "+MaintainConsts.VP_TEXT3_1);
            case 1: return MaintainFragment.newInstance(MaintainConsts.VP_TITLE2, MaintainConsts.VP_IMG2, "1. "+MaintainConsts.VP_TEXT1_2, "2. "+MaintainConsts.VP_TEXT2_2, "3. "+MaintainConsts.VP_TEXT3_2);
            case 2: return MaintainFragment.newInstance(MaintainConsts.VP_TITLE3, MaintainConsts.VP_IMG3, "1. "+MaintainConsts.VP_TEXT1_3, "2. "+MaintainConsts.VP_TEXT2_3, "3. "+MaintainConsts.VP_TEXT3_3);
            case 3: return MaintainFragment.newInstance(MaintainConsts.VP_TITLE4, MaintainConsts.VP_IMG4, "1. "+MaintainConsts.VP_TEXT1_4, "2. "+MaintainConsts.VP_TEXT2_4, "3. "+MaintainConsts.VP_TEXT3_4);
            case 4: return MaintainFragment.newInstance(MaintainConsts.VP_TITLE5, MaintainConsts.VP_IMG5, "1. "+MaintainConsts.VP_TEXT1_5, "2. "+MaintainConsts.VP_TEXT2_5, "3. "+MaintainConsts.VP_TEXT3_5);
            case 5: return MaintainFragment.newInstance(MaintainConsts.VP_TITLE6, MaintainConsts.VP_IMG6, "1. "+MaintainConsts.VP_TEXT1_6, "2. "+MaintainConsts.VP_TEXT2_6, "3. "+MaintainConsts.VP_TEXT3_6);
            default: return MaintainFragment.newInstance("404 Error", R.mipmap.ic_launcher, "", "", "");
        }
    }

    @Override
    public int getItemCount() {
        return Integer.MAX_VALUE;
//        return 7;
    }
}
