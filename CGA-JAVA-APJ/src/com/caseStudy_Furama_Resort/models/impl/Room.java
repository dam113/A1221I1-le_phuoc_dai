package com.caseStudy_Furama_Resort.models.impl;

import com.caseStudy_Furama_Resort.models.Facility;

public class Room extends Facility {
    private String serviceFree;

    public Room() {
    }

    public Room(String serviceFree) {
        this.serviceFree = serviceFree;
    }

    public Room(String nameService, Double usableArea, Double rentalCosts, int numPeopleMax, String rentalType, String serviceFree) {
        super(nameService, usableArea, rentalCosts, numPeopleMax, rentalType);
        this.serviceFree = serviceFree;
    }

    public String getServiceFree() {
        return serviceFree;
    }

    public void setServiceFree(String serviceFree) {
        this.serviceFree = serviceFree;
    }
}
