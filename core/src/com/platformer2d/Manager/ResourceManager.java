package com.platformer2d.Manager;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.MusicLoader;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.audio.Music;


public class ResourceManager
{
    private static AssetManager assetManager = new AssetManager();
    private static InternalFileHandleResolver filePathResolver = new InternalFileHandleResolver();


    public static void loadMusicAsset(String musicFilenamePath)
    {
        if (musicFilenamePath == null || musicFilenamePath.isEmpty())
        {
            return;
        }

        if (assetManager.isLoaded(musicFilenamePath))
        {
            return;
        }

        //load asset
        if (filePathResolver.resolve(musicFilenamePath).exists())
        {
            assetManager.setLoader(Music.class, new MusicLoader(filePathResolver));
            assetManager.load(musicFilenamePath, Music.class);
            //Until we add loading screen, just block until we load the map
            assetManager.finishLoadingAsset(musicFilenamePath);
        }

    }

    public static boolean isAssetLoaded(String fileName)
    {
        return assetManager.isLoaded(fileName);
    }

    public static Music getMusicAsset(String musicFilenamePath)
    {
        Music music = null;

        // once the asset manager is done loading
        if (assetManager.isLoaded(musicFilenamePath))
        {
            music = assetManager.get(musicFilenamePath, Music.class);
        }

        return music;
    }

}
