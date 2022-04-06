package com.SS8_CleanCode_Refactoring.demo_mvc.repository.impl;

import com.SS8_CleanCode_Refactoring.demo_mvc.model.Student;
import com.SS8_CleanCode_Refactoring.demo_mvc.repository.IStudentRepository;

import java.util.Scanner;

public class StudentRepository implements IStudentRepository {
   public static Student[] students = new Student[1000];
   private static int numberPeopleOfCompany = 0;
    @Override
    public void saveStudent(Student student) {
        students[numberPeopleOfCompany] = student;
        numberPeopleOfCompany++;
    }
    public void viewStudent(){
        for (int i = 0; i < numberPeopleOfCompany; i++) {
            System.out.println("\n Sinh viên : " + (i +1));
            System.out.print(" Tên sinh viên = " + students[i].getNameStudent() + "\n");
            System.out.print(" Điểm sinh viên = " + students[i].getPoint()+ "\n");
            System.out.print(" ngày sinh sinh viên = " + students[i].getDateOfBirth() + "\n");
        }
    }

    @Override
    public void removeStudent(int index) {
        for (int i = index - 1 ; i < numberPeopleOfCompany; i++) {
            for (int j = index; j < numberPeopleOfCompany + 1; j++) {
                students[i] = students[j];
            }
        }
        numberPeopleOfCompany--;
    }

    @Override
    public void updateStudent(int index) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập lại tên cho sinh viên - tên cũ = " + students[index - 1].getNameStudent());
        String name = scanner.nextLine();
        students[index - 1].setNameStudent(name);
        System.out.println("Nhập lại điểm cho sinh viên - điểm cũ = " + students[index - 1].getPoint());
        int point = Integer.parseInt(scanner.nextLine());
        students[index - 1].setPoint(point);
        System.out.println("Nhập lại ngày sinh cho sinh viên = " + students[index - 1].getDateOfBirth());
        String dateOfBirth = scanner.nextLine();
        students[index - 1].setDateOfBirth(dateOfBirth);
    }
}
