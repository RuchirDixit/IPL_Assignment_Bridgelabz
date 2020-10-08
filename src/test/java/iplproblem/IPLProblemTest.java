package iplproblem;

import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

public class IPLProblemTest {
    private static final String MOST_RUNS_CSV_FILE_PATH = "./src/test/resources/IPL2019FactsheetMostRuns.csv";
    private static final String MOST_WICKETS_CSV_FILE_PATH = "./src/test/resources/IPL2019FactsheetMostWkts.csv";

    @Test
    public void givenIPLRunsData_WhenSortedOnAverage_ShouldReturnCorrectPlayerName() {
        try {
            IPLAnalyzer iplAnalyzer = new IPLAnalyzer();
            iplAnalyzer.loadIplRunsData(MOST_RUNS_CSV_FILE_PATH);
            String sortedData = iplAnalyzer.getAverageWiseSorting();
            MostRunsCSV[] mostRunsCSV = new Gson().fromJson(sortedData, MostRunsCSV[].class);
            Assert.assertEquals("MS Dhoni", mostRunsCSV[0].playerName);
        } catch(IPLException e) {}
    }
}
