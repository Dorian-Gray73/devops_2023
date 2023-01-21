package me.escoffier.workshop.fight;

public class Fight {

    public Personnage hero;
    public Personnage villain;

    public String winner;

    public Fight() {
        // USed by mapper
    }

    public Fight(Personnage h, Personnage v, String w) {
        hero = h;
        villain = v;
        winner = w;
    }

}
