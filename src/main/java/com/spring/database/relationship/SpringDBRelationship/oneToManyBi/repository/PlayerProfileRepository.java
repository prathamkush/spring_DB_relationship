package com.spring.database.relationship.SpringDBRelationship.oneToManyBi.repository;

//import oneToOne.Entity.PlayerProfile;
import com.spring.database.relationship.SpringDBRelationship.oneToManyBi.entity.PlayerProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerProfileRepository extends JpaRepository<PlayerProfile, Integer> {
}
