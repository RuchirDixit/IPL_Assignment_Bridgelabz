package iplproblem;

import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

public class IPLProblemTest {
    private static final String MOST_RUNS_CSV_FILE_PATH = "./src/test/resources/IPL2019FactsheetMostRuns.csv";
    private static final String MOST_WICKETS_CSV_FILE_PATH = "./src/test/resources/IPL2019FactsheetMostWkts.csv";

    //UC1
    @Test
    public void givenIPLRunsData_WhenSortedDescendingOnAverage_ShouldReturnCorrectPlayerName() {
        try {
            IPLAnalyzer iplAnalyzer = new IPLAnalyzer();
            iplAnalyzer.loadIplRunsData(MOST_RUNS_CSV_FILE_PATH);
            String sortedData = iplAnalyzer.getAverageWiseSorting();
            MostRunsCSV[] mostRunsCSV = new Gson().fromJson(sortedData, MostRunsCSV[].class);
            Assert.assertEquals("MS Dhoni", mostRunsCSV[0].playerName);
        } catch(IPLException e) {}
    }

    //UC2
    @Test
    public void givenIPLRunsData_WhenSortedDescendingOnStrikeRate_ShouldReturnCorrectPlayerName() {
        try {
            IPLAnalyzer iplAnalyzer = new IPLAnalyzer();
            iplAnalyzer.loadIplRunsData(MOST_RUNS_CSV_FILE_PATH);
            String sortedData = iplAnalyzer.getStrikeRateWiseSorting();
            MostRunsCSV[] mostRunsCSV = new Gson().fromJson(sortedData, MostRunsCSV[].class);
            Assert.assertEquals("Andre Russell", mostRunsCSV[0].playerName);
        } catch(IPLException e) {}
    }

    //UC3
    @Test
    public void givenIPLRunsData_WhenSortedDescendingOnMaximumSixes_ShouldReturnCorrectPlayerName() {
        try {
            IPLAnalyzer iplAnalyzer = new IPLAnalyzer();
            iplAnalyzer.loadIplRunsData(MOST_RUNS_CSV_FILE_PATH);
            String sortedData = iplAnalyzer.getMaximumSixesWiseSorting();
            MostRunsCSV[] mostRunsCSV = new Gson().fromJson(sortedData, MostRunsCSV[].class);
            Assert.assertEquals("Andre Russell", mostRunsCSV[0].playerName);
        } catch(IPLException e) {
        }
    }
    @Test
    public void givenIPLRunsData_WhenSortedDescendingOnMaximumFours_ShouldReturnCorrectPlayerName() {
        try {
            IPLAnalyzer iplAnalyzer = new IPLAnalyzer();
            iplAnalyzer.loadIplRunsData(MOST_RUNS_CSV_FILE_PATH);
            String sortedData = iplAnalyzer.getMaximumBoundariesWiseSorting();
            MostRunsCSV[] mostRunsCSV = new Gson().fromJson(sortedData, MostRunsCSV[].class);
            Assert.assertEquals("Shikhar Dhawan", mostRunsCSV[0].playerName);
        } catch(IPLException e) {
        }
    }

    //UC4
    @Test
    public void givenIPLRunsData_WhenSortedDescendingOnSRFourSix_ShouldReturnCorrectPlayerName() {
        try {
            IPLAnalyzer iplAnalyzer = new IPLAnalyzer();
            iplAnalyzer.loadIplRunsData(MOST_RUNS_CSV_FILE_PATH);
            String sortedDataSR = iplAnalyzer.getMaximumStrikeRateWithFoursAndSixWiseSorting();
            MostRunsCSV[] mostRunsSRCSV = new Gson().fromJson(sortedDataSR, MostRunsCSV[].class);
            Assert.assertEquals("Andre Russell", mostRunsSRCSV[0].playerName);
        } catch(IPLException e) {
        }
    }

    //UC5
    @Test
    public void givenIPLRunsData_WhenSortedDescendingOnAverageAndStrikeRate_ShouldReturnCorrectPlayerName() {
        try {
            IPLAnalyzer iplAnalyzer = new IPLAnalyzer();
            iplAnalyzer.loadIplRunsData(MOST_RUNS_CSV_FILE_PATH);
            String sortedDataSR = iplAnalyzer.getMaximumAverageWithStrikeRateWiseSorting();
            MostRunsCSV[] mostRunsAvgCSV = new Gson().fromJson(sortedDataSR, MostRunsCSV[].class);
            Assert.assertEquals("MS Dhoni", mostRunsAvgCSV[0].playerName);
        } catch(IPLException e) {
        }
    }

