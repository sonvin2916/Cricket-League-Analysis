package com.cricketanalysis;

import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class CricketAnalysisTest {
    CricketAnalysis cricketAnalysis;
    private static final  String IPL_BATSMAN_CSV_DATA_FILE_PATH="./src/test/resources/Data_01 IPL2019FactsheetMostRuns";
    private static final  String IPL_WICKET_CSV_DATA_FILE_PATH="./src/test/resources/Data_02 IPL2019FactsheetMostWkts";

    @Test
    public void  givenBatsmanCSVFile_WhenPassedCorrect_ShouldReturnCorrectRecords() throws IOException {
        try {
            int numOfRecords = cricketAnalysis.loadBatsmanData(IPL_BATSMAN_CSV_DATA_FILE_PATH);
            Assert.assertEquals(100,numOfRecords);
        } catch (Exception e) { }

    }
    @Test
    public void givenCricketData_WhenSorted_ShouldReturnBestBattingAverage(){
        try {
            cricketAnalysis.loadBatsmanData(IPL_BATSMAN_CSV_DATA_FILE_PATH);
            String sortedCensusData = cricketAnalysis.getAverageWiseSorted();
            IPLBatsman[] censusCsv = new Gson().fromJson(sortedCensusData, IPLBatsman[].class);
            double runs = censusCsv[0].Avg;
            String name = censusCsv[0].getPLAYER();
            Assert.assertEquals("MS Dhoni", name);
        } catch (Exception e) {
        }
    }
    @Test
    public void givenCricketData_WhenSorted_ShouldReturnTopStrikingRate(){
        try {
            cricketAnalysis.loadBatsmanData(IPL_BATSMAN_CSV_DATA_FILE_PATH);
            String sortedCensusData = cricketAnalysis.getTopStrikingRates();
            IPLBatsman[] censusCsv = new Gson().fromJson(sortedCensusData, IPLBatsman[].class);
            double runs = censusCsv[0].Avg;
            String name = censusCsv[0].getPLAYER();
            Assert.assertEquals("Ishant Sharma", name);
        } catch (Exception e) {
        }
    }
    @Test
    public void givenCricketData_WhenSorted_ShouldReturnMaximumFours(){
        try {
            cricketAnalysis.loadBatsmanData(IPL_BATSMAN_CSV_DATA_FILE_PATH);
            String sortedCensusData = cricketAnalysis.getMaximumFours();
            IPLBatsman[] censusCsv = new Gson().fromJson(sortedCensusData, IPLBatsman[].class);
            String runs = censusCsv[0].fours;
            String name = censusCsv[0].getPLAYER();
            Assert.assertEquals("Shikhar Dhawan", name);
        } catch (Exception e) {
        }
    }
    @Test
    public void givenCricketData_WhenSorted_ShouldReturnMaximumSixs(){
        try {
            cricketAnalysis.loadBatsmanData(IPL_BATSMAN_CSV_DATA_FILE_PATH);
            String sortedCensusData = cricketAnalysis.getMaximumSixs();
            IPLBatsman[] censusCsv = new Gson().fromJson(sortedCensusData, IPLBatsman[].class);
            String runs = censusCsv[0].sixs;
            String name = censusCsv[0].getPLAYER();
            Assert.assertEquals("Andre Russell", name);
        } catch (Exception e) {
        }
    }
    @Test
    public void givenCricketData_WhenSorted_ShouldReturnSortedStrikeRateWithFoursAndSixes() {
        try {
            cricketAnalysis.loadBatsmanData(IPL_BATSMAN_CSV_DATA_FILE_PATH);
            String sortedCensusData = cricketAnalysis.getStrikingRatesWith4sAnd6s();
            IPLBatsman[] censusCsv = new Gson().fromJson(sortedCensusData, IPLBatsman[].class);
            double runs = censusCsv[0].SR;
            String name = censusCsv[0].getPLAYER();
            Assert.assertEquals("Ishant Sharma", name);
        } catch (Exception e) {
        }
    }
    @Test
    public void givenCricketData_WhenSorted_ShouldReturnSortedAverageWithBestSR() {
        try {
            cricketAnalysis.loadBatsmanData(IPL_BATSMAN_CSV_DATA_FILE_PATH);
            String sortedCensusData = cricketAnalysis.getAverageWithBestSRWiseSorted();
            IPLBatsman[] censusCsv = new Gson().fromJson(sortedCensusData, IPLBatsman[].class);
            String name = censusCsv[0].getPLAYER();
            Assert.assertEquals("MS Dhoni", name);
        } catch (Exception e) {
        }
    }
    @Test
    public void givenCricketData_WhenSorted_ShouldReturnSortedRunsWithBestAvg() {
        try {
            cricketAnalysis.loadBatsmanData(IPL_BATSMAN_CSV_DATA_FILE_PATH);
            String sortedCensusData = cricketAnalysis.getBestAverageWithRunsWiseSorted();
            IPLBatsman[] censusCsv = new Gson().fromJson(sortedCensusData, IPLBatsman[].class);
            String runs = censusCsv[0].Runs;
            String name = censusCsv[0].getPLAYER();
            Assert.assertEquals("David Warner", name);
        } catch (Exception e) {
        }
    }
    @Test
    public void givenWicketCSVFile_WhenPassedCorrect_ShouldReturnCorrectRecords() {
        try {
            int numOfRecords = cricketAnalysis.loadDataForWickets(IPL_WICKET_CSV_DATA_FILE_PATH);
            Assert.assertEquals(99, numOfRecords);
        } catch (Exception e) {
        }
    }
    @Test
    public void givenWicketData_WhenSorted_ShouldReturnSortedWithTopBowlingAvg() {
        try {
            cricketAnalysis.loadDataForWickets(IPL_WICKET_CSV_DATA_FILE_PATH);
            String sortedCensusData = cricketAnalysis.getAverageBowlingWiseSortedForWickets();
            IPLWickets[] censusCsv = new Gson().fromJson(sortedCensusData, IPLWickets[].class);
            String runs = censusCsv[0].Avg;
            String name = censusCsv[0].getPLAYER();
            Assert.assertEquals("Krishnappa Gowtham", name);
        } catch (Exception e) {
        }
    }
    @Test
    public void givenWicketData_WhenSorted_ShouldReturnSortedWithStrikeRate() {
        try {
            cricketAnalysis.loadDataForWickets(IPL_WICKET_CSV_DATA_FILE_PATH);
            String sortedCensusData = cricketAnalysis.getBestStrikingRateWiseSorted();
            IPLWickets[] censusCsv = new Gson().fromJson(sortedCensusData, IPLWickets[].class);
            String name = censusCsv[0].getPLAYER();
            Assert.assertEquals("Krishnappa Gowtham", name);
        } catch (Exception e) {
        }
    }


}
