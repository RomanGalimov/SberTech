package com.company.SockerPackage;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by dmitr on 03.12.2016.
 */
public interface LeagueManager {
    void addPlayer(SockerPlayer player);

    void removePlayer(SockerPlayer player);

    SockerPlayer getPlayer(String name);

    Collection<SockerPlayer> getAllPlayers();

    Collection<SockerPlayer> getPlayers(League league);

    Collection<SockerPlayer> getPlayer(Country country);

    void addPoints(String name, int points);

    //void sortSocker(ArrayList<SockerPlayer> team);

}
