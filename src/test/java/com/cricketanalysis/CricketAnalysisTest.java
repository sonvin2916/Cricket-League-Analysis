package com.cricketanalysis;

import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class CricketAnalysisTest {
    CricketAnalysis cricketAnalysis;
    private static final  String IPL_BATSMAN_CSV_DATA_FILE_PATH="./src/test/resources/Data_01 IPL2019FactsheetMostRuns";

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

}
