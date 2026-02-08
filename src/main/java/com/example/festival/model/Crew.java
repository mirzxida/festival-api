package com.example.festival.model;

public class Crew extends BaseEntity{
    private String role;
    private Integer managerId;

    public Crew(int id, String name, String role, Integer managerId){
        super(id, name);
        this.role = role;
        this.managerId = managerId;
    }

    @Override
    public boolean isValid() {
        return getName() != null && role != null;
    }

    public boolean hasManager(){
        return managerId != null;
    }

    @Override
    public String getSummary() {
        return getName() + " - " + role;
    }
}
