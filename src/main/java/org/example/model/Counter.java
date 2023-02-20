package org.example.model;

public class Counter {
    static private int id = 0;
    static int generateId(){
        return id++;
    }

    public static void reset(){
        id = 0;
    }
}
