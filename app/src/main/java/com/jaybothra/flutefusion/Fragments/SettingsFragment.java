package com.jaybothra.flutefusion.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.SwitchPreferenceCompat;

import com.jaybothra.flutefusion.R;
import com.jaybothra.flutefusion.RecyclerView.StoreFragment;
import com.jaybothra.flutefusion.ListView.StoreListFragment;

public class SettingsFragment extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey);

        SwitchPreferenceCompat switchPreference = findPreference("attachment");

        if (switchPreference != null) {
            switchPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
                @Override
                public boolean onPreferenceChange(Preference preference, Object newValue) {
                    if (preference.getKey().equals("attachment")) {
                        boolean isSwitchOn = (boolean) newValue;
                        loadFragment(isSwitchOn);
                    }
                    return true;
                }
            });
        }
    }

    private void loadFragment(boolean isSwitchOn) {
        Fragment newFragment;
        if (isSwitchOn) {
            newFragment = new StoreListFragment();
        } else {
            newFragment = new StoreFragment();
        }

        // Replace the current fragment with the new one
        getParentFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, newFragment) // Use the correct container ID
                .commit();
    }
}
