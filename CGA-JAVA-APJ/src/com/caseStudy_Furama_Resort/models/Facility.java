package com.caseStudy_Furama_Resort.models;

public abstract class Facility {
    private String nameService;
    private Double usableArea;
    private Double rentalCosts;
    private int numPeopleMax;
    private String rentalType;

    public Facility() {
    }

    public Facility(String nameService, Double usableArea, Double rentalCosts, int numPeopleMax, String rentalType) {
        this.nameService = nameService;
        this.usableArea = usableArea;
        this.rentalCosts = rentalCosts;
        this.numPeopleMax = numPeopleMax;
        this.rentalType = rentalType;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public Double getUsableArea() {
        return usableArea;
    }

    public void setUsableArea(Double usableArea) {
        this.usableArea = usableArea;
    }

    public Double getRentalCosts() {
        return rentalCosts;
    }

    public void setRentalCosts(Double rentalCosts) {
        this.rentalCosts = rentalCosts;
    }

    public int getNumPeopleMax() {
        return numPeopleMax;
    }

    public void setNumPeopleMax(int numPeopleMax) {
        this.numPeopleMax = numPeopleMax;
    }

    public String getRentalType() {
        return rentalType;
    }

    public void setRentalType(String rentalType) {
        this.rentalType = rentalType;
    }
}
