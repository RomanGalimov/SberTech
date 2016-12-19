package sbt4package;

/**
 * Created by dmitr on 22.11.2016.
 */
public interface Warrior {

    int attack();
    void takeDamage(int Damage);
    boolean isAlive();
    Object clone();



}
