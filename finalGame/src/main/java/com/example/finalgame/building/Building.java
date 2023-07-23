package com.example.finalgame.building;

import javafx.scene.image.Image;

public abstract class Building extends Image {
    private boolean isDefensive;
    private int levelOfHealth;
    public Building(boolean isDefensive,int levelOfHealth,String filePath){
        super(filePath);
        this.isDefensive = isDefensive;
        this.levelOfHealth = levelOfHealth;
    }
    public boolean isDefensive() {
        return isDefensive;
    }

    public void setDefensive(boolean defensive) {
        isDefensive = defensive;
    }

    public int getLevelOfHealth() {
        return levelOfHealth;
    }

    public void setLevelOfHealth(int levelOfHealth) {
        this.levelOfHealth = levelOfHealth;
    }
}
