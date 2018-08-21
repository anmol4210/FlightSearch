package com.nagarro.io;

import com.nagarro.model.FlightDetails;
import com.nagarro.model.TravelDetails;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Output {
    /**
     * @param results
     * @param traveDetail
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public void printResult(Future<ArrayList<FlightDetails>>[] results, TravelDetails traveDetail) throws ExecutionException, InterruptedException {
        ArrayList<FlightDetails> result=new ArrayList<>();
        for(Future<ArrayList<FlightDetails>> rs:results){
            result.addAll(rs.get());
        }
    if (result.size()==0){
        System.out.println("Unable to find flights for these preferences");
        return;
    }
        printResult(result,traveDetail);

    }

    /**
     * @param result
     * @param traveDetail
     */
    private void printResult(ArrayList<FlightDetails> result,TravelDetails traveDetail){
        System.out.println("Flight_No.  Flight_Time Flight_Duration Fare");
        if(traveDetail.getOutputPreference().toString().equalsIgnoreCase("y")){
            Collections.sort(result,byFareAndDuration);
            for (int index=0;index<result.size();index++){
                float fare=Float.parseFloat(result.get(index).getFare()+" ")*(float)1.4;
                System.out.println(result.get(index).getFlightNo()+"        "+result.get(index).getFlightTime()+"           "+
                        result.get(index).getFlightDur()+"      "+fare);
            }
        }
        else{
            Collections.sort(result,byFare);
            for (int index=0;index<result.size();index++){
                System.out.println(result.get(index).getFlightNo()+"        "+result.get(index).getFlightTime()+"       "+
                        result.get(index).getFlightDur()+"      "+result.get(index).getFare());
            }
        }
    }
    private static Comparator<FlightDetails> byFare=new Comparator<FlightDetails>() {

        public int compare(FlightDetails o1, FlightDetails o2) {
            int fare_1=o1.getFare();
            int fare_2=o2.getFare();
            return fare_1-fare_2>0?1:-1;
        }
    };
    private static Comparator<FlightDetails> byFareAndDuration=new Comparator<FlightDetails>() {

        public int compare(FlightDetails flight1, FlightDetails flight2) {
            int fare_1=flight1.getFare();
            int fare_2=flight2.getFare();
            double dur_1=Double.parseDouble(flight1.getFlightDur());
            double dur_2=Double.parseDouble(flight2.getFlightDur());
            if(fare_1==fare_2){
                return dur_1-dur_2>0?1:-1;
            }
            else{
            return fare_1-fare_2>0?1:-1;
            }
        }
    };
}
