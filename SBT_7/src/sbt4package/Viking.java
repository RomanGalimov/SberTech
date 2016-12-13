package sbt4package;

/**
 * Created by dmitr on 22.11.2016.
 */
public class Viking implements Warrior, Cloneable {
    private int damage = 10;
    private int health = 70;
    private boolean life = true;
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
            life = false;
        }
    }

    @Override
    public boolean isAlive() {
        return life;
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
    public Object clone() {
        try {
            Viking e = (Viking) super.clone();
            return e;
        } catch (CloneNotSupportedException ex) {
            throw new InternalError();
        }
    }
}
