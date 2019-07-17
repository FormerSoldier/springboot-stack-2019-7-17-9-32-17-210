package com.tw.apistackbase;

import com.tw.apistackbase.model.Court;
import com.tw.apistackbase.repository.CourtRepositoryImpl;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class Story3Test {

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
}
