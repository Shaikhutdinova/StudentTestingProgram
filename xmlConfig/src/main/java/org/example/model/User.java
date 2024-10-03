package org.example.model;

public class User {
    private String name;
    private int points;
    private String group;

    public User(String name, String group, int points) {
        this.name = name;
        this.points = points;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPoints(int points) {
        this.points += points;
    }

    public int getPoints() {
        return points;
    }

    public String getGroup() {
        return group;
    }

}
