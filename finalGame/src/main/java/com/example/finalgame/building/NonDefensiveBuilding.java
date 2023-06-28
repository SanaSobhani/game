package com.example.finalgame.building;

public abstract class NonDefensiveBuilding extends Building{
    public NonDefensiveBuilding(int levelOfHealth,String filePath){
        super(false,levelOfHealth,filePath);
    }
}