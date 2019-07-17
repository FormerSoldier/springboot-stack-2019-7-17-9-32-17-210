package com.tw.apistackbase;

import com.tw.apistackbase.model.Inquisitor;
import com.tw.apistackbase.repository.InquisitorRepositoryImpl;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class Story4Test {
    @Autowired
    InquisitorRepositoryImpl inquisitorRepository;

    @Test
    public void should_return_inquisitor_when_call_get_inquisitor_by_id_given_id(){
        Inquisitor inquisitor = new Inquisitor("我是检察官");
        Inquisitor inquisitor2 = new Inquisitor("超级检察官");
        inquisitorRepository.save(inquisitor);
        inquisitorRepository.save(inquisitor2);

        Inquisitor result_return = inquisitorRepository.getInquisitorById(Long.valueOf(2));
        Assertions.assertEquals(result_return, inquisitor2);
    }
}
