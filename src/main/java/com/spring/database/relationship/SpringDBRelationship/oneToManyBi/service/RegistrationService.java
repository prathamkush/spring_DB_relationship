package com.spring.database.relationship.SpringDBRelationship.oneToManyBi.service;

import com.spring.database.relationship.SpringDBRelationship.oneToManyBi.entity.Registration;
import com.spring.database.relationship.SpringDBRelationship.oneToManyBi.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegistrationService {

    @Autowired
    RegistrationRepository regRepo;

    public List<Registration> findAllRegistrations(){
        return regRepo.findAll();
    }

    public Registration getRegistrationById(int id){
        Optional<Registration> tempReg = regRepo.findById(id);

        if(tempReg.isEmpty()) throw new RuntimeException("Registration with id : "+id+" NOT FOUND !!");

        return tempReg.get();
    }

    public Registration addRegistration(Registration registration){
        return regRepo.save(registration);
    }

    public void deleteRegistration(int id){
        regRepo.deleteById(id);
    }
}
