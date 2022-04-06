package com.SS8_CleanCode_Refactoring.demo_mvc.repository;

import com.SS8_CleanCode_Refactoring.demo_mvc.model.Student;

public interface IStudentRepository {
    void saveStudent(Student student);
    void viewStudent();
    void removeStudent(int index);
    void updateStudent(int index);
}
