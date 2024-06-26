package com.platformer2d.world;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class GameMap
{


    public void render(OrthographicCamera camera, SpriteBatch batch) {
    }

    public abstract void render(OrthographicCamera camera);

    public void update(float DeltaTime) {
    }

    public abstract void dispose();

    public TileType getTileTypeByTheLocation(int layer, float x, float y)
    {
        return this.getTileTypeBeTheCoordinate(layer,
                (int) (x / TileType.TILE_SIZE),
                (int) (y / TileType.TILE_SIZE));
    }

    public abstract TileType getTileTypeBeTheCoordinate(int layer, int col, int row);

    public abstract int getWidth();
    public abstract int getHeight();
    public abstract int getLayers();

    protected abstract TileType getTileTypeByCoordinate(int layer, int col, int row);
}
