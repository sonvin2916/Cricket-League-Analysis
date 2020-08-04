package com.cricketanalysis;


import com.google.gson.Gson;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;


public class CricketAnalysis {
    List<IPLBatsman> censusCSVList = null;
    List<IPLWickets> wicketsList = null;

    public int loadBatsmanData(String csvFilePath) throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            censusCSVList = csvBuilder.getCSVFileList(reader, IPLBatsman.class);
            System.out.println(censusCSVList);
            return censusCSVList.size();
        } catch (IOException e) {
            throw new CSVBuilderException(e.getMessage(), CSVBuilderException.ExceptionType.FILE_NOT_FOUND);
        } catch (RuntimeException e) {
            throw new CSVBuilderException(e.getMessage(), CSVBuilderException.ExceptionType.INCORRECT_FILE);
        }

    }
    public int loadDataForWickets(String csvFilePath) {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            censusCSVList = csvBuilder.getCSVFileList(reader, IPLWickets.class);
            System.out.println(censusCSVList);
            return censusCSVList.size();
        } catch (IOException e) {
            throw new CSVBuilderException(e.getMessage(), CSVBuilderException.ExceptionType.FILE_NOT_FOUND);
        } catch (RuntimeException e) {
            throw new CSVBuilderException(e.getMessage(), CSVBuilderException.ExceptionType.INCORRECT_FILE);
        }
    }


    public String getAverageWiseSorted() {
        if (censusCSVList.size() == 0 || censusCSVList == null)
            throw new CSVBuilderException("No Census Data", CSVBuilderException.ExceptionType.NO_CENSUS_DATA);
        Comparator<IPLBatsman> iplMostRunsComparator = Comparator.comparing(census -> census.Avg);
        this.sort(iplMostRunsComparator);
        String sortedCensusJson = new Gson().toJson(censusCSVList);
        return sortedCensusJson;
    }
    public String getTopStrikingRates() {
        if(censusCSVList.size()==0 || censusCSVList==null)
            throw new CSVBuilderException("No Census Data", CSVBuilderException.ExceptionType.NO_CENSUS_DATA);
        Comparator<IPLBatsman> sortedStrikingRate = Comparator.comparing(census -> census.SR);
        this.sort(sortedStrikingRate);
        String sortedCensusJson = new Gson().toJson(censusCSVList);
        return sortedCensusJson;
    }
    public String getMaximumFours() {
        if(censusCSVList.size()==0 || censusCSVList==null)
            throw new CSVBuilderException("No Census Data", CSVBuilderException.ExceptionType.NO_CENSUS_DATA);
        Comparator<IPLBatsman> sortedMaximumFours = Comparator.comparing(census -> census.fours);
        this.sort(sortedMaximumFours);
        String sortedCensusJson = new Gson().toJson(censusCSVList);
        return sortedCensusJson;

    }
    public String getMaximumSixs() {
        if(censusCSVList.size()==0 || censusCSVList==null)
            throw new CSVBuilderException("No Census Data", CSVBuilderException.ExceptionType.NO_CENSUS_DATA);
        Comparator<IPLBatsman> sortedMaximumSixs = Comparator.comparing(census -> census.sixs);
        this.sort(sortedMaximumSixs);
        String sortedCensusJson = new Gson().toJson(censusCSVList);
        return sortedCensusJson;
    }
    public String getStrikingRatesWith4sAnd6s() {
        if(censusCSVList.size()==0 || censusCSVList==null)
            throw new CSVBuilderException("No Census Data", CSVBuilderException.ExceptionType.NO_CENSUS_DATA);
        Comparator<IPLBatsman> sortedStrikingRate4sand6s = Comparator.comparing(census -> census.SR);
        this.sort(sortedStrikingRate4sand6s);
        String sortedCensusJson = new Gson().toJson(censusCSVList);
        return sortedCensusJson;
    }
    public String getAverageWithBestSRWiseSorted() {
        if(censusCSVList.size()==0 || censusCSVList==null)
            throw new CSVBuilderException("No Census Data", CSVBuilderException.ExceptionType.NO_CENSUS_DATA);
        Comparator<IPLBatsman> iplMostRunsComparator = Comparator.comparing(census -> census.Avg);
        this.sort(iplMostRunsComparator);
        String sortedCensusJson = new Gson().toJson(censusCSVList);
        return sortedCensusJson;
    }
    public String getBestAverageWithRunsWiseSorted() {
        if(censusCSVList.size()==0 || censusCSVList==null)
            throw new CSVBuilderException("No Census Data", CSVBuilderException.ExceptionType.NO_CENSUS_DATA);
        Comparator<IPLBatsman> iplMostRunsComparator = Comparator.comparing(census -> census.Runs);
        this.sort(iplMostRunsComparator);
        String sortedCensusJson = new Gson().toJson(censusCSVList);
        return sortedCensusJson;
    }
    public String getAverageBowlingWiseSortedForWickets() {
        if(wicketsList.size()==0 || wicketsList==null)
            throw new CSVBuilderException("No Census Data", CSVBuilderException.ExceptionType.NO_CENSUS_DATA);
        Comparator<IPLWickets> iplMostWicketsComparator = Comparator.comparing(census -> census.Avg);
        this.sortWickets(iplMostWicketsComparator);
        String sortedCensusJson = new Gson().toJson(wicketsList);
        return sortedCensusJson;
    }
    public String getBestStrikingRateWiseSorted() {
        if(wicketsList.size()==0 || wicketsList==null)
            throw new CSVBuilderException("No Census Data", CSVBuilderException.ExceptionType.NO_CENSUS_DATA);
        Comparator<IPLWickets> iplMostWicketsComparator = Comparator.comparing(census -> census.SR);
        this.sortWickets(iplMostWicketsComparator);
        String sortedCensusJson = new Gson().toJson(wicketsList);
        return sortedCensusJson;
    }

    private void sortWickets(Comparator<IPLWickets> iplMostWicketsComparator) {
        for (int i = 0; i < wicketsList.size()-1; i++){
            for (int j=0; j < wicketsList.size()-i-1; j++){
                IPLWickets census1 = wicketsList.get(j);
                IPLWickets census2 = wicketsList.get(j+1);
                if (iplMostWicketsComparator.compare(census1,census2)<0){
                    wicketsList.set(j,census2);
                    wicketsList.set(j+1,census1);
                }
            }
        }
    }

    private void sort(Comparator<IPLBatsman> iplMostRunsComparator) {
        for (int i = 0; i < censusCSVList.size() - 1; i++) {
            for (int j = 0; j < censusCSVList.size() - i - 1; j++) {
                IPLBatsman census1 = censusCSVList.get(j);
                IPLBatsman census2 = censusCSVList.get(j + 1);

                if (iplMostRunsComparator.compare(census1, census2) < 0) {
                    censusCSVList.set(j, census2);
                    censusCSVList.set(j + 1, census1);
                }
            }
        }
    }


}












