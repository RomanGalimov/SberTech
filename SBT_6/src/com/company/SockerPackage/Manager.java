package com.company.SockerPackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

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
        for (int i = 0; i < team.size(); i++) {
            if (team.get(i).getNickName().equals(name)) {
                return team.get(i);
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
        for (int i = 0; i < team.size(); i++) {
            if (team.get(i).getNickName().equals(name)) {
                Integer p = team.get(i).getPoints();
                team.get(i).setPoints(p + points);
            }
        }
    }

    public void sortSockerLeague(League league) {

        Collections.sort(getPlayers(league), new Comparator<SockerPlayer>() {
            @Override
            public int compare(SockerPlayer o1, SockerPlayer o2) {
                return o2.getPoints().compareTo(o1.getPoints());
            }
        });

        System.out.println(league.toString());
        for (SockerPlayer sc : leagueTeam) {
            System.out.println(sc.getNickName() + "\n очки: " + sc.getPoints() + "\n Страна: "+ sc.getCountry());
        }
    }

    public void sortSockerCountry(Country country) {

        Collections.sort(getPlayer(country), new Comparator<SockerPlayer>() {
            @Override
            public int compare(SockerPlayer o1, SockerPlayer o2) {
                return o2.getPoints().compareTo(o1.getPoints());
            }
        });

        System.out.println(country.toString());
        for (SockerPlayer sc : countryTeam) {
            System.out.println(sc.getNickName() + "\n очки: " + sc.getPoints()+"\n Лига: "+ sc.getLeague());
        }
    }


    public void setTeam(ArrayList<SockerPlayer> team) {
        this.team = team;
    }
}
