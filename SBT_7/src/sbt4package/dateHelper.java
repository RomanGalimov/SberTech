package sbt4package;

import java.util.Calendar;

/**
 * Created by dmitr on 22.11.2016.
 */
public class dateHelper {

    Calendar cal = Calendar.getInstance();
    String dStart = cal.getTime().toString();
    private int i = 2;
    private int longTimeBattle = 0;

    public dateHelper() {
        cal.add(cal.YEAR, -1500);

    }

    public String getFormattedStartDate() {
        return "Начало боя: " + dStart + " Раунд 1!";
    }

    public void skipTime() {
        cal.add(cal.MINUTE, 45);
        longTimeBattle += 45;
        Battle.listBattle.add("Раунд №" + i + "\n Начало в: " + cal.getTime());
        i++;
    }

    public String getFormattedDiff() {
        return String.valueOf(longTimeBattle); //предполагалось вывести нормальную длительность в днях, часах и минутах
    }
}
