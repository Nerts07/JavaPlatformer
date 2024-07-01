package com.platformer2d.audioEngine;

import com.badlogic.gdx.audio.Music;
import com.platformer2d.Manager.PreferenceManager;
import com.platformer2d.Manager.ResourceManager;

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

    private void checkOutMusicIsPlaying(Music music)
    {
        if (!PreferenceManager.getInstance().isMusicEnabled())
        {
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
                PreferenceManager.getMusicVolume();
            break;

            case MUSIC_PLAY_ONCE:
                playMusic(false, tracks.getAudio());
            break;

            case MUSIC_PLAY_LOOP:
                playMusic(true, tracks.getAudio());
            break;

            case MUSIC_STOP:
                Music music = queueMusic.get(tracks.getAudio());
                if (music != null){
                    music.stop();
                }
            break;

            case MUSIC_STOP_ALL:
                for (Music musicstop : queueMusic.values()){
                    musicstop.stop();
                }
            break;

            default:
                throw new IllegalStateException("Unexpected value: " + command);
        }
    }

    private void playMusic(boolean isLooping, String fullFilePath)
    {
        Music music = queueMusic.get(fullFilePath);
        if (music != null)
        {
            music.setLooping(isLooping);
            music.setVolume(PreferenceManager.getMusicVolume());
            checkOutMusicIsPlaying(music);
            setCurrentMusic(music);

        }
        else if (ResourceManager.isAssetLoaded(fullFilePath))
        {
            music = ResourceManager.getMusicAsset(fullFilePath);
            music.setLooping(isLooping);
            music.setVolume(PreferenceManager.getMusicVolume());
            checkOutMusicIsPlaying(music);
            queueMusic.put(fullFilePath, music);
            setCurrentMusic(music);
        }
    }

    public void dispose()
    {
        for (Music music: queueMusic.values())
        {
            music.dispose();
        }
    }
}
