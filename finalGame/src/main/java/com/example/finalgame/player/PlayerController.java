package com.example.finalgame.player;

public class PlayerController {
   // private static Player playerPointer;
    private static String passWordPointer;

    public static String getPassWord() {
        return passWordPointer;
    }

    public static void setPassWord(String passWord) {
        PlayerController.passWordPointer = passWord;
    }

 /*   public Player getPlayerPointer() {
        return playerPointer;
    }

    public void setPlayerPointer(Player playerPointer) {
        this.playerPointer = playerPointer;
    }*/
}
