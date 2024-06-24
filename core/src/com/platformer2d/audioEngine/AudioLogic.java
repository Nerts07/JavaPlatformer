package com.platformer2d.audioEngine;

import com.badlogic.gdx.audio.Music;
import com.platformer2d.Manager.PreferenceManager;
import com.platformer2d.Manager.ResourceManager;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.util.Hashtable;

public class AudioLogic implements AudioObserver
{
    private static final Logger LOGGER = LoggerFactory.getLogger(AudioLogic.class);
    private Music currentMusic;
    private Hashtable<String, Music> queueMusic;
    private static AudioLogic instance = null;

    public AudioLogic()
    {
        this.queueMusic = queueMusic;
    }
    public static AudioLogic getInstance()
    {
        if (instance == null)
        {
            instance = new AudioLogic();
        }

        return instance;
    }

    private void checkOutMusicIsPlaying(Music music)
    {
        if (!PreferenceManager.getInstance().isMusicEnabled()) {
            music.stop();
        } else {
            music.play();
        }
    }

    public Music getCurrentMusic()
    {
        return currentMusic;
    }

    public void setCurrentMusic(Music currentMusic)
    {
        this.currentMusic = currentMusic;
    }



    @Override
    public void SamadRapper(AudioCommand command, audioTracks tracks)
    {
        switch (command)
        {
            case MUSIC_LOAD:
                ResourceManager.loadMusicAsset(tracks.getAudio());
        }
    }


}
