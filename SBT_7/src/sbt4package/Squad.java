package sbt4package;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by dmitr on 22.11.2016.
 */
public class Squad implements Cloneable {

    private String nameSquad;
    private ArrayList<Warrior> massWarior = new ArrayList<>();

    public ArrayList<Warrior> getMassWarior() {
        return massWarior;
    }

    public void setMassWarior(ArrayList massWarior) {
        this.massWarior = massWarior;
    }


    public Squad(String nameSquad) {
        this.nameSquad = nameSquad;
    }


    public Warrior getRandomWarior() {
        Random r = new Random();
        return massWarior.get(r.nextInt(massWarior.size()));
    }

    public boolean hasAliveWariors() {
        int j = 0;
        for (int i = 0; i < massWarior.size(); i++) {
            if (massWarior.get(i).isAlive()) {
                j++;
            } else {
                massWarior.remove(i);
            }
        }
        if (j != 0) {
            return true;
        } else return false;
    }

    @Override
    public String toString() {
        return nameSquad;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        //скопировали объект
        Squad cloneSq = (Squad) super.clone();
        //создали новый массив с бойцами
        ArrayList<Warrior> br = new ArrayList<>();

        massWarior.forEach((Warrior wr) -> br.add((Warrior) wr.clone()));
//        for (int i = 0; i < massWarior.size(); i++) {
//            //получили ссылку у клона на бойца, и присвоили ее новому объекту
//            Warrior wr = massWarior.get(i);
//            br.add((Warrior) wr.clone());
//        }
        //заменили массив с бойцами (ссылку)
        cloneSq.setMassWarior(br);
        return cloneSq;
    }


    public String getNameSquad() {
        return nameSquad;
    }

    public void setNameSquad(String nameSquad) {
        this.nameSquad = nameSquad;
    }
}
