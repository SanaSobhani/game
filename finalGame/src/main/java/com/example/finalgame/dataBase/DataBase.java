package com.example.finalgame.dataBase;

import com.example.finalgame.player.Player;
import com.example.finalgame.player.PlayerController;

import java.sql.*;
import java.util.ArrayList;

public class DataBase {
    String URL = "jdbc:mysql://localhost/game"; // address of the database we use
    String UserName ="root";
    String PassWord ="sana";
    Connection connection;
    public DataBase() throws SQLException, ClassNotFoundException {
        connection = DriverManager.getConnection(URL , UserName , PassWord);
        Class.forName("com.mysql.cj.jdbc.Driver");
    }
    public void saveInfoToDataBase(String id, String passWord) throws SQLException, ClassNotFoundException {
        String sqlCmd =String.format("INSERT INTO `playersInfo` (`ID`, `password`) VALUES ('%s', '%s')" , id ,passWord);
        Statement statement = connection.prepareStatement(sqlCmd); // need statement to prepare command
        statement.execute(sqlCmd); // do the command
    }
    public void saveWinsToDataBase(int numberOfWins) throws SQLException {
        String sqlCmd =String.format("UPDATE playersinfo SET numberofwins ='%d ' WHERE password = %s" , numberOfWins, PlayerController.getPassWord());
        Statement statement = connection.prepareStatement(sqlCmd); // need statement to prepare command
        statement.execute(sqlCmd); // do the command
    }
    public void saveLossesToDataBase(int numberOfLosses) throws SQLException {
        String sqlCmd =String.format("UPDATE playersinfo SET numberoflosses = 'd%' WHERE password = %s" , numberOfLosses,PlayerController.getPassWord());
        Statement statement = connection.prepareStatement(sqlCmd); // need statement to prepare command
        statement.execute(sqlCmd); // do the command
    }
    public void saveMapToDataBase(int id,String passWord) throws SQLException {
       String sqlCmd =String.format("UPDATE playersinfo SET mapid = '%d' WHERE password = %s" , id,passWord);
       Statement statement = connection.prepareStatement(sqlCmd); // need statement to prepare command
        statement.execute(sqlCmd); // do the command
    }
    public void saveLevelToDataBase(int level) throws SQLException {
        String sqlCmd =String.format("UPDATE players info SET level = '%d' WHERE password = %s" , level,PlayerController.getPassWord());
        Statement statement = connection.prepareStatement(sqlCmd); // need statement to prepare command
        statement.execute(sqlCmd); // do the command
    }
    public ArrayList<String> select() throws SQLException {
        String sqlCmd ="SELECT password FROM playersinfo";
        Statement statement = connection.prepareStatement(sqlCmd);
        ResultSet resultSet = statement.executeQuery(sqlCmd);
        ArrayList<String>result = new ArrayList<>();
        while (resultSet.next()){
            result.add(resultSet.getString("password"));
        }
        return result;
    }
    }