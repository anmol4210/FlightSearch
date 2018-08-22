package com.nagarro.dto;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.nagarro.io.Output;
import com.nagarro.model.FlightDetails;
import com.nagarro.model.TravelDetails;
import com.nagarro.services.FileRead;

public class SearchFlights {

    /**
     *
     * @param traveDetail
     * @return
     * @throws InterruptedException
     * @throws ExecutionException
     */
    public Future<ArrayList<FlightDetails>>[] searchAirline(TravelDetails traveDetail) throws InterruptedException, ExecutionException{
        String csvFile = "Assignment Links";
        String line = "";
        File folder = new File(csvFile);
        File[] listOfFiles = folder.listFiles();
        FileReader fileReader;

        ExecutorService es=Executors.newFixedThreadPool(3);
        Future<ArrayList<FlightDetails>>[] results=new Future[listOfFiles.length];
        int index=0;
        for (File file : listOfFiles) {
            if (file.isFile()) {
                FileRead fileRead=new FileRead(csvFile+"\\"+file.getName(),traveDetail);
                results[index]=es.submit(fileRead);
                index++;
                //fileRead.searchFile();
            }
        }
return results;

    }
}
