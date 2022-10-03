package com.spring.database.relationship.SpringDBRelationship.oneToManyBi.service;

//import oneToOne.Entity.Player;
//import oneToOne.Entity.PlayerProfile;
//import oneToOne.Repository.PlayerRepository;
import com.spring.database.relationship.SpringDBRelationship.oneToManyBi.entity.Player;
import com.spring.database.relationship.SpringDBRelationship.oneToManyBi.entity.PlayerProfile;
import com.spring.database.relationship.SpringDBRelationship.oneToManyBi.entity.Registration;
import com.spring.database.relationship.SpringDBRelationship.oneToManyBi.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    PlayerRepository prepo;

    // get all player profiles
    public List<Player> getAllPlayers(){
        return prepo.findAll();
    }

    // get player profile by id
    public Player findPlayerByID(@PathVariable("id") int id){
        Optional<Player> tempPlayer = prepo.findById(id);

        if(tempPlayer.isEmpty())throw new RuntimeException("Player with id : "+id+" not found ");
        return tempPlayer.get();
    }

    // save player
    //addPlayer(post)
    public Player addPlayer(Player player){
        return prepo.save(player);
    }


    // delete player
    // delete operations
    public void deletePlayer(int id){
        Optional<Player> tempPlayer = prepo.findById(id);

        //  if(tempPlayer.isEmpty()) throw new RuntimeException("Player with id : "+id+" not found ");
        if(tempPlayer.isEmpty()) throw new RuntimeException("Player with id : "+id+" not found ");

        prepo.delete(tempPlayer.get());
    }


    public Player assignProfile(int id, PlayerProfile profile){
        Player player = prepo.findById(id).get();

        player.setPlayerProfile(profile);

        return prepo.save(player);
    }


    public Player assignRegistration(int id, Registration registration){
        Player player = prepo.findById(id).get();

        player.registerPlayer(registration);
        return prepo.save(player);
    }

    public Player removeRegistration(int id, Registration registration){
        Player player = prepo.findById(id).get();

        player.removeRegistration(registration);

        return prepo.save(player);
    }


}
