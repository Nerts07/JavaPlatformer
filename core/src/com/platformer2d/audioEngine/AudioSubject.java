package com.platformer2d.audioEngine;

public interface AudioSubject
{
    void addObserver(AudioObserver audioObserver);
    void removeObserver(AudioObserver audioObserver);
    void Notify(AudioObserver.AudioCommand command, AudioObserver.audioTracks audioObserver);
    void removeAllObservers();
}
