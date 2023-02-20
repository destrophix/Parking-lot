package org.example.model;

public class Counter {
    static private int id = 1;
    static int generateId(){
        return id++;
    }
}
