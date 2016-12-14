package sbt4package;

import java.util.ArrayList;
import java.util.Random;

public class Battle {
    public static ArrayList<String > listBattle=new ArrayList<>();
//    public static   ArrayList<String> methodBattle(Squad SquadTeam1, Squad SquadTeam2) {
    public static BattleInterface battleInterface=(SquadTeam1,SquadTeam2)->{ //функции добавлены для упрощения кода, а не для усложнения. переделать обычным методом.
        dateHelper dt = new dateHelper();
        boolean Win = false;
        listBattle.add(dt.getFormattedStartDate()); //это лучше инкапсулировать в статический метод, напр Battle.log(String event)
        while (!Win) {//получили рандомных бойцов
            try {
                Warrior team1Wr = SquadTeam1.getRandomWarior(); //нужно проверить вариант, когда бойцов в каком-либо отряде нет
                Warrior team2Wr = SquadTeam2.getRandomWarior();
                listBattle.add("\n Боец команды " + SquadTeam2.getNameSquad() + " атакует! \n Он нанес урона: " + team2Wr.attack());
                team1Wr.takeDamage(team2Wr.attack());
                dt.skipTime();
                dt.getFormattedDiff();


                if (SquadTeam1.hasAliveWariors()) {
                    listBattle.add("\n В команде " + SquadTeam1.getNameSquad() + " еще есть живые бойцы!");
                } else {
                    listBattle.add("\n В команде " + SquadTeam1.getNameSquad() + " живых бойцов нет!\n Бой длился:" + dt.getFormattedDiff() + " минут!");
                    break;
                }

                team1Wr = SquadTeam1.getRandomWarior(); //копипаста. вынести в отдельный метод
                team2Wr = SquadTeam2.getRandomWarior();
                listBattle.add("\n Боец команды" + SquadTeam1.getNameSquad() + " атакует! \n Он нанес урона: " + team1Wr.attack());
                team2Wr.takeDamage(team1Wr.attack());
                dt.skipTime();
                dt.getFormattedDiff();

                if (SquadTeam2.hasAliveWariors()) {
                    listBattle.add("\n В команде " + SquadTeam2.getNameSquad() + " еще есть живые бойцы!");
                    Win = false;
                } else {
                    listBattle.add("\n В команде " + SquadTeam2.getNameSquad() + " живых бойцов нет!\n Бой длился:" + dt.getFormattedDiff() + " минут!");

                    Win = true;
                }
            } catch (IndexOutOfBoundsException ex) { //нельзя допускать возникновения этой ошибки
                listBattle.add("\n    "+SquadTeam1.getMassWarior().toString()+"        "+SquadTeam2.getMassWarior().toString());
            }
        }
        return listBattle;
    };
}
