package com.spring.database.relationship.SpringDBRelationship.oneToOne.Service;


import com.spring.database.relationship.SpringDBRelationship.oneToOne.Entity.Player;
import com.spring.database.relationship.SpringDBRelationship.oneToOne.Entity.PlayerProfile;
import com.spring.database.relationship.SpringDBRelationship.oneToOne.Repository.PlayerProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerProfileService {

    @Autowired
    PlayerProfileRepository pprepo;

    // get all player profiles
    public List<PlayerProfile> getAllPlayerProfiles(){
        return pprepo.findAll();
    }

    // get player profile by id
    public PlayerProfile findPlayerProfileByID(@PathVariable("id") int id){
        Optional<PlayerProfile> tempPlayer = pprepo.findById(id);

        if(tempPlayer.isEmpty()) throw new RuntimeException("Player Profile with id : "+id+" not found ");

        return tempPlayer.get();
    }

    // save player
    //addPlayer(post)
    public PlayerProfile addPlayerProfile(PlayerProfile player){
        return pprepo.save(player);
    }


    // delete player
    // delete operations
    public void deletePlayerProfile(int id){
        Optional<PlayerProfile> tempPlayer = pprepo.findById(id);

        //  if(tempPlayer.isEmpty()) throw new RuntimeException("Player with id : "+id+" not found ");
        if(tempPlayer.isEmpty()) throw new RuntimeException("Player Profile with id : "+id+" not found ");

        pprepo.delete(tempPlayer.get());
    }













}
