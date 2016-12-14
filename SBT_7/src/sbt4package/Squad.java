package sbt4package;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * Created by dmitr on 22.11.2016.
 */
public class Squad implements Cloneable {

    private String nameSquad;
    private ArrayList<Warrior> massWarior = new ArrayList<>();

    //-----------------------------------------------
    // нарушение инкапсуляции. это эквивалентно объявлению massWarior как public.
    // получить бойца мы должны смочь только одним способом - getRandomWarior().
    // в крайнем случае можно оставить метод добавления бойца в отряд, а еще лучше не давать и такой возможности, сразу принимая список в конструкторе.
    public ArrayList<Warrior> getMassWarior() {
        return massWarior;
    }

    public void setMassWarior(ArrayList massWarior) {
        this.massWarior = massWarior;
    }
    //-----------------------------------------------

    public Squad(String nameSquad) {
        this.nameSquad = nameSquad;
    }


    public Warrior getRandomWarior() {
        Random r = new Random();
        return massWarior.get(r.nextInt(massWarior.size()));
    }

    /*
     *   1. Зачем использовать счетчик? Достаточно одного мертвого, чтобы вернуть false
     *   2. Не стоит, проходя циклом по коллекции, удалять из него элементы. Это может привести к непредсказуемым последствиям в зависимости от конкретной коллекции. Для безопасной реализации нужно использовать итератор.
     *   3. В местах, где ожидается результат условия, не нужно дополнительно ни проверять его на true/false, не возвращать true/false. В данном случае сразу return j != 0;
     *   4. Ты искал места, где можно использовать функции... Этот метод является отличным примером.
     *   Все елементы коллекции должны удовлетворять условию - isAlive должен быть истиной. Переводя на java - return massWarior.stream().allMatch(Warrior::isAlive);
     */
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
        // к чему эти комментарии? разве без них не понятно, что происходит в этом методе??
        Squad cloneSq = (Squad) super.clone();
        //создали новый массив с бойцами
        ArrayList<Warrior> br = new ArrayList<>();

        massWarior.forEach((Warrior wr) -> br.add((Warrior) wr.clone()));
//        for (int i = 0; i < massWarior.size(); i++) { старый код нужно было удалить
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
        this.nameSquad = nameSquad; //нужно проставить имя бойцам
    }
}
