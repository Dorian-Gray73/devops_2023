package me.escoffier.workshop.fight;

public interface Personnage{
    Personnage findRandom();

    String getName();

    int realStreng(int adjust);

    String toString();
}