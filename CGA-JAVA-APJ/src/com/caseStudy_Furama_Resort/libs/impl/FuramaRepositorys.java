package com.caseStudy_Furama_Resort.libs.impl;

import com.caseStudy_Furama_Resort.libs.IsFuramaRepositorys;

public class FuramaRepositorys implements IsFuramaRepositorys {
    @Override
    public void viewFurama() {
        System.out.println("Chào mừng bạn đến với khu nghỉ dưỡng Furama");
        System.out.println("1. Employee Management");
        System.out.println("2. Customer Management");
        System.out.println("3. Facility Management ");
        System.out.println("4. Booking Management");
        System.out.println("5. Promotion Management");
        System.out.println("6. Exit");
    }
}
