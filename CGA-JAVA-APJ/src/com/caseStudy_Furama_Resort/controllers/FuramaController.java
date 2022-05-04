package com.caseStudy_Furama_Resort.controllers;

import com.caseStudy_Furama_Resort.services.IsFuramaService;
import com.caseStudy_Furama_Resort.services.impl.FuramaService;

public class FuramaController {
    private static final IsFuramaService FuramaService = new FuramaService();

    public void displayMainMenu(){FuramaService.viewService();}
}
