package com.company.SockerPackage;

/**
 * Created by dmitr on 03.12.2016.
 */
public class Socker implements SockerPlayer {

    private String nickName;
    private Country country;
    private League league;
    private Integer points;

    public Socker(String nickName, Country country, League league, Integer points) {
        this.nickName = nickName;
        this.country = country;
        this.league = league;
        this.points = points;


    }

    @Override
    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public Country getCountry() {
        return country;
    }

    @Override
    public void setPoints(Integer points) {
        this.points = points;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }

    @Override
    public Integer getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

}
