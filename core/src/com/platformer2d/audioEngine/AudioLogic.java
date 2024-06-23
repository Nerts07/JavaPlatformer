package com.platformer2d.audioEngine;

import com.badlogic.gdx.audio.Music;

import java.util.Hashtable;

public class AudioLogic implements AudioObserver
{

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


    public Music getCurrentMusic()
    {
        return currentMusic;
    }

    public void setCurrentMusic(Music currentMusic)
    {
        this.currentMusic = currentMusic;
    }

    private void checkOutMusicIsPlaying(Music music)
    {

    }

    @Override
    public void SamadRapper(AudioCommand command, audioTracks tracks)
    {

    }


}
