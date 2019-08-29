package com.santiagoaragon.statops;



public class Game {

    private int homeLogo, awayLogo;
    private String homeTeam, awayTeam;
    private String homeRecord, awayRecord;
    private double homeProbability, awayProbability;


    public Game(int homeLogo, int awayLogo, String homeTeam, String awayTeam, String homeRecord, String awayRecord, double homeProbability, double awayProbability){
        this.homeLogo = homeLogo;
        this.awayLogo = awayLogo;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeRecord = homeRecord;
        this.awayRecord =  awayRecord;
        this.homeProbability = homeProbability;
        this.awayProbability = awayProbability;
    }

    public int getHomeLogo(){
        return this.homeLogo;
    }

    public int getAwayLogo(){
        return this.awayLogo;
    }

    public String getHomeTeam(){
        return this.homeTeam;
    }

    public String getAwayTeam(){
        return this.awayTeam;
    }

    public String getHomeRecord(){
        return this.homeRecord;
    }

    public String getAwayRecord(){
        return this.awayRecord;
    }

    public double getHomeProbability(){
        return this.homeProbability;
    }

    public double getAwayProbability(){
        return this.awayProbability;
    }
}
