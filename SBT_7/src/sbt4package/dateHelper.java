package sbt4package;

import java.util.Calendar;

import static sbt4package.Battle.listBattle;

/**
 * Created by dmitr on 22.11.2016.
 */
public class dateHelper {

    Calendar cal = Calendar.getInstance();
    Calendar dStart = cal;
    private int i = 2;
    int longTimeBattle = 0;

    dateHelper() {
        cal.add(cal.YEAR, -1500);

    }

    public String getFormattedStartDate() {
        return "Начало боя: " + dStart.getTime().toString() + " Раунд 1!";
    }

    public void skipTime() {
        cal.add(cal.MINUTE, 45);
        longTimeBattle += 45;
        listBattle.add("Раунд №" + i + "\n Начало в: " + cal.getTime());
        i++;
    }

    public String getFormattedDiff() {
        return String.valueOf(longTimeBattle);
    }
}
