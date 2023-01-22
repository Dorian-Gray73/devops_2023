package me.escoffier.workshop.supes;

import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
@Path("/")
public class Hero extends PanacheEntity implements Personnage{

    public String name;
    public String otherName;
    public int level;
    public String picture;

    @Column(columnDefinition = "TEXT")
    public String powers;

    @Override
    @GET
    @Path("/hero")
    public Personnage findRandom() {
        long countHeroes = Hero.count();
        Random random = new Random();
        int randomHero = random.nextInt((int) countHeroes);
        return (Personnage) Hero.findAll().page(randomHero, 1).firstResult();
    }

    @Override
    public String toString() {
        return "Hero{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", otherName='" + otherName + '\'' +
                ", level=" + level +
                ", picture='" + picture + '\'' +
                ", powers='" + powers + '\'' +
                '}';
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int realStreng(int adjust) {
        return level + adjust;
    }
}
