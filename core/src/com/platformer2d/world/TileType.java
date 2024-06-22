package com.platformer2d.world;


import java.util.HashMap;

public enum TileType
{
    //enum
    GRASS(1, true, "Grass"),
    DIRT(2, true, "Dirt"),
    SKY(3,false,"Sky"),
    LAVA(4,true,"Lava"),
    CLOUD(5,false,"Cloud"),
    STONE(6,true,"Stone");

    //tile size of each texture from texture atlas
    public static final int TILE_SIZE = 16;

    //global vars
    private int      id;
    private boolean  collidable;
    private String   name;
    private float    damage;


    /*
        There is a HashMap, using for get ID from each Tile from the "ForEach Loop"
        at GameMap.java i put the "getTileTypeByTheLocation" method to get each tile from TILE_SIZE
     */
    private static HashMap<Integer, TileType> tilemap;

    static
    {
        tilemap = new HashMap<Integer, TileType>();
        for (TileType tiletyle : TileType.values())
        {
            tilemap.put(tiletyle.getId(), tiletyle);
        }
    }


    //Contructor of TileType
    private TileType(int id, boolean collidable, String name)
    {
        this(id, collidable, name, 0);
    }

    private TileType(int id, boolean collidable, String name, float damage)
    {
        this.id         =         id;
        this.collidable = collidable;
        this.name       =       name;
        this.damage     =     damage;
    }



    /*
        GETTERS
     */
    public static TileType getTileTypeById(int id)
    {
        return tilemap.get(id);
    }

    public int getId()
    {
        return id;
    }

    public boolean isCollidable()
    {
        return collidable;
    }

    public String getName()
    {
        return name;
    }

    public float getDamage()
    {
        return damage;
    }


}
