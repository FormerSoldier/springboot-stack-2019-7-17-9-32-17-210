package com.tw.apistackbase.repository;

import com.tw.apistackbase.model.Court;
import com.tw.apistackbase.repository.CourtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourtRepositoryImpl {

    @Autowired
    CourtRepository courtRepository;

    public Court getCourtByCourtId(Long id){
        return courtRepository.findById(id).get();
    }

    public void save(Court court){
        courtRepository.save(court);
    }

    public CourtRepository getCourtRepository() {
        return courtRepository;
    }

    public void setCourtRepository(CourtRepository courtRepository) {
        this.courtRepository = courtRepository;
    }
}
