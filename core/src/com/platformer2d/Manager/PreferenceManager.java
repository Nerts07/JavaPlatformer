package com.platformer2d.Manager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class PreferenceManager
{
    private static PreferenceManager instance = null;

    private static final String PREF_MUSIC_VOLUME = "music";
    private static final String PREF_MUSIC_ENABLED = "music.enabled";
    private static final String PREF_SOUND_ENABLED = "sound.enabled";
    private static final String PREF_SOUND_VOLUME = "sound";
    private static final String PREFS_NAME = "gdxGame";

    public static PreferenceManager getInstance() {
        if (instance == null) {
            instance = new PreferenceManager();
        }

        return instance;
    }

    public static Preferences getPrefs() {
        return Gdx.app.getPreferences(PREFS_NAME);
    }

    public boolean isMusicEnabled() {
        return getPrefs().getBoolean(PREF_MUSIC_ENABLED, true);
    }

    public static float getMusicVolume() {
        return getPrefs().getFloat(PREF_MUSIC_VOLUME, 0.5f);
    }

    public void setMusicVolume(float volume) {
        getPrefs().putFloat(PREF_MUSIC_VOLUME, volume);
        getPrefs().flush();
    }

}
