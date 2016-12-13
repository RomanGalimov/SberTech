package sbt4package;

/**
 * Created by dmitr on 22.11.2016.
 */
public class BarbarianJulia implements Warrior, Cloneable {

    private int Damage = 5;
    private int Health = 50;
    private boolean life = true;
    private String squadName;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public BarbarianJulia(String name, String sqName) {
        this.squadName = sqName;
        this.name = name;
    }

    @Override
    public int attack() {
        return Damage;
    }

    @Override
    public void takeDamage(int Damage) {
        Health -= Damage;
        if (Health <= 0) {
            Battle.listBattle.add("Боец " + name + "\n погиб!!!");
            life = false;
        }
    }

    @Override
    public boolean isAlive() {
        return life;
    }

    @Override
    public void setSquadName(String Name) {
        squadName = Name;
    }

    public String getSquadName() {
        return squadName;
    }

    @Override
    public String toString() {
        return name + "\n Класс: ВарЮльвар \n Название отряда:" + squadName;
    }

    @Override
    public Object clone() {
        try {
            BarbarianJulia e = (BarbarianJulia) super.clone();
            return e;
        } catch (CloneNotSupportedException ex) {
            throw new InternalError();
        }
    }
}
