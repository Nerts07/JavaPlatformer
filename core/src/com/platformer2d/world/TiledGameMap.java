package com.platformer2d.world;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;


public class TiledGameMap  extends GameMap
{
    TiledMap tiledmap;
    OrthogonalTiledMapRenderer tiledMapRenderer;


    public TiledGameMap()
    {
        tiledmap = new TmxMapLoader().load("map.tmx");
        tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledmap);
    }


    @Override
    public void render(OrthographicCamera camera)
    {
        tiledMapRenderer.setView(camera);
        tiledMapRenderer.render();
    }

    @Override
    public void update(float DeltaTime)
    {

    }

    @Override
    public void dispose()
    {
        tiledmap.dispose();
    }

    @Override
    public TileType getTileTypeBeTheCoordinate(int layer, int col, int row)
    {
        com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell cell = ((TiledMapTileLayer)
                tiledmap.getLayers().get(layer)).getCell(col, row);

        if (cell != null)
        {
            TiledMapTile tile = cell.getTile();

            if (tile != null)
            {
                int id = tile.getId();
                return TileType.getTileTypeById(id);
            }
        }

        return null;
    }

    @Override
    public int getWidth()
    {
        return ((TiledMapTileLayer) tiledmap.getLayers().get(0)).getWidth();
    }

    @Override
    public int getHeight()
    {
        return ((TiledMapTileLayer) tiledmap.getLayers().get(0)).getHeight();
    }

    @Override
    public int getLayers()
    {
        return tiledmap.getLayers().getCount();
    }
}