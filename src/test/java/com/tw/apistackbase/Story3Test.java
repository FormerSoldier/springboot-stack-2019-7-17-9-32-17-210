package com.tw.apistackbase;

import com.tw.apistackbase.model.Case;
import com.tw.apistackbase.model.Court;
import com.tw.apistackbase.repository.CaseRepository;
import com.tw.apistackbase.repository.CaseRepositoryImpl;
import com.tw.apistackbase.repository.CourtRepositoryImpl;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class Story3Test {

    @Autowired
    CaseRepositoryImpl caseRepository;

    @Autowired
    CourtRepositoryImpl courtRepositoryImpl;

    @Test
    public void should_return_court_when_call_get_court_by_court_id_given_court_id(){
        Court court1 = new Court("广东法院");
        Court court2 = new Court("广西法院");
        Court court3 = new Court("湖南法院");

        courtRepositoryImpl.save(court1);
        courtRepositoryImpl.save(court2);
        courtRepositoryImpl.save(court3);

        Court result_court = courtRepositoryImpl.getCourtByCourtId(Long.valueOf(2));

        Assertions.assertEquals(result_court,court2);

    }

   /* @Test
    public void fill_court_in_case_if_it_not_have(){
        int originSize = caseRepository.findAll().size();
        caseRepository.fillCourtInCaseIfNotHave();
        List<Case> cases = caseRepository.findAll().stream().filter(case1 -> case1.getCourt() != null).collect(Collectors.toList());
        int finalSize = cases.size();

        Assertions.assertEquals(originSize,finalSize);
    }*/

}
