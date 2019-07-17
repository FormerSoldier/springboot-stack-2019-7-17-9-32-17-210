package com.tw.apistackbase.repository;

import com.tw.apistackbase.model.Inquisitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InquisitorRepositoryImpl {

    @Autowired
    InquisitorRepository inquisitorRepository;

    public Inquisitor getInquisitorById(Long id){
        return inquisitorRepository.findById(id).get();
    }
    public List<Inquisitor> getAllInquisitor(){
        return inquisitorRepository.findAll();
    }
    public void save(Inquisitor inquisitor){
        inquisitorRepository.save(inquisitor);
    }
}
