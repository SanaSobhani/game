package com.example.finalgame.player;

public class PlayerController {
   // private static Player playerPointer;
    private static String passWordPointer;
    private static Player pointer;

    public static String getPassWord() {
        return passWordPointer;
    }

    public static void setPassWord(String passWord) {
        PlayerController.passWordPointer = passWord;
    }

    public static Player getPointer() {
        return pointer;
    }

    public static void setPointer(Player pointer) {
        PlayerController.pointer = pointer;
    }

 /*   public Player getPlayerPointer() {
        return playerPointer;
    }

    public void setPlayerPointer(Player playerPointer) {
        this.playerPointer = playerPointer;
    }*/
}
