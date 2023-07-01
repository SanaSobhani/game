package com.example.finalgame.player;

import com.example.finalgame.dataBase.DataBase;
import com.example.finalgame.map.Map;

import java.sql.SQLException;
import java.util.ArrayList;

public class Player {
    private String ID;
    private String password;
    private int level;
    private int numberOfWins;
    private int numberOfLosses;
    private Map map;
    public static DataBase dataBase;

    static {
        try {
            dataBase = new DataBase();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Player(String ID,String password) throws SQLException, ClassNotFoundException {
        this.ID = ID;
        this.password = password;
        dataBase.saveInfoToDataBase(ID,password);
    }
    public static boolean logIn(String passWord) throws SQLException {
        if(dataBase!=null){
            System.out.println("***"); //*****************************************************************************
        ArrayList<String>passWords = dataBase.select();
        for(String pointer : passWords) {
            System.out.println(pointer); //***************************************************************************
            if(pointer.equals(passWord))
                return true;
        }
        }
        return false;
    }
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getNumberOfWins() {
        return numberOfWins;
    }

    public void setNumberOfWins(int numberOfWins) {
        this.numberOfWins = numberOfWins;
    }

    public int getNumberOfLosses() {
        return numberOfLosses;
    }

    public void setNumberOfLosses(int numberOfLosses) {
        this.numberOfLosses = numberOfLosses;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }
}
