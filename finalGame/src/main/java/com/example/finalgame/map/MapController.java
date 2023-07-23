package com.example.finalgame.map;

public class MapController {
    private static Map mapPointer;


    public static Map getMapPointer() {
        return mapPointer;
    }

    public static void setMapPointer(Map map) {
        mapPointer = map;
    }
}
