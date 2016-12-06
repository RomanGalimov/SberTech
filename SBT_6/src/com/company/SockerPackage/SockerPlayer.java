package com.company.SockerPackage;

/**
 * Created by dmitr on 03.12.2016.
 */
public interface SockerPlayer {
    String getNickName();

    Integer getPoints();

    League getLeague();

    Country getCountry();

    void setPoints(Integer points);
}
