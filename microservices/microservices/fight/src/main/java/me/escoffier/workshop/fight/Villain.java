package me.escoffier.workshop.fight;

public class Villain{

    public String name;
    public String otherName;
    public int level;
    public String picture;
    public String powers;
    public Long id;

    @Override
    public String toString() {
        return "Villain{" +
                ", name='" + name + '\'' +
                ", otherName='" + otherName + '\'' +
                ", level=" + level +
                ", picture='" + picture + '\'' +
                ", powers='" + powers + '\'' +
                '}';
    }
}
