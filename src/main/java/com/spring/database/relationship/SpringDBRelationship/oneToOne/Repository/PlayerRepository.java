package com.spring.database.relationship.SpringDBRelationship.oneToOne.Repository;

import com.spring.database.relationship.SpringDBRelationship.oneToOne.Entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {


}
