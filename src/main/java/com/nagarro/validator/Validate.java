package com.nagarro.validator;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.validation.constraints.Future;

import com.nagarro.exception.FlightException;


/**
 *
 */
public class Validate {
    String locationPattern="[A-Za-z][A-Za-z][A-Za-z]";

    /**
     * @param input
     * @param data
     * @throws FlightException
     */
    public void validate(String input, String data) throws FlightException{
        switch(data){
            case "Departure Location":
                validateDepartureLocation(input);
                break;
            case "Arrival Location":
                validateArrivalLocation(input);
                break;
            case "Flight Class E or B":
                validateFlightClass(input);
                break;
            case "Flight Date(dd/MM/yyyy)":
                validateFlightDate(input,data);
                break;
            case "Sort Result by flight duration: y/n":
                validateOutputPreferences(input);
                break;
        }
    }

    /**
     * @param input
     * @throws FlightException
     */
    public void validateDepartureLocation(String input) throws FlightException{
        if (!input.matches(locationPattern) ) {
            throw new FlightException("Enter a valid Departure Location code! Enter Again!");
        }
    }

    /**
     * @param input
     * @throws FlightException
     */
    public void validateArrivalLocation(String input) throws FlightException{
        if (!input.matches(locationPattern)) {
            throw new FlightException("Enter a valid Arrival Location Code! Enter Again!");
        }

    }

    /**
     * @param input
     * @throws FlightException
     */
    public void validateFlightClass(String input) throws FlightException{
        if (input.length() < 1) {
            throw new FlightException("Flight Class can not be left blank! Enter Again!");
        }
        if(!((input.equalsIgnoreCase("E"))|| (input.equalsIgnoreCase("B")))){
            throw new FlightException("Enter a valid Flght Class");
        }
    }

    /**
     * @param input
     * @param data
     * @throws FlightException
     */
    /**/
    public void validateFlightDate(String input,String data) throws FlightException{
        if (input.length() < 1) {
            throw new FlightException("Flight Date can not be left blank! Enter Again!");
        }
        try{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
           @Future(message = "Date Should be in fututre") LocalDate ld;
           ld= LocalDate.parse(input,formatter);

            if(! ld.isAfter(LocalDate.now())){
                //System.out.println("True");
                throw new FlightException("Enter a valid date! Enter Again! ");
            }

                ld.getDayOfWeek();


            //System.out.println( new SimpleDateFormat("dd/MM/yyyy").parse(input));
        }catch(Exception e){
            throw new FlightException("Enter a valid "+data+"! Enter Again! ");
        }
    }

    /**
     * @param input
     * @throws FlightException
     */
    public void validateOutputPreferences(String input) throws FlightException{
        if (input.length() < 1) {
            throw new FlightException("Enter a vaid Output Preference! Enter Again!");
        }
        if(!(input.equalsIgnoreCase("y")|| input.equalsIgnoreCase("n"))){
            throw new FlightException("Enter a vaid Output Preference! Enter Again!");
        }
    }
}