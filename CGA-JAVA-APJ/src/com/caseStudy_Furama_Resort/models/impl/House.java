package com.caseStudy_Furama_Resort.models.impl;

import com.caseStudy_Furama_Resort.models.Facility;

public class House extends Facility {
    private String roomStandard;
    private int numFloos;

    public House() {
    }

    public House(String roomStandard, int numFloos) {
        this.roomStandard = roomStandard;
        this.numFloos = numFloos;
    }

    public House(String nameService, Double usableArea, Double rentalCosts, int numPeopleMax, String rentalType, String roomStandard, int numFloos) {
        super(nameService, usableArea, rentalCosts, numPeopleMax, rentalType);
        this.roomStandard = roomStandard;
        this.numFloos = numFloos;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public int getNumFloos() {
        return numFloos;
    }

    public void setNumFloos(int numFloos) {
        this.numFloos = numFloos;
    }
}
