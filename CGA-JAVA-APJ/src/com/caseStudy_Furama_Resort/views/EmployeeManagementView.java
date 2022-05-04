package com.caseStudy_Furama_Resort.views;

import com.caseStudy_Furama_Resort.controllers.EmployeeManagementController;
import com.caseStudy_Furama_Resort.controllers.FuramaController;

public class EmployeeManagementView {
    private static final EmployeeManagementController employeeManagementController = new EmployeeManagementController();
    public static void displayMenu(){
        employeeManagementController.displaymenu();
    }

}
