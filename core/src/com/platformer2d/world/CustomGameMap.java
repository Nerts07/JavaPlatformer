package com.platformer2d.world;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.platformer2d.world.customgamemap.CustomGameMapData;
import com.platformer2d.world.customgamemap.CustomGameMapLoader;

public class CustomGameMap extends GameMap
{

    String id;
    String name;
    int[][][] map;


    private TextureRegion[][] tiles;

    public CustomGameMap () {
        CustomGameMapData data = CustomGameMapLoader.loadMap("basic", "My Grass Lands!");
        this.id = data.id;
        this.name = data.name;
        this.map = data.map;

        tiles = TextureRegion.split(new Texture("tiles.png"), TileType.TILE_SIZE, TileType.TILE_SIZE);
    }

    @Override
    public void render(OrthographicCamera camera) {

    }

    @Override
    public void update(float DeltaTime) {
        super.update(DeltaTime);
    }

    @Override
    public void dispose() {

    }

    @Override
    public TileType getTileTypeByTheLocation(int layer, float x, float y) {
        return super.getTileTypeByTheLocation(layer, x, y);
    }

    @Override
    public TileType getTileTypeBeTheCoordinate(int layer, int col, int row) {
        if (col < 0 || col >= getWidth() || row < 0 || row >= getHeight())
            return null;

        return TileType.getTileTypeById(map[layer][getHeight() - row - 1][col]);
    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public int getLayers() {
        return 0;
    }

    @Override
    protected TileType getTileTypeByCoordinate(int layer, int col, int row) {
        return null;
    }
}
