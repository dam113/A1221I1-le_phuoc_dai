package com.caseStudy_Furama_Resort.views;

import com.caseStudy_Furama_Resort.controllers.FuramaController;

import java.util.Scanner;

public class FuramaViews {
    private static final FuramaController furamaController = new FuramaController();
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        displayMenu();
    }

    public static void displayMenu() {
        int choice;
        do {
            furamaController.displayMainMenu();
            System.out.println("Nhập chức năng:  ");
            choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 1:
                    EmployeeManagementView.displayMenu();
                    break;
                case 2:
                    CustomerManagementView.displayMenu();
                    break;
                case 3:
                    FacilityManagementView.displayMenu();
                    break;
                case 4:
                    BookingManagementView.displayMenu();
                    break;
                case 5:
                    PromotionManagementView.displayMenu();
                    break;
                case 6:
                    break;
                default:
                    System.out.println("No choice");
            }
        }while (choice < 0 || choice > 6) ;
    }
}
