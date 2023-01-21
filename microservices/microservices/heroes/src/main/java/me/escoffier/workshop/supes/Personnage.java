package me.escoffier.workshop.supes;

public interface Personnage{
    Personnage findRandom();

    String getName();

    int realStreng(int adjust);

    String toString();
}