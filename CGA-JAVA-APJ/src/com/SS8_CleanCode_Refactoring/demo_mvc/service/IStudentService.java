package com.SS8_CleanCode_Refactoring.demo_mvc.service;

import com.SS8_CleanCode_Refactoring.demo_mvc.model.Student;

public interface IStudentService {
    void addStudent(Student student);
    void viewStudent();
    void removeStudent(int index);
    void updateStudent(int index);
}
