package com.platformer2d.audioEngine;

public interface AudioObserver
{
    void SamadRapper(AudioCommand command, audioTracks tracks);

    enum audioTracks{
        FUKUMEAN("Gunna-fukumean.mp3"),
        CONSCIENCE("Gunna-conscience.mp3"),
        BACKINTHEA("Gunna-back-in-the-a.mp3");


        private String audioFilePath;

        audioTracks(String audioFilePath)
        {
            this.audioFilePath = audioFilePath;
        }

        public String getAudio()
        {
            return audioFilePath;
        }
    }

    enum AudioCommand
    {
        MUSIC_LOAD,
        MUSIC_PLAY_ONCE,
        MUSIC_PLAY_LOOP,
        MUSIC_STOP,
        MUSIC_STOP_ALL
    }
}
