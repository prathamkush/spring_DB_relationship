package com.spring.database.relationship.SpringDBRelationship.oneToOne.Service;

import com.spring.database.relationship.SpringDBRelationship.oneToOne.Entity.Player;
import com.spring.database.relationship.SpringDBRelationship.oneToOne.Repository.PlayerRepository;
import com.spring.database.relationship.SpringDBRelationship.oneToOne.Repository.PlayerRepository;
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
        //repo.getOne(id) -> deprecated

        Player p = null;

        if(tempPlayer.isPresent()) p = tempPlayer.get();
        else{
            throw new RuntimeException("Player with id : "+id+" not found ");
        }
        return p;
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

}