package com.caseStudy_Furama_Resort.libs.impl;

import com.caseStudy_Furama_Resort.libs.IsEmployeeManagementRepository;

public class EmployeeManagementRepositorys implements IsEmployeeManagementRepository {
    @Override
    public void displayMenu() {
        System.out.println("Chức năng số 2 Customer Management ");
        System.out.println("1. Display list customers ");
        System.out.println("2. Add new customer ");
        System.out.println("3. Edit customer");
        System.out.println("4. Return main menu ");
    }

}
