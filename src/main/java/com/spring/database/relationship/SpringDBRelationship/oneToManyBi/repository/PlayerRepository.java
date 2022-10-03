package com.spring.database.relationship.SpringDBRelationship.oneToManyBi.repository;

//import oneToOne.Entity.Player;
import com.spring.database.relationship.SpringDBRelationship.oneToManyBi.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {


}
