package com.example.offlinenewsreader;

import android.os.Bundle;
import android.widget.Toast;

import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;

import java.net.URL;

public class SettingsFragment extends PreferenceFragmentCompat implements Preference.OnPreferenceChangeListener {


    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.news_prefs);
        getPreferenceScreen().findPreference("webview_url").setSummary(getPreferenceScreen().findPreference("webview_url").getSharedPreferences().getString("webview_url", "https://news.ycombinator.com/"));
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {
        preference.setSummary(newValue.toString());

        return true;
    }
}
