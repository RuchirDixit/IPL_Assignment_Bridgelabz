package iplproblem;
import com.opencsv.bean.CsvBindByName;
public class MostWicketsCSV {
    @CsvBindByName(column = "PLAYER",required = true)
    public String playerName;

    @CsvBindByName(column = "Mat",required = true)
    public int matchPlayed;

    @CsvBindByName(column = "Inns",required = true)
    public int inningsPlayed;

    @CsvBindByName(column = "Wkts",required = true)
    public int wickets;

    @CsvBindByName(column = "OV",required = true)
    public double overs;

    @CsvBindByName(column = "Avg",required = true)
    public double average;

    @CsvBindByName(column = "SR",required = true)
    public double strikeRate;

    @CsvBindByName(column = "Econ",required = true)
    public double economyRate;

    @CsvBindByName(column = "4w",required = true)
    public int fourW;
    @CsvBindByName(column = "5w",required = true)
    public int fiveW;


    @Override
    public String toString() {
        return "MostRunsCSV{" +
                "Player Name='" + playerName + '\'' +
                ", Match Played='" + matchPlayed + '\'' +
                ", Innings Played='" + inningsPlayed + '\'' +
                ", Wickets='" + wickets + '\'' +
                ", Overs='" + overs + '\'' +
                ", Average='" + average + '\'' +
                ", SR='" + strikeRate + '\'' +
                ", Econ ='" + economyRate + '\'' +
                ", 4W ='" + fourW + '\'' +
                ", 5W ='" + fiveW + '\'' +
                '}';
    }
}
