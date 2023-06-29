package com.example.finalgame.map;

import com.example.finalgame.building.Building;

import java.util.ArrayList;

public abstract class Map {
    private ArrayList<Building>buildings;
    public Map(){
        buildings = new ArrayList<>();
    }

    public ArrayList<Building> getBuildings() {
        return buildings;
    }

    public void setBuildings(ArrayList<Building> buildings) {
        this.buildings = buildings;
    }
}
