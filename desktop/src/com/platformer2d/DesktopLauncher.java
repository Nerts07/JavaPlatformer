package com.platformer2d;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.platformer2d.SimplePlat;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg)
	{
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(1000);
		config.setTitle("SimplePlatformer");
		config.setWindowedMode(800,600);
		new Lwjgl3Application(new SimplePlat(), config);
	}
}