    //UC6
    @Test
    public void givenIPLRunsData_WhenSortedDescendingOnRunsAndAverages_ShouldReturnCorrectPlayerName() {
        try {
            IPLAnalyzer iplAnalyzer = new IPLAnalyzer();
            iplAnalyzer.loadIplRunsData(MOST_RUNS_CSV_FILE_PATH);
            String sortedDataSR = iplAnalyzer.getMaximumRunsWithAverageWiseSorting();
            MostRunsCSV[] mostRunsAvgCSV = new Gson().fromJson(sortedDataSR, MostRunsCSV[].class);
            Assert.assertEquals("Chris Gayle", mostRunsAvgCSV[0].playerName);
        } catch(IPLException e) {
        }
    }

    // UC7
    @Test
    public void givenIPLWicketsData_WhenSortedDescendingOnBowlingAverages_ShouldReturnCorrectPlayerName() {
        try {
            IPLAnalyzer iplAnalyzer = new IPLAnalyzer();
            iplAnalyzer.loadIplWicketsData(MOST_WICKETS_CSV_FILE_PATH);
            String sortedDataSR = iplAnalyzer.getMaximumWicketsWithAverageWiseSorting();
            MostWicketsCSV[] mostWicketsCSV = new Gson().fromJson(sortedDataSR, MostWicketsCSV[].class);
            Assert.assertEquals("Krishnappa Gowtham", mostWicketsCSV[0].playerName);
        } catch(IPLException e) {
        }
    }

    // UC8
    @Test
    public void givenIPLWicketsData_WhenSortedDescendingOnBowlingStrikeRate_ShouldReturnCorrectPlayerName() {
        try {
            IPLAnalyzer iplAnalyzer = new IPLAnalyzer();
            iplAnalyzer.loadIplWicketsData(MOST_WICKETS_CSV_FILE_PATH);
            String sortedDataSR = iplAnalyzer.getMaximumWicketsWithStrikeRateWiseSorting();
            MostWicketsCSV[] mostWicketsCSV = new Gson().fromJson(sortedDataSR, MostWicketsCSV[].class);
            Assert.assertEquals("Krishnappa Gowtham", mostWicketsCSV[0].playerName);
        } catch(IPLException e) {
        }
    }

    // UC9
    @Test
    public void givenIPLWicketsData_WhenSortedDescendingOnBowlingEconomyRate_ShouldReturnCorrectPlayerName() {
        try {
            IPLAnalyzer iplAnalyzer = new IPLAnalyzer();
            iplAnalyzer.loadIplWicketsData(MOST_WICKETS_CSV_FILE_PATH);
            String sortedDataSR = iplAnalyzer.getMaximumWicketsWithEconomyRateWiseSorting();
            MostWicketsCSV[] mostWicketsCSV = new Gson().fromJson(sortedDataSR, MostWicketsCSV[].class);
            Assert.assertEquals("Tim Southee", mostWicketsCSV[0].playerName);
        } catch(IPLException e) {
        }
    }

    //UC10
    @Test
    public void givenIPLWicketsData_WhenSortedDescendingOnStrikeRateWith4W5W_ShouldReturnCorrectPlayerName() {
        try {
            IPLAnalyzer iplAnalyzer = new IPLAnalyzer();
            iplAnalyzer.loadIplWicketsData(MOST_WICKETS_CSV_FILE_PATH);
            String sortedDataSR = iplAnalyzer.getMaximumWicketsSRWith4w5wWiseSorting();
            MostWicketsCSV[] mostWicketsCSV = new Gson().fromJson(sortedDataSR, MostWicketsCSV[].class);
            Assert.assertEquals("Krishnappa Gowtham", mostWicketsCSV[0].playerName);
        } catch(IPLException e) {
        }
    }

    //UC11
    @Test
    public void givenIPLWicketsData_WhenSortedDescendingOnBowlingAvgWithStrikeRate_ShouldReturnCorrectPlayerName() {
        try {
            IPLAnalyzer iplAnalyzer = new IPLAnalyzer();
            iplAnalyzer.loadIplWicketsData(MOST_WICKETS_CSV_FILE_PATH);
            String sortedDataSR = iplAnalyzer.getMaximumWicketAverageWithSRWiseSorting();
            MostWicketsCSV[] mostWicketsCSV = new Gson().fromJson(sortedDataSR, MostWicketsCSV[].class);
            Assert.assertEquals("Krishnappa Gowtham", mostWicketsCSV[0].playerName);
        } catch(IPLException e) {
        }
    }

    //UC12
    @Test
    public void givenIPLWicketsData_WhenSortedDescendingOnMaxWicketsWithAverage_ShouldReturnCorrectPlayerName() {
        try {
            IPLAnalyzer iplAnalyzer = new IPLAnalyzer();
            iplAnalyzer.loadIplWicketsData(MOST_WICKETS_CSV_FILE_PATH);
            String sortedDataSR = iplAnalyzer.getMaximumWicketWithAverageWiseSorting();
            MostWicketsCSV[] mostWicketsCSV = new Gson().fromJson(sortedDataSR, MostWicketsCSV[].class);
            Assert.assertEquals("Imran Tahir", mostWicketsCSV[0].playerName);
        } catch(IPLException e) {
        }
    }
}
