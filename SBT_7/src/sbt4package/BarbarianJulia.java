package sbt4package;

/**
 * Created by dmitr on 22.11.2016.
 */
public class BarbarianJulia implements Warrior, Cloneable {

    private int Damage = 5; //с маленькой буквы
    private int Health = 50;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public BarbarianJulia(String name) {
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
        }
    }

    @Override
    public boolean isAlive() {
        if (Health <= 0) {
            return false;
        } else
            return true;
    }


    @Override
    public String toString() {
        return name + "\n Класс: ВарЮльвар";
    }

    @Override
    public BarbarianJulia clone() {
        try {
            return (BarbarianJulia) super.clone();
        } catch (CloneNotSupportedException ex) {
            throw new InternalError();
        }
    }
}
