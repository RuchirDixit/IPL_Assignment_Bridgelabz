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
            String player = null;
            iplAnalyzer.loadIplRunsData(MOST_RUNS_CSV_FILE_PATH);
            String sortedDataSR = iplAnalyzer.getMaximumStrikeRateWithFoursAndSixWiseSorting();
            MostRunsCSV[] mostRunsSRCSV = new Gson().fromJson(sortedDataSR, MostRunsCSV[].class);
            Assert.assertEquals("Andre Russell", mostRunsSRCSV[0].playerName);
        } catch(IPLException e) {
        }
    }
}
