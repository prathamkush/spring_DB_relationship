package com.spring.database.relationship.SpringDBRelationship.oneToOne.Controller;


import com.spring.database.relationship.SpringDBRelationship.oneToOne.Entity.Player;
import com.spring.database.relationship.SpringDBRelationship.oneToOne.Entity.PlayerProfile;
import com.spring.database.relationship.SpringDBRelationship.oneToOne.Service.PlayerProfileService;
import com.spring.database.relationship.SpringDBRelationship.oneToOne.Service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
get
get for id
post
delete

*/

@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    PlayerService pservice;
    @Autowired
    PlayerProfileService ppservice;

    @GetMapping
    public List<Player> getPlayerData(){
        return pservice.getAllPlayers();
    }

    @GetMapping("/player/{id}")
    public Player getPlayer(@PathVariable int id) {
        return pservice.findPlayerByID(id);
    }

    @PostMapping("/addPlayer")
    public Player addPlayer(@RequestBody Player p){
        return pservice.addPlayer(p);
    }


    @DeleteMapping("/deletePlayer/{id}")
    public void deletePlayer(@PathVariable int id){
        pservice.deletePlayer(id);
    }


    // 1:1 relationship
    @PutMapping("/{id}/profiles/{profile_id}")
    public Player assignDetails(@PathVariable int id, @PathVariable int profile_id){
        PlayerProfile playerProfile = ppservice.findPlayerProfileByID(profile_id);

        System.out.println(playerProfile);
        return pservice.assignProfile(id,playerProfile);

    }



}
