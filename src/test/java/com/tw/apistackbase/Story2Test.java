package com.tw.apistackbase;

import com.tw.apistackbase.model.Case;
import com.tw.apistackbase.model.CaseDescription;
import com.tw.apistackbase.repository.CaseRepositoryImpl;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.Describable;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class Story2Test {

    @Autowired
    CaseRepositoryImpl caseRepository;

    @Test
    public void should_return_description_when_call_get_case_description_by_case_id(){
        Case case1 = new Case("上课睡觉",new Date().getTime());
        CaseDescription description = new CaseDescription("主观有罪","客观无罪");
        case1.setDescription(description);
        caseRepository.saveCase(case1);

        CaseDescription description1 = caseRepository.getCaseDescriptionByCaseId(Long.valueOf(1));

        Assertions.assertNotNull(description);
    }
}
