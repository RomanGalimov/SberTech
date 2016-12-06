package com.company;


import com.company.SockerPackage.*;

import java.util.*;

public class Main {


    public static void main(String[] args) {
        menu();
    }


    public static void menu() {
        Manager manager = new Manager();
        Random random = new Random();
        int size = random.nextInt(20);
        ArrayList<String> nameList = new ArrayList<>();
        nameList.add("Белорус");
        nameList.add("Погба");
        nameList.add("Дрогба");
        nameList.add("Руни");

        for (int i = 0; i < size; i++) {
            Integer point = random.nextInt(100);
            String name = nameList.get(random.nextInt(4));
            Country country = null;
            League league = null;
            int k = random.nextInt(4);
            if (k <= 1) {
                country = Country.BRAZIL;
                league = League.FIFA;
            }
            if (k == 2) {
                country = Country.RUSSIA;
                league = League.FIFA;
            }
            if (k == 3) {
                country = Country.UK;
                league = League.UEFA;
            }
            if (k == 4) {
                country = Country.USA;
                league = League.UEFA;
            }
            manager.getAllPlayers().add(new Socker(name, country, league, point));
        }


        manager.sortSockerLeague(League.FIFA);
        manager.sortSockerLeague(League.UEFA);
        manager.sortSockerCountry(Country.BRAZIL);
        manager.sortSockerCountry(Country.RUSSIA);
        manager.sortSockerCountry(Country.USA);
        manager.sortSockerCountry(Country.UK);


    }


}
