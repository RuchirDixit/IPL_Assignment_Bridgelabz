package iplproblem;

import com.opencsvlibrary.CSVBuilderException;
import com.opencsvlibrary.CSVBuilderFactory;
import com.opencsvlibrary.ICSVBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.StreamSupport;

public class IPLLoader {

    public <E> Map<String,IPLDAO> loadIPLData(Class<E> censusCSVClass, String... csvFilePath) {
        Map<String,IPLDAO> iplMap = new HashMap<>();
        try(
                Reader reader = Files.newBufferedReader(Paths.get(csvFilePath[0]));
        )
        {
            ICSVBuilder icsvBuilder = CSVBuilderFactory.createCSVBuilder();
            Iterator<E> csvIterator = icsvBuilder.getCSVFileIterator(reader,censusCSVClass);
            Iterable<E> csvIterable = () -> csvIterator;
            if (censusCSVClass.getName().equals("iplproblem.MostRunsCSV"))
            {
                StreamSupport.stream(csvIterable.spliterator(), false)
                        .map(MostRunsCSV.class::cast)
                        .forEach(runsCSV -> iplMap.put(runsCSV.playerName, new IPLDAO(runsCSV)));
            }
            else if (censusCSVClass.getName().equals("iplproblem.MostWicketsCSV"))
            {
                StreamSupport.stream(csvIterable.spliterator(), false)
                        .map(MostWicketsCSV.class::cast)
                        .forEach(wicketsCSV -> iplMap.put(wicketsCSV.playerName, new IPLDAO(wicketsCSV)));
            }
        } catch (Exception e) {

        }
        return iplMap;
    }
}
