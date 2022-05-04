package com.caseStudy_Furama_Resort.services.impl;

import com.caseStudy_Furama_Resort.libs.IsFuramaRepositorys;
import com.caseStudy_Furama_Resort.libs.impl.FuramaRepositorys;
import com.caseStudy_Furama_Resort.services.IsFuramaService;

public class FuramaService implements IsFuramaService {
    private static final IsFuramaRepositorys isFuramaRepository = new FuramaRepositorys();
    @Override
    public void viewService() {
        isFuramaRepository.viewFurama();
    }
}
