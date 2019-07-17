package com.tw.apistackbase;


import com.tw.apistackbase.exception.DataToLongException;
import com.tw.apistackbase.model.Case;
import com.tw.apistackbase.repository.CaseRepository;
import com.tw.apistackbase.repository.CaseRepositoryImpl;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class Story1Test {

    @Autowired
    CaseRepositoryImpl caseRepositoryImpl;

    @Test
    public void should_return_case_when_call_get_case_by_id(){
        Case case1 = new Case("醉驾醉驾醉驾驾",new Date().getTime());
        caseRepositoryImpl.saveCase(case1);
        Case result_case = caseRepositoryImpl.getCaseById(Long.valueOf(1));
        Assertions.assertEquals(result_case, case1);
    }

    @Test
    public void should_return_cases_when_call_get_cases_reverse(){
        Case case1 = new Case("打人",new Date().getTime());
        Case case2 = new Case("碰瓷",new Date().getTime() + 10);
        caseRepositoryImpl.saveCase(case1);
        caseRepositoryImpl.saveCase(case2);

        List<Case> cases = caseRepositoryImpl.getAllCasesSortByTimeDesc();

        List<Case> testCases = new ArrayList<>();
        testCases.add(case2);
        testCases.add(case1);
        Assertions.assertEquals(cases, testCases);
    }

}
