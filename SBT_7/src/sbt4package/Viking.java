package sbt4package;

/**
 * Created by dmitr on 22.11.2016.
 */
public class Viking implements Warrior, Cloneable {
    private int damage = 10;
    private int health = 70;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public Viking(String name) {
        this.name = name;
    }

    @Override
    public int attack() {
        return damage;
    }

    @Override
    public void takeDamage(int Damage) {
        health -= Damage;
        if (health <= 0) {
            Battle.listBattle.add("Боец " + name + "\n погиб!!!");
        }
    }

    @Override
    public boolean isAlive() {
        if (health <= 0) {
            return false;
        } else
            return true;
    }


    @Override
    public String toString() {
        return name + "\n Класс: Викинг";
    }

    @Override
    public Viking clone() {
        try {
            return (Viking) super.clone();
        } catch (CloneNotSupportedException ex) {
            throw new InternalError();
        }
    }
}
