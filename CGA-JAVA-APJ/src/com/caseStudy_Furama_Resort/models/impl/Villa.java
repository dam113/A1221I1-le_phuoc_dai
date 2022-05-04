package com.caseStudy_Furama_Resort.models.impl;

import com.caseStudy_Furama_Resort.models.Facility;

public class Villa extends Facility {
    private String roomStandard;
    private Double poolArea;
    private int numFloos;

    public Villa() {
    }

    public Villa(String roomStandard, Double poolArea, int numFloos) {
        this.roomStandard = roomStandard;
        this.poolArea = poolArea;
        this.numFloos = numFloos;
    }

    public Villa(String nameService, Double usableArea, Double rentalCosts, int numPeopleMax, String rentalType, String roomStandard, Double poolArea, int numFloos) {
        super(nameService, usableArea, rentalCosts, numPeopleMax, rentalType);
        this.roomStandard = roomStandard;
        this.poolArea = poolArea;
        this.numFloos = numFloos;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public Double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(Double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumFloos() {
        return numFloos;
    }

    public void setNumFloos(int numFloos) {
        this.numFloos = numFloos;
    }
}
