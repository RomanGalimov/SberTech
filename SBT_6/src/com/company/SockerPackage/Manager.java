package com.company.SockerPackage;

import java.util.*;

/**
 * Created by dmitr on 03.12.2016.
 */
public class Manager implements LeagueManager {
    private ArrayList<SockerPlayer> team = new ArrayList<>();
    private ArrayList<SockerPlayer> countryTeam = new ArrayList<>();
    private ArrayList<SockerPlayer> leagueTeam = new ArrayList<>();

    @Override
    public void addPlayer(SockerPlayer player) {
        team.add(player);
    }

    @Override
    public void removePlayer(SockerPlayer player) {
        team.remove(player);
    }

    @Override
    public SockerPlayer getPlayer(String name) {

        Iterator<SockerPlayer> iterator = team.iterator();

        while (iterator.hasNext()) {
            SockerPlayer sc = iterator.next();
            if (sc.getNickName().equals(name)) {
                return sc;
            }
        }
        return null;
    }

    @Override
    public ArrayList<SockerPlayer> getAllPlayers() {
        return team;
    }

    @Override
    public ArrayList<SockerPlayer> getPlayers(League league) {

        for (SockerPlayer e : team) {
            if (e.getLeague().equals(league)) {
                leagueTeam.add(e);
            }
        }
        return leagueTeam;
    }

    @Override
    public ArrayList<SockerPlayer> getPlayer(Country country) {
        for (SockerPlayer e : team) {
            if (e.getCountry().equals(country)) {
                countryTeam.add(e);
            }
        }
        return countryTeam;
    }

    @Override
    public void addPoints(String name, int points) {

        Iterator<SockerPlayer> iterator = team.iterator();

        while (iterator.hasNext()) {
            SockerPlayer sc = iterator.next();
            if (sc.getNickName().equals(name)) {
                Integer p = sc.getPoints();
                sc.setPoints(p + points);
            }
        }
    }

    public void sortSockerLeague(League league) {

        Collections.sort(getPlayers(league), (o1, o2) -> o2.getPoints().compareTo(o1.getPoints()));

        System.out.println(league.toString());
        for (SockerPlayer sc : leagueTeam) {
            System.out.println(sc.getNickName() + "\n очки: " + sc.getPoints() + "\n Страна: " + sc.getCountry());
        }
    }

    public void sortSockerCountry(Country country) {

        Collections.sort(getPlayer(country), (o1, o2) -> o2.getPoints().compareTo(o1.getPoints()));

        System.out.println(country.toString());
        for (SockerPlayer sc : countryTeam) {
            System.out.println(sc.getNickName() + "\n очки: " + sc.getPoints() + "\n Лига: " + sc.getLeague());
        }
    }


    public void setTeam(ArrayList<SockerPlayer> team) {
        this.team = team;
    }
}
