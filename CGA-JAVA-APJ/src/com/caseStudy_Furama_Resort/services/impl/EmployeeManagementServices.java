package com.caseStudy_Furama_Resort.services.impl;

import com.caseStudy_Furama_Resort.libs.impl.EmployeeManagementRepositorys;
import com.caseStudy_Furama_Resort.services.EmployeeManagementSevices;

public class EmployeeManagementServices implements EmployeeManagementSevices {
    private static final EmployeeManagementRepositorys employeeManagementRepositorys = new EmployeeManagementRepositorys();
    @Override
    public void displayMenu() {
        employeeManagementRepositorys.displayMenu();
    }
}
