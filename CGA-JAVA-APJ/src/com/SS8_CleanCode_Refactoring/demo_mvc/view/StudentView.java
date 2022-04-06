package com.SS8_CleanCode_Refactoring.demo_mvc.view;

import com.SS8_CleanCode_Refactoring.demo_mvc.controller.StudentController;
import com.SS8_CleanCode_Refactoring.demo_mvc.model.Student;

import java.util.Scanner;

public class StudentView {
    static Scanner scanner = new Scanner(System.in);
    private static final StudentController studentController = new StudentController();

    public static void main(String[] args) {
        while(true) {
            System.out.println("\n Chào mừng bạn đến với trang web quản lí học sinh");
            System.out.println("1.Xem danh sách học sinh");
            System.out.println("2. Thêm mới học sinh");
            System.out.println("3. Xóa học sinh");
            System.out.println("4. Cập nhất thông tin cho học sinh");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.print("Danh sách sinh viên \n");
                    studentController.viewStudent();
                    break;
                case 2:
                    Student student = inputInformationOfStudent();
                    studentController.addStudent(student);
                    break;
                case 3:
                    int index = removeStudent();
                    studentController.removeStudent(index);
                    break;
                case 4:
                    int i = updateStudent();
                    studentController.updateStudent(i);
                    break;
            }
        }
    }

    private static Student inputInformationOfStudent() {
        System.out.print("Mời bạn nhập tên của học sinh: ");
        String name = scanner.nextLine();
        System.out.print("Mời bạn nhập điểm của học sinh: ");
        double point = Double.parseDouble(scanner.nextLine());
        System.out.print("Mời bạn nhập ngày tháng năm sinh của học sinh: ");
        String dateOfBirth = scanner.nextLine();
        return new Student(name, point, dateOfBirth);
    }

    private static int removeStudent(){
        System.out.println("Nhập số thứ tự của sinh viên cần xóa: ");
        int index = Integer.parseInt(scanner.nextLine());
        return index;
    }

    private static int updateStudent(){
        System.out.println("Nhập số thứ tự của sinh viên cần thay đổi: ");
        int i = Integer.parseInt(scanner.nextLine());
        return i;
    }
}
