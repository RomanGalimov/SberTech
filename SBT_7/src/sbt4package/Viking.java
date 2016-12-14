package sbt4package;

/**
 * Created by dmitr on 22.11.2016.
 */
public class Viking implements Warrior, Cloneable {
    private int damage = 10;
    private int health = 70;
    private String squadName;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public Viking(String name, String sqName) {
        this.squadName = sqName;
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
    public void setSquadName(String name) {
        squadName = name;
    }

    public String getSquadName() {
        return squadName;
    }

    @Override
    public String toString() {
        return name + "\n Класс: Викинг \n Название отряда:" + squadName;
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
