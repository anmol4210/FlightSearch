package com.nagarro.dto;


import com.nagarro.io.Input;
import com.nagarro.io.Output;
import com.nagarro.model.FlightDetails;
import com.nagarro.model.TravelDetails;

import java.util.ArrayList;
import java.util.concurrent.Future;

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