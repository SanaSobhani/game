package com.example.finalgame.hero;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class Hero extends Image{
    private int AttackPower;
    private int levelOfHealth;
    private Image fire;
    public Hero(int AttackPower,int levelOfHealth,String filePath,String firePath){
        super(filePath);
        this.levelOfHealth = levelOfHealth;
        this.AttackPower = AttackPower;
        fire = new Image(firePath);
    }
    public int getAttackPower() {
        return AttackPower;
    }

    public void setAttackPower(int attackPower) {
        AttackPower = attackPower;
    }

    public int getLevelOfHealth() {
        return levelOfHealth;
    }

    public void setLevelOfHealth(int levelOfHealth) {
        this.levelOfHealth = levelOfHealth;
    }

    public Image getFire() {
        return fire;
    }

    public void setFire(Image fire) {
        this.fire = fire;
    }
}
