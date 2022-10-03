package com.spring.database.relationship.SpringDBRelationship.oneToManyBi.repository;

import com.spring.database.relationship.SpringDBRelationship.oneToManyBi.entity.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Integer> {

}
