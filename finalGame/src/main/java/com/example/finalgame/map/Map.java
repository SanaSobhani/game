package com.example.finalgame.map;

import com.example.finalgame.building.Building;
import com.example.finalgame.player.Player;

import java.util.ArrayList;

public abstract class Map {
    private ArrayList<Building>buildings;
    private Player player;
    private static int mapID =0;
    private int id;
    public Map(int id){
        buildings = new ArrayList<>();
        //id = mapID ++;
        this.id = id;
    }

    public static int getMapID() {
        return mapID;
    }

    public static void setMapID(int mapID) {
        Map.mapID = mapID;
    }

    public ArrayList<Building> getBuildings() {
        return buildings;
    }

    public void setBuildings(ArrayList<Building> buildings) {
        this.buildings = buildings;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
