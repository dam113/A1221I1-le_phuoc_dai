package com.SS8_CleanCode_Refactoring.demo_mvc.controller;

import com.SS8_CleanCode_Refactoring.demo_mvc.model.Student;
import com.SS8_CleanCode_Refactoring.demo_mvc.service.IStudentService;
import com.SS8_CleanCode_Refactoring.demo_mvc.service.impl.StudentService;

public class StudentController {
    // DI
    private static final IStudentService iStudentService = new StudentService();
    public void viewStudent(){iStudentService.viewStudent();}
    public void addStudent(Student student) {
        iStudentService.addStudent(student);
    }
    public void removeStudent(int index) {
        iStudentService.removeStudent(index);
    }
    public void updateStudent(int index){
        iStudentService.updateStudent(index);
    }
}
