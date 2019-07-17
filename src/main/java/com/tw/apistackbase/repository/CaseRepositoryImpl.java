package com.tw.apistackbase.repository;

import com.tw.apistackbase.model.Case;
import com.tw.apistackbase.model.CaseDescription;
import com.tw.apistackbase.model.Court;
import com.tw.apistackbase.repository.CaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<Case> getAllCasesSortByTimeDesc(){
        return caseRepository.findAll(Sort.by(Sort.Order.desc("time")));
    }

    public List<Case> getCasesByCaseName(String caseName) {
        return caseRepository.findAll().stream().filter(case1 -> case1.getCaseName().equals(caseName)).collect(Collectors.toList());
    }

    public void deleteCaseById(Long id) {
        caseRepository.deleteById(id);
    }

    // story2
    public CaseDescription getCaseDescriptionByCaseId(Long id){
        return caseRepository.findById(id).get().getDescription();
    }

    public void fillCourtInCaseIfNotHave(){
        List<Case> cases = caseRepository.findAll();
        Court defaultCourt = new Court("默认法院");
        cases.stream().map(case1 -> {
            if(case1.getCourt() == null) {
                case1.setCourt(defaultCourt);
            }
            return case1;
        });
    }
    public List<Case> findAll(){
        return caseRepository.findAll();
    }

}
