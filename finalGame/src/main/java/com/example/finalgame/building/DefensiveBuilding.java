package com.example.finalgame.building;

public abstract class DefensiveBuilding extends Building{
    private int attackPower;
    public DefensiveBuilding(int levelOfHealth,int attackPower,String filePath){
      super(true,levelOfHealth,filePath);
      this.attackPower = attackPower;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }
}
