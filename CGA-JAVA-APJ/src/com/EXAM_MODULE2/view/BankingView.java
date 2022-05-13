package com.EXAM_MODULE2.view;


import com.EXAM_MODULE2.model.Account;
import com.EXAM_MODULE2.model.PaymentAccount;
import com.EXAM_MODULE2.model.SavingAccount;
import com.EXAM_MODULE2.service.BankingService;
import com.EXAM_MODULE2.util.CommonUtil;
import com.EXAM_MODULE2.util.ValidationUtil;

import java.util.List;
import java.util.Scanner;

public class BankingView {
    private static BankingService bankingService = new BankingService();
    private static Scanner sc = new Scanner(System.in);
    private static ValidationUtil validate = new ValidationUtil();

    public static void main(String[] args) {
        displayHomeMenu();
    }

    public static void displayHomeMenu() {
        String tmp = "";
        int choice = 0;
        do {
            System.out.println("----- BANKING ACCOUNT MANAGEMENT APP -----\n" +
                    "1. Add new Account\n" +
                    "2. Delete Account\n" +
                    "3. Display Banking Account\n" +
                    "4. Search Account\n" +
                    "5. Exit");

            System.out.print(tmp.isEmpty() ? "Input your choice: " : "Please just input number from 1 to 5: ");
            tmp = sc.nextLine();
            if (validate.isNumber(tmp)) choice = Integer.parseInt(tmp);
        }
        while (choice <= 0 || choice > 6);

        switch (choice) {
            case 1:
                create();
                break;
            case 2:
                delete();
                break;
            case 3:
                display();
                break;
            case 4:
                searchByName();
                break;
            case 5:
                backToHomeMenu();
        }
        displayHomeMenu();
    }

    private static void create() {
        Account account;
        String tmp = "";
        int choice = 0;
        do {
            System.out.println("Choice type of Account to create:\n" +
                    "1. Saving\n" +
                    "2. Payment\n");
            System.out.print(tmp.isEmpty() ? "Input your choice: " : "Please just input number from 1 to 2: ");
            tmp = sc.nextLine();
            if (validate.isNumber(tmp)) choice = Integer.parseInt(tmp);
        }
        while (choice <= 0 || choice > 2);

        System.out.print("1. Account code:");
        String code = sc.nextLine();
        System.out.print("2. Name:");
        String name = sc.nextLine();
        System.out.print("3. Date create account :");
        String opendate = sc.nextLine();
        while (!validate.checkValidDate(opendate)){
            System.out.print("Date create account (dd/mm/yyyy): ");
            opendate = sc.nextLine();
        }

        if (choice == 1) {
            System.out.print("4. Amount of Saving:");
            Double amount = Double.parseDouble(sc.nextLine());
            System.out.print("5. Date of Saving:");
            String dateSaving = sc.nextLine();
            while (!validate.checkValidDate(dateSaving)){
                System.out.print("Date of Saving (dd/mm/yyyy): ");
                dateSaving = sc.nextLine();
            }
            System.out.print("6. Interest rate:");
            Double rate = Double.parseDouble(sc.nextLine());
            System.out.print("7. Saving term:");
            int term = Integer.parseInt(sc.nextLine());
            account = new SavingAccount(0, code, name, opendate, amount, dateSaving, rate, term);
        } else {
            System.out.print("4. Card number:");
            String cardNo = sc.nextLine();
            System.out.print("5. Money in card:");
            Double cash = Double.parseDouble(sc.nextLine());
            account = new PaymentAccount(0, code, name, opendate, cardNo, cash);
        }


        bankingService.create(account);
        System.out.println("Created successfully");
    }

    private static void display() {
        List<Account> accounts = bankingService.findAll();
        if (accounts.size() > 0) {
            System.out.printf("%-20s%-5s%-12s%-20s%-15s%-12s%-12s%-15s%-10s%s","Name of Account","ID","Code","Name","Open Date","CardNumber","Amount","Date Saving","Rate","Term");
            System.out.println();
            for (Account p : accounts) {
                if (p instanceof PaymentAccount) {
                    System.out.printf("%-20s%-5s%-12s%-20s%-15s%-12s%-12s%-15s%-10s%s\n","Payment Account"
                            , p.getId(), p.getCode(), p.getName(), p.getDateOpen(), ((PaymentAccount) p).getCardNumber(), ((PaymentAccount) p).getCash(),"-","-","-");
                } else {
                    System.out.printf("%-20s%-5s%-12s%-20s%-15s%-12s%-12s%-15s%-10s%s\n","Saving Account"
                            , p.getId(), p.getCode(), p.getName(), p.getDateOpen(),"-", ((SavingAccount) p).getAmount(), ((SavingAccount) p).getDateSaving(),
                            ((SavingAccount) p).getRate(), ((SavingAccount) p).getTerm());

                }
            }
        } else {
            System.out.println("Account List is empty");
        }
    }

    private static void delete() {
        display();
        System.out.print("Enter id to delete:");
        int id = Integer.parseInt(sc.nextLine());
        bankingService.delete(id);
        System.out.println("Deleted successfully");
    }
    private static void searchByName() {
        System.out.print("Enter name to search:");
        String name = sc.nextLine();
        List<Account> accounts = bankingService.searchByName(name);

        for (Account p : accounts){
            System.out.println(p);
        }
    }

    private static void backToHomeMenu() {
        System.out.print("Do you want to back to main menu (Y/N): ");
        if (CommonUtil.getScanner().nextLine().equalsIgnoreCase("y")) displayHomeMenu();
        else System.exit(0);
    }
}

