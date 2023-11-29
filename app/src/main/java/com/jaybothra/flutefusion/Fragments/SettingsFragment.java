package com.jaybothra.flutefusion.Fragments;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceManager;
import androidx.preference.SwitchPreferenceCompat;
import com.jaybothra.flutefusion.R;
import com.jaybothra.flutefusion.RecyclerView.StoreFragment;

public class SettingsFragment extends PreferenceFragmentCompat {
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey);

        ListPreference audioPreference = findPreference("selected_audio");
        if (audioPreference != null) {
            audioPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
                @Override
                public boolean onPreferenceChange(Preference preference, Object newValue) {
                    String selectedAudio = (String) newValue;
                    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(requireContext());
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("selected_audio_key", selectedAudio);
                    editor.apply();
                    return true;
                }
            });
        }
    }
}

