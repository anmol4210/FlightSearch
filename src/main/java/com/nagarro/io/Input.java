package com.nagarro.io;

import com.nagarro.exception.FlightException;
import com.nagarro.model.TravelDetails;
import com.nagarro.validator.Validate;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Input {
    Scanner scanner = new Scanner(System.in);
    Validate valid=new Validate();

    /**
     * @return
     * @throws ParseException
     */
    public TravelDetails getInput() throws ParseException{
        DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        TravelDetails travelDetails=new TravelDetails();

        travelDetails.setDepartureLocation(new StringBuilder(fetch("Departure Location")));
        travelDetails.setArrivalLocation(new StringBuilder(fetch("Arrival Location")));
        travelDetails.setFlightClass(new StringBuilder(fetch("Flight Class E or B")));
        travelDetails.setOutputPreference(new StringBuilder(fetch("Sort Result by flight duration: y/n")));
        // System.out.println();
        travelDetails.setFlightDate(LocalDate.parse(fetch("Flight Date(dd/MM/yyyy)"),formatter));

        //////////////////////////
        // validate the input
//        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
//        Validator validator =  factory.getValidator();
//        Set<ConstraintViolation<TravelDetails>> violations = validator.validate(travelDetails);
//        for (ConstraintViolation<TravelDetails> violation : violations) {
//            System.out.println(violation.getMessage());
//        }
        ///////////////////////////////


        return travelDetails;
    }

    /**
     * @param data
     * @return
     */
    private String fetch(String data){
        String input;
        do{
            try{
                System.out.println("Enter " + data);
                input = scanner.nextLine().trim();
                valid.validate(input, data);
                break;
            }
            catch (FlightException fe){}
            catch (NumberFormatException e){
                System.out.println("Incorrect Value Entered! Enter again");
            }
            catch (Exception e) {
                System.out.println("Error occured: "+e);
            }
        }while(true);
        return input;

    }

}