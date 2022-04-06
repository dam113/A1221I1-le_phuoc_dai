package com.SS8_CleanCode_Refactoring.demo_mvc.service.impl;

import com.SS8_CleanCode_Refactoring.demo_mvc.model.Student;
import com.SS8_CleanCode_Refactoring.demo_mvc.repository.IStudentRepository;
import com.SS8_CleanCode_Refactoring.demo_mvc.repository.impl.StudentRepository;
import com.SS8_CleanCode_Refactoring.demo_mvc.service.IStudentService;

public class StudentService implements IStudentService {
    private static final IStudentRepository iStudentRepository = new StudentRepository();
    @Override
    public void addStudent(Student student) {
        if(student.getPoint()<0) {

        } else {
            iStudentRepository.saveStudent(student);
        }
    }

    public void viewStudent(){
        iStudentRepository.viewStudent();
    }

    @Override
    public void removeStudent(int index) {
        iStudentRepository.removeStudent(index);
    }

    @Override
    public void updateStudent(int index) {
        iStudentRepository.updateStudent(index);
    }


}
