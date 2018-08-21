package com.nagarro.model;

public class FlightDetails {
    private String flightNo,depLoc,arrLoc,validTill,flightTime,travelClass,seatAvailability,flightDur;
    private int fare;

    /**
     * @return
     */
    public String getFlightNo() {
        return flightNo;
    }

    /**
     * @param flightNo
     */
    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    /**
     * @return
     */
    public String getDepLoc() {
        return depLoc;
    }

    /**
     * @param depLoc
     */
    public void setDepLoc(String depLoc) {
        this.depLoc = depLoc;
    }

    /**
     * @return
     */
    public String getArrLoc() {
        return arrLoc;
    }

    /**
     * @param arrLoc
     */
    public void setArrLoc(String arrLoc) {
        this.arrLoc = arrLoc;
    }

    /**
     * @return
     */
    public String getValidTill() {
        return validTill;
    }

    /**
     * @param validTill
     */
    public void setValidTill(String validTill) {
        this.validTill = validTill;
    }

    /**
     * @return
     */
    public String getFlightTime() {
        return flightTime;
    }

    /**
     * @param flightTime
     */
    public void setFlightTime(String flightTime) {
        this.flightTime = flightTime;
    }

    /**
     * @return
     */
    public String getTravelClass() {
        return travelClass;
    }

    /**
     * @param travelClass
     */
    public void setTravelClass(String travelClass) {
        this.travelClass = travelClass;
    }

    /**
     * @return
     */
    public String getSeatAvailability() {
        return seatAvailability;
    }

    /**
     * @param seatAvailability
     */
    public void setSeatAvailability(String seatAvailability) {
        this.seatAvailability = seatAvailability;
    }

    /**
     * @return
     */
    public int getFare() {
        return fare;
    }

    /**
     * @param fare
     */
    public void setFare(int fare) {
        this.fare = fare;
    }

    /**
     * @return
     */
    public String getFlightDur() {
        return flightDur;
    }

    /**
     * @param flightDur
     */
    public void setFlightDur(String flightDur) {
        this.flightDur = flightDur;
    }
}
