package iplproblem;

import com.google.gson.Gson;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class IPLAnalyzer {
    Map<String,IPLDAO> iplMap;

    public IPLAnalyzer()
    {
        iplMap = new HashMap<>();
    }
    public int loadIplData(String... csvFilePath) throws IPLException {
        if(csvFilePath[0].equals("./src/test/resources/IPL2019FactsheetMostRuns.csv")) {
            iplMap = new IPLLoader().loadIPLData(MostRunsCSV.class, csvFilePath);
            return iplMap.size();
        }
        else if(csvFilePath[0].equals("./src/test/resources/IPL2019FactsheetMostWkts.csv"))  {
            iplMap = new IPLLoader().loadIPLData(MostWicketsCSV.class,csvFilePath);
            return iplMap.size();
        }
        else{
            iplMap = new IPLLoader().loadIPLDataMultiple(csvFilePath[0],csvFilePath[1]);
            return iplMap.size();
        }
    }

//    public int loadIplWicketsData(String csvFilePath) throws IPLException {
//        iplMap = new IPLLoader().loadIPLData(MostWicketsCSV.class,csvFilePath);
//        return iplMap.size();
//    }

    public String getAverageWiseSorting() throws IPLException {
        if( iplMap == null || iplMap.size() == 0 )
        {
            throw new IPLException("No data",IPLException.ExceptionType.NO_DATA);
        }
        Comparator<IPLDAO> iplComparator = Comparator.comparing(runs -> runs.battingAverage);
        List<IPLDAO> runsDAOS = iplMap.values().stream().collect(Collectors.toList());
        this.sort(runsDAOS,iplComparator);
        String sortedRunsJson = new Gson().toJson(runsDAOS);
        return sortedRunsJson;
    }

    public String getStrikeRateWiseSorting() throws IPLException {
        if( iplMap == null || iplMap.size() == 0 )
        {
            throw new IPLException("No data",IPLException.ExceptionType.NO_DATA);
        }
        Comparator<IPLDAO> iplComparator = Comparator.comparing(runs -> runs.strikeRate);
        List<IPLDAO> runsDAOS = iplMap.values().stream().collect(Collectors.toList());
        this.sort(runsDAOS,iplComparator);
        String sortedRunsJson = new Gson().toJson(runsDAOS);
        return sortedRunsJson;
    }

    public String getMaximumBoundariesWiseSorting() throws IPLException {
        if( iplMap == null || iplMap.size() == 0 )
        {
            throw new IPLException("No data",IPLException.ExceptionType.NO_DATA);
        }
        Comparator<IPLDAO> iplComparator = Comparator.comparing(runs -> runs.boundaries);
        List<IPLDAO> runsDAOS = iplMap.values().stream().collect(Collectors.toList());
        this.sort(runsDAOS,iplComparator);
        String sortedRunsJson = new Gson().toJson(runsDAOS);
        return sortedRunsJson;
    }
    public String getMaximumSixesWiseSorting() throws IPLException {
        if( iplMap == null || iplMap.size() == 0 )
        {
            throw new IPLException("No data",IPLException.ExceptionType.NO_DATA);
        }
        Comparator<IPLDAO> iplComparator = Comparator.comparing(runs -> runs.sixers);
        List<IPLDAO> runsDAOS = iplMap.values().stream().collect(Collectors.toList());
        this.sort(runsDAOS,iplComparator);
        String sortedRunsJson = new Gson().toJson(runsDAOS);
        return sortedRunsJson;
    }

    public String getMaximumStrikeRateWithFoursAndSixWiseSorting() throws IPLException {
        if( iplMap == null || iplMap.size() == 0 )
        {
            throw new IPLException("No data",IPLException.ExceptionType.NO_DATA);
        }
        Comparator<IPLDAO> iplComparatorSR = Comparator.comparing(IPLDAO::getStrikeRate)
                .thenComparing(iplDAO -> iplDAO.boundaries)
                .thenComparing(ipldao -> ipldao.sixers);
        List<IPLDAO> runsDAOS = iplMap.values().stream().collect(Collectors.toList());
        this.sort(runsDAOS,iplComparatorSR);
        String sortedRunsJson = new Gson().toJson(runsDAOS);
        return sortedRunsJson;
    }

    public String getMaximumAverageWithStrikeRateWiseSorting() throws IPLException {
        if( iplMap == null || iplMap.size() == 0 )
        {
            throw new IPLException("No data",IPLException.ExceptionType.NO_DATA);
        }
        Comparator<IPLDAO> iplComparatorAvg = Comparator.comparing(IPLDAO::getBattingAverage)
                .thenComparing(iplDAO -> iplDAO.strikeRate);
        List<IPLDAO> runsDAOS = iplMap.values().stream().collect(Collectors.toList());
        this.sort(runsDAOS,iplComparatorAvg);
        String sortedRunsJson = new Gson().toJson(runsDAOS);
        return sortedRunsJson;
    }

    public String getMaximumRunsWithAverageWiseSorting() throws IPLException {
        if( iplMap == null || iplMap.size() == 0 )
        {
            throw new IPLException("No data",IPLException.ExceptionType.NO_DATA);
        }
        Comparator<IPLDAO> iplComparatorAvg = Comparator.comparing(IPLDAO::getHighestScore)
                .thenComparing(iplDAO -> iplDAO.battingAverage);
        List<IPLDAO> runsDAOS = iplMap.values().stream().collect(Collectors.toList());
        this.sort(runsDAOS,iplComparatorAvg);
        String sortedRunsJson = new Gson().toJson(runsDAOS);
        return sortedRunsJson;
    }

    public String getMaximumWicketsWithAverageWiseSorting() throws IPLException {
        if( iplMap == null || iplMap.size() == 0 )
        {
            throw new IPLException("No data",IPLException.ExceptionType.NO_DATA);
        }
        Comparator<IPLDAO> iplComparatorAvg = Comparator.comparing(wickets -> wickets.bowlingAverage);
        List<IPLDAO> wicketsDAOS = iplMap.values().stream().collect(Collectors.toList());
        this.sort(wicketsDAOS,iplComparatorAvg);
        String sortedWicketsJson = new Gson().toJson(wicketsDAOS);
        return sortedWicketsJson;
    }

    public String getMaximumWicketsWithStrikeRateWiseSorting() throws IPLException {
        if( iplMap == null || iplMap.size() == 0 )
        {
            throw new IPLException("No data",IPLException.ExceptionType.NO_DATA);
        }
        Comparator<IPLDAO> iplComparatorAvg = Comparator.comparing(wickets -> wickets.strikeRate);
        List<IPLDAO> wicketsDAOS = iplMap.values().stream().collect(Collectors.toList());
        this.sort(wicketsDAOS,iplComparatorAvg);
        String sortedWicketsJson = new Gson().toJson(wicketsDAOS);
        return sortedWicketsJson;
    }

    public String getMaximumWicketsWithEconomyRateWiseSorting() throws IPLException {
        if( iplMap == null || iplMap.size() == 0 )
        {
            throw new IPLException("No data",IPLException.ExceptionType.NO_DATA);
        }
        Comparator<IPLDAO> iplComparatorAvg = Comparator.comparing(wickets -> wickets.economyRate);
        List<IPLDAO> wicketsDAOS = iplMap.values().stream().collect(Collectors.toList());
        this.sort(wicketsDAOS,iplComparatorAvg);
        String sortedWicketsJson = new Gson().toJson(wicketsDAOS);
        return sortedWicketsJson;
    }

    public String getMaximumWicketsSRWith4w5wWiseSorting() throws IPLException {
        if( iplMap == null || iplMap.size() == 0 )
        {
            throw new IPLException("No data",IPLException.ExceptionType.NO_DATA);
        }
        Comparator<IPLDAO> iplComparatorAvg = Comparator.comparing(IPLDAO::getStrikeRate)
                .thenComparing(iplDAO -> iplDAO.fourW+iplDAO.fiveW);
        List<IPLDAO> wicketsDAOS = iplMap.values().stream().collect(Collectors.toList());
        this.sort(wicketsDAOS,iplComparatorAvg);
        String sortedWicketsJson = new Gson().toJson(wicketsDAOS);
        return sortedWicketsJson;
    }

    public String getMaximumWicketAverageWithSRWiseSorting() throws IPLException {
        if( iplMap == null || iplMap.size() == 0 )
        {
            throw new IPLException("No data",IPLException.ExceptionType.NO_DATA);
        }
        Comparator<IPLDAO> iplComparatorAvg = Comparator.comparing(IPLDAO::getBowlingAverage)
                .thenComparing(iplDAO -> iplDAO.strikeRate);
        List<IPLDAO> wicketsDAOS = iplMap.values().stream().collect(Collectors.toList());
        this.sort(wicketsDAOS,iplComparatorAvg);
        String sortedWicketsJson = new Gson().toJson(wicketsDAOS);
        return sortedWicketsJson;
    }

    public String getMaximumWicketWithAverageWiseSorting() throws IPLException {
        if( iplMap == null || iplMap.size() == 0 )
        {
            throw new IPLException("No data",IPLException.ExceptionType.NO_DATA);
        }
        Comparator<IPLDAO> iplComparatorAvg = Comparator.comparing(IPLDAO::getWickets)
                .thenComparing(iplDAO -> iplDAO.bowlingAverage);
        List<IPLDAO> wicketsDAOS = iplMap.values().stream().collect(Collectors.toList());
        this.sort(wicketsDAOS,iplComparatorAvg);
        String sortedWicketsJson = new Gson().toJson(wicketsDAOS);
        return sortedWicketsJson;
    }

    public String getMaximumBattingBowlingAverageWiseSorting() throws IPLException {
        if( iplMap == null || iplMap.size() == 0 )
        {
            throw new IPLException("No data",IPLException.ExceptionType.NO_DATA);
        }
        Comparator<IPLDAO> iplComparatorAvg = Comparator.comparing(IPLDAO::getBattingAverage)
                .thenComparing(iplDAO -> iplDAO.bowlingAverage);
        List<IPLDAO> wicketsDAOS = iplMap.values().stream().collect(Collectors.toList());
        this.sort(wicketsDAOS,iplComparatorAvg);
        String sortedWicketsJson = new Gson().toJson(wicketsDAOS);
        return sortedWicketsJson;
    }

    public String getMaximumBattingBowlingWiseSorting() throws IPLException {
        if( iplMap == null || iplMap.size() == 0 )
        {
            throw new IPLException("No data",IPLException.ExceptionType.NO_DATA);
        }
        Comparator<IPLDAO> iplComparatorAvg = Comparator.comparing(IPLDAO::getWickets)
                .thenComparing(iplDAO -> iplDAO.highestScore);
        List<IPLDAO> wicketsDAOS = iplMap.values().stream().collect(Collectors.toList());
        this.sort(wicketsDAOS,iplComparatorAvg);
        String sortedWicketsJson = new Gson().toJson(wicketsDAOS);
        return sortedWicketsJson;
    }

    public String getMaximumHundredSorting() throws IPLException {
        if( iplMap == null || iplMap.size() == 0 )
        {
            throw new IPLException("No data",IPLException.ExceptionType.NO_DATA);
        }
        Comparator<IPLDAO> iplComparatorAvg = Comparator.comparing(IPLDAO::getHundreds)
                .thenComparing(iplDAO -> iplDAO.battingAverage);
        List<IPLDAO> runsDAOS = iplMap.values().stream().collect(Collectors.toList());
        this.sort(runsDAOS,iplComparatorAvg);
        String sortedWicketsJson = new Gson().toJson(runsDAOS);
        return sortedWicketsJson;
    }

    private void sort(List<IPLDAO> iplDAOS,Comparator<IPLDAO> iplComparator) {
        for (int i=0 ; i < iplDAOS.size()-1; i++)
        {
            for (int j=0 ; j < iplDAOS.size()-i-1; j++)
            {
                IPLDAO ipl1=iplDAOS.get(j);
                IPLDAO ipl2=iplDAOS.get(j+1);
                if(iplComparator.compare(ipl1,ipl2) < 0)
                {
                    iplDAOS.set(j,ipl2);
                    iplDAOS.set(j+1,ipl1);
                }
            }
        }
    }
}
