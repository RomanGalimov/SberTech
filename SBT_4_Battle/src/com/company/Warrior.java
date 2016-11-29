package com.company;

/**
 * Created by dmitr on 22.11.2016.
 */
public interface Warrior {

    int attack();
    void takeDamage(int Damage);
    boolean isAlive();
    void setSquadName(String Name);
    Object clone();



}
