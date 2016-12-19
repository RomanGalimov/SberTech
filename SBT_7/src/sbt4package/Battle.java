package sbt4package;

import java.util.ArrayList;

public class Battle { //почему тут все статическое?
    public static ArrayList<String> listBattle = new ArrayList<>(); //почему public?

    public static ArrayList<String> methodBattle(Squad SquadTeam1, Squad SquadTeam2) { //по-прежнему нет проверки наличия бойцов в отрядах
        dateHelper dt = new dateHelper();
        boolean Win = false; //переменный принято называть с маленькой буквы
        log(dt.getFormattedStartDate());
        while (!Win) {//получили рандомных бойцов
            battleEvent(SquadTeam1, SquadTeam2, dt);

            if (SquadTeam1.hasAliveWarriors()) {
                log("\n В команде " + SquadTeam1.getNameSquad() + " еще есть живые бойцы!");
            } else {
                log("\n В команде " + SquadTeam1.getNameSquad() + " живых бойцов нет!\n Бой длился:" + dt.getFormattedDiff() + "!");
                break;
            }

            battleEvent(SquadTeam2, SquadTeam1, dt);

            if (SquadTeam2.hasAliveWarriors()) {
                log("\n В команде " + SquadTeam2.getNameSquad() + " еще есть живые бойцы!"); //опять дублирование
                Win = false;
            } else {
                log("\n В команде " + SquadTeam2.getNameSquad() + " живых бойцов нет!\n Бой длился:" + dt.getFormattedDiff() + "!");
                Win = true;
            }
        }
        return listBattle;
    }


    static void log(String event) {
        listBattle.add(event);
    }

    static void battleEvent(Squad SquadTeam1, Squad SquadTeam2, dateHelper dt) {
        Warrior team1Wr = SquadTeam1.getRandomWarrior();
        Warrior team2Wr = SquadTeam2.getRandomWarrior();
        log("\n Боец команды " + SquadTeam2.getNameSquad() + " атакует! \n Он нанес урона: " + team2Wr.attack());
        team1Wr.takeDamage(team2Wr.attack());
        dt.skipTime();
        //dt.getFormattedDiff();
    }
}
