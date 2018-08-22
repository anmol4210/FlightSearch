package com.nagarro.dto;


import com.nagarro.io.Input;
import com.nagarro.io.Output;
import com.nagarro.logging.Log;
import com.nagarro.model.FlightDetails;
import com.nagarro.model.TravelDetails;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.Future;
import java.util.logging.Level;

/**
 *
 */
public class FlightSearchSystem {
    /**
     * @param args
     */
    public static void main(String[] args){
        do{
            try {
                Input input=new Input();
                TravelDetails traveDetail=(input.getInput());
                Date date;
                SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd 'at' h:m:s a z");

                //////// Logging//////////
                Log log = new Log("log/log.txt");
                log.logger.setLevel(Level.INFO);
                date = new Date();
                log.logger.info("Data Fetched at " + dateFormatter.format(date));

                SearchFlights search=new SearchFlights();
                Future<ArrayList<FlightDetails>>[] results=search.searchAirline(traveDetail);

                Output output=new Output();
                output.printResult(results,traveDetail);

            } catch (Exception e) {
                System.out.println(e);
            }
        }while(true);
    }
}