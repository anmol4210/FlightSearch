package com.nagarro.model;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;



/**
 * @author anmolnarang
 *
 */
public class TravelDetails {
    private StringBuffer flightClass,outputPreference,departureLocation,arrivalLocation;


    private LocalDate flightDate;

    /**
     * @return
     */
    public StringBuffer getFlightClass() {
        return flightClass;
    }

    /**
     * @param flightClass
     */
    public void setFlightClass(StringBuffer flightClass) {
        this.flightClass = flightClass;
    }

    /**
     * @return
     */
    public StringBuffer getOutputPreference() {
        return outputPreference;
    }

    /**
     * @param outputPreference
     */
    public void setOutputPreference(StringBuffer outputPreference) {
        this.outputPreference = outputPreference;
    }

    /**
     * @return
     */
    public StringBuffer getDepartureLocation() {
        return departureLocation;
    }

    /**
     * @param stringBuffer
     */
    @NotNull(message = "Departure Location cannot be null")
    public void setDepartureLocation(StringBuffer stringBuffer) {
        this.departureLocation = stringBuffer;
    }

    /**
     * @return
     */
    public StringBuffer getArrivalLocation() {
        return arrivalLocation;
    }

    /**
     * @param arrivalLocation
     */
    @NotNull(message = "Arrival Location cannot be null")
    public void setArrivalLocation(StringBuffer arrivalLocation) {
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