package com.example.finalgame.building;

import javafx.scene.image.Image;

public abstract class DefensiveBuilding extends Building{
    private int attackPower;
    private Image fire;
    public DefensiveBuilding(int levelOfHealth,int attackPower,String filePath,String filePath2){
      super(true,levelOfHealth,filePath);
      this.attackPower = attackPower;
      this.fire = new Image(filePath2);
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public Image getFire() {
        return fire;
    }

    public void setFire(Image fire) {
        this.fire = fire;
    }
}
