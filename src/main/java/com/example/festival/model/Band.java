package com.example.festival.model;

import com.example.festival.utils.Printable;

public class Band extends BaseEntity implements Printable {
    private String country;
    private String genre;

    public Band(int id, String name, String country, String genre){
        super(id, name);
        this.country = country;
        this.genre = genre;
    }

    @Override
    public boolean isValid() {
        return getName() != null && !getName().isEmpty();
    }

    @Override
    public String getSummary() {
        return display() + " (" + genre + ") ";
    }

    @Override
    public String print() {
        return getSummary();
    }
}