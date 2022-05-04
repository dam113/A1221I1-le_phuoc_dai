package com.caseStudy_Furama_Resort.controllers;

import com.caseStudy_Furama_Resort.services.EmployeeManagementSevices;
import com.caseStudy_Furama_Resort.services.impl.EmployeeManagementServices;

public class EmployeeManagementController {
    private static final EmployeeManagementSevices employeeManagementSevices = new EmployeeManagementServices();
    public void displaymenu() {
        employeeManagementSevices.displayMenu();
    }

}
