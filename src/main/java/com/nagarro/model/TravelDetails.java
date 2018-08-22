package com.nagarro.model;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;



/**
 * @author anmolnarang
 *
 */
public class TravelDetails {
   // @NotNull(message = "Departure Location cannot be null")
    private StringBuilder departureLocation,arrivalLocation;
    private StringBuilder flightClass,outputPreference;


    private LocalDate flightDate;

    /**
     * @return
     */
    public StringBuilder getFlightClass() {
        return flightClass;
    }

    /**
     * @param flightClass
     */
    public void setFlightClass(StringBuilder flightClass) {
        this.flightClass = flightClass;
    }

    /**
     * @return
     */
    public StringBuilder getOutputPreference() {
        return outputPreference;
    }

    /**
     * @param outputPreference
     */
    public void setOutputPreference(StringBuilder outputPreference) {
        this.outputPreference = outputPreference;
    }

    /**
     * @return
     */
    public StringBuilder getDepartureLocation() {
        return departureLocation;
    }

    /**
     * @param stringBuffer
     */

    public void setDepartureLocation(StringBuilder stringBuffer) {
        this.departureLocation = stringBuffer;
    }

    /**
     * @return
     */
    public StringBuilder getArrivalLocation() {
        return arrivalLocation;
    }

    /**
     * @param arrivalLocation
     */

    public void setArrivalLocation(StringBuilder arrivalLocation) {
        this.arrivalLocation = arrivalLocation;
    }

    /**
     * @return
     */
    public LocalDate getFlightDate() {
        return flightDate;
    }

    /**
     * @param flightDate
     */
    public void setFlightDate(LocalDate flightDate) {
       // System.out.println(flightDate);
        this.flightDate = flightDate;
    }
}