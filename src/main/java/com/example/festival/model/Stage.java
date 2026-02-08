package com.example.festival.model;

public class Stage extends BaseEntity {
    private int capacity;

    public Stage(int id, String name, int capacity){
        super(id, name);
        this.capacity = capacity;
    }

    @Override
    public boolean isValid() {
        return capacity > 0;
    }

    @Override
    public String getSummary() {
        return getName() + " | capacity = " + capacity;
    }
}
