package sbt4package;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * Created by dmitr on 22.11.2016.
 */
public class Squad implements Cloneable {

    private String nameSquad;
    private ArrayList<Warrior> massWarrior = new ArrayList<>();

    public void addMassWarrior(Warrior wr) {
        massWarrior.add(wr);
    }

    public void setMassWarrior(ArrayList massWarrior) {
        this.massWarrior = massWarrior;
    }


    public Squad(String nameSquad) {
        this.nameSquad = nameSquad;
    }


    public Warrior getRandomWarrior() {
        if (hasAliveWarriors()) {
            Random r = new Random();
            return massWarrior.get(r.nextInt(massWarrior.size()));
        }
        return null;
    }

    public boolean hasAliveWarriors() {

        Iterator<Warrior> iterator = massWarrior.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            if (!iterator.next().isAlive()) {
                iterator.remove();
            } else i++;
        }
        return i != 0;
     //   return massWarrior.stream().allMatch(Warrior::isAlive);
    }

    @Override
    public String toString() {
        return nameSquad;
    }

    @Override
    protected Squad clone() throws CloneNotSupportedException {
        Squad cloneSq = (Squad) super.clone();
        ArrayList<Warrior> br = new ArrayList<>();
        massWarrior.forEach((Warrior wr) -> br.add((Warrior) wr.clone()));
        cloneSq.setMassWarrior(br);
        return cloneSq;
    }


    public String getNameSquad() {
        return nameSquad;
    }

    public void setNameSquad(String nameSquad) {
        this.nameSquad = nameSquad;
    }
}
