package com.tw.apistackbase.repository;

import com.tw.apistackbase.model.Case;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaseRepositoryImpl {
    @Autowired
    CaseRepository caseRepository;

    public Case getCaseById(Long id){
        return caseRepository.findById(id).get();
    }

    public Case saveCase(Case case1){
        return caseRepository.save(case1);
    }

    /*public List<Case> getAllCases(){
        return caseRepository.findAll();
    }*/
}
