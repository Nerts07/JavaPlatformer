package com.platformer2d;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.platformer2d.Manager.PreferenceManager;
import com.platformer2d.Manager.ResourceManager;
import com.platformer2d.audioEngine.AudioLogic;
import com.platformer2d.audioEngine.AudioObserver;
import com.platformer2d.world.GameMap;
import com.platformer2d.world.MainMenu;
import com.platformer2d.world.TileType;
import com.platformer2d.world.TiledGameMap;

import java.util.Vector;

public class SimplePlat extends ApplicationAdapter
{
	SpriteBatch batch;
	Texture img;
	OrthographicCamera cam;
	GameMap gameMap;
	ExtendViewport viewport;
	private PreferenceManager preferenceManager = new PreferenceManager();
	private ResourceManager resourceManager;
	private MainMenu mainMenu;
	AudioObserver serv;

	@Override
	public void create ()
	{
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		cam = new OrthographicCamera();
		cam.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		cam.update();
		gameMap = new TiledGameMap();
		viewport = new ExtendViewport(800,600);
	}
	public PreferenceManager getPreferenceManager(){
		return preferenceManager;
	}

	@Override
	public void render ()
	{
		serv = new AudioLogic();
		resourceManager = new ResourceManager();
		ScreenUtils.clear(0f, 0.5f, 0.5f, 1);
		if (Gdx.input.isTouched())
		{
			cam.translate(-Gdx.input.getDeltaX(), Gdx.input.getDeltaY());
			cam.update();
		}

		mainMenu = new MainMenu(this, resourceManager) {
			@Override
			public void addObserver(AudioObserver audioObserver) {

			}

			@Override
			public void removeObserver(AudioObserver audioObserver) {

			}

			@Override
			public void Notify(AudioObserver.AudioCommand command, AudioObserver.audioTracks audioObserver) {

			}

			@Override
			public void removeAllObservers() {

			}
		};

		if (Gdx.input.justTouched())
		{
			Vector3 pos = cam.unproject((new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0)));
			TileType type = gameMap.getTileTypeByTheLocation(1, pos.x, pos.y);
			if(type != null)
			{
				System.out.println("tile ID is: " + type.getId() + ", Name of Object is: " +
						type.getName() + ", is collidable? " + type.isCollidable() + ", Damage: " + type.getDamage());
			}
			cam.update();

		}

		gameMap.render(cam);
	}
	
	@Override
	public void dispose ()
	{
		batch.dispose();
		img.dispose();
	}
}
