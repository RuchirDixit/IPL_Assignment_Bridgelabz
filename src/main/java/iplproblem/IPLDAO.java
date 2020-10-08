package iplproblem;

public class IPLDAO {

    public String playerName;
    public int matchPlayed;
    public int inningsPlayed;
    public int runs;
    public String highestScore;
    public double average;
    public double strikeRate;
    public int boundaries;
    public int sixers;
    public int wickets;
    public double overs;

    public IPLDAO(MostRunsCSV mostRunsCSV){
        this.playerName = mostRunsCSV.playerName;
        this.matchPlayed = mostRunsCSV.matchPlayed;
        this.inningsPlayed = mostRunsCSV.inningsPlayed;
        this.runs = mostRunsCSV.runs;
        this.highestScore = mostRunsCSV.highestScore;
        this.average = mostRunsCSV.average;
        this.strikeRate = mostRunsCSV.strikeRate;
        this.boundaries = mostRunsCSV.boundaries;
        this.sixers = mostRunsCSV.sixers;
    }

    public IPLDAO(MostWicketsCSV mostWicketsCSV){
        this.playerName = mostWicketsCSV.playerName;
        this.matchPlayed = mostWicketsCSV.matchPlayed;
        this.inningsPlayed = mostWicketsCSV.inningsPlayed;
        this.wickets = mostWicketsCSV.wickets;
        this.overs = mostWicketsCSV.overs;
    }
}
