package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Battle {

    public static void main(String[] args) throws CloneNotSupportedException {
        dateHelper dt = new dateHelper();
        ArrayList<Warrior> team1 = new ArrayList<>();
        ArrayList<Warrior> team2 = new ArrayList<>();
        Squad squadTeam1 = new Squad("Barbarian team");
        Squad squadTeam2 = new Squad("Julia team");
        BarbarianJulia bj = new BarbarianJulia("Варюля", "Barbarian team");
        BarbarianJulia bj1 = new BarbarianJulia("Варюльворвар", "Barbarian team");
        BarbarianJulia bj2 = new BarbarianJulia("Юльвар", "Julia team");
        BarbarianJulia bj3 = new BarbarianJulia("Юльворвар", "Julia team");
        Viking vk = new Viking("Кристиан", "Barbarian team");
        Viking vk1 = new Viking("Виктор", "Julia team");
        team1.add(bj);
        team1.add(bj1);
        team1.add(vk);

        team2.add(vk1);
        team2.add(bj2);
        team2.add(bj3);
        squadTeam1.setMassWarior(team1);
        squadTeam2.setMassWarior(team2);

        Battle.methodBattle(dt, squadTeam1, squadTeam2);


//--------------------------------Для проверки как работает клон
//        Squad newSq = (Squad) squadTeam1.clone();
//        System.out.println(squadTeam1.getMassWarior().get(1).toString());
//        System.out.println(newSq.getMassWarior().get(1).toString());
//
//        BarbarianJulia w= (BarbarianJulia) newSq.getMassWarior().get(1);
//        w.setName("keakdaed");
//
//        System.out.println(squadTeam1.getMassWarior().get(1).toString());
//        System.out.println(newSq.getMassWarior().get(1).toString());
//---------------------------------------------------------
    }

    public static void methodBattle(dateHelper dt, Squad SquadTeam1, Squad SquadTeam2) {
        boolean Win = false;

        Random random = new Random();
        System.out.println(dt.getFormattedStartDate());
        while (!Win) {//получили рандомных бойцов
            try {
                Warrior team1Wr = SquadTeam1.getRandomWarior();
                Warrior team2Wr = SquadTeam2.getRandomWarior();
                System.out.println("Боец команды " + SquadTeam2.toString() + " атакует! \n Он нанес урона: " + team2Wr.attack());
                team1Wr.takeDamage(team2Wr.attack());
                dt.skipTime();
                dt.getFormattedDiff();


                if (SquadTeam1.hasAliveWariors()) {
                    System.out.println("В команде " + SquadTeam1.toString() + " еще есть живые бойцы!");
                } else {
                    System.out.println("В команде " + SquadTeam1.toString() + " живых бойцов нет!\n Бой длился:" + dt.getFormattedDiff() + " минут!");
                    break;
                }

                team1Wr = SquadTeam1.getRandomWarior();
                team2Wr = SquadTeam2.getRandomWarior();
                System.out.println("Боец команды" + SquadTeam1.toString() + " атакует! \n Он нанес урона: " + team1Wr.attack());
                team2Wr.takeDamage(team1Wr.attack());
                dt.skipTime();
                dt.getFormattedDiff();

                if (SquadTeam2.hasAliveWariors()) {
                    System.out.println("В команде " + SquadTeam2.toString() + " еще есть живые бойцы!");
                    Win = false;
                } else {
                    System.out.println("В команде " + SquadTeam2.toString() + " живых бойцов нет!\n Бой длился:" + dt.getFormattedDiff() + " минут!");

                    Win = true;
                }
            } catch (IndexOutOfBoundsException ex) {
                System.out.println("    "+SquadTeam1.getMassWarior().toString()+"        "+SquadTeam2.getMassWarior().toString());
            }
        }
    }
}
