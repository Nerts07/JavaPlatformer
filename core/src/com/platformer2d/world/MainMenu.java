package com.platformer2d.world;


import com.badlogic.gdx.utils.Array;
import com.platformer2d.Manager.ResourceManager;
import com.platformer2d.SimplePlat;
import com.platformer2d.audioEngine.AudioLogic;
import com.platformer2d.audioEngine.AudioObserver;
import com.platformer2d.audioEngine.AudioSubject;

import static com.platformer2d.audioEngine.AudioObserver.audioTracks.FUKUMEAN;
public abstract class MainMenu implements AudioSubject
{
    protected AudioObserver.audioTracks musicTheme;
    private Array<AudioObserver> observers;

    public MainMenu(SimplePlat simplePlat, ResourceManager resourceManager)
    {
        this.musicTheme = FUKUMEAN;
        this.addObserver(AudioLogic.getInstance());
    }

    public AudioObserver.audioTracks getMusicTheme() {
        return musicTheme;
    }

    @Override
    public void addObserver(AudioObserver audioObserver) {
        observers.add(audioObserver);
    }
}
