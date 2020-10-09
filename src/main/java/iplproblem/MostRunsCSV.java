package iplproblem;
import com.opencsv.bean.CsvBindByName;
public class MostRunsCSV {

    @CsvBindByName(column = "PLAYER",required = true)
    public String playerName;

    @CsvBindByName(column = "Mat",required = true)
    public int matchPlayed;

    @CsvBindByName(column = "Inns",required = true)
    public int inningsPlayed;

    @CsvBindByName(column = "Runs",required = true)
    public int runs;

    @CsvBindByName(column = "HS",required = true)
    public String highestScore;

    @CsvBindByName(column = "Avg",required = true)
    public double average;

    @CsvBindByName(column = "SR",required = true)
    public double strikeRate;

    @CsvBindByName(column = "4s",required = true)
    public int boundaries;

    @CsvBindByName(column = "6s",required = true)
    public int sixers;

    @CsvBindByName(column = "100",required = true)
    public int hundreds;

    @CsvBindByName(column = "50",required = true)
    public int fifty;

    @Override
    public String toString() {
        return "MostRunsCSV{" +
                "Player Name='" + playerName + '\'' +
                ", Match Played='" + matchPlayed + '\'' +
                ", Innings Played='" + inningsPlayed + '\'' +
                ", Runs='" + runs + '\'' +
                ", Highest Score='" + highestScore + '\'' +
                ", Average='" + average + '\'' +
                ", SR='" + strikeRate + '\'' +
                ", 4s='" + boundaries + '\'' +
                ", 6s='" + sixers + '\'' +
                ", 100='" + hundreds + '\'' +
                '}';
    }
}
