package com.spring.database.relationship.SpringDBRelationship.oneToManyBi.controller;


//import oneToOne.Entity.Player;
//import oneToOne.Entity.PlayerProfile;
//import oneToOne.Service.PlayerProfileService;
//import oneToOne.Service.PlayerService;
import com.spring.database.relationship.SpringDBRelationship.oneToManyBi.entity.Player;
import com.spring.database.relationship.SpringDBRelationship.oneToManyBi.entity.PlayerProfile;
import com.spring.database.relationship.SpringDBRelationship.oneToManyBi.entity.Registration;
import com.spring.database.relationship.SpringDBRelationship.oneToManyBi.entity.Tournament;
import com.spring.database.relationship.SpringDBRelationship.oneToManyBi.service.PlayerProfileService;
import com.spring.database.relationship.SpringDBRelationship.oneToManyBi.service.PlayerService;
//import oneToOne.Entity.PlayerProfile;
import com.spring.database.relationship.SpringDBRelationship.oneToManyBi.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    RegistrationService regService;

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


    // 1:many relationship addition
    @PutMapping("/{id}/addRegistrations/{registration_id}")
    public Player assignRegistration(@PathVariable int id, @PathVariable int registration_id){
        Registration registration = regService.getRegistrationById(registration_id);

        System.out.println(registration);
        return pservice.assignRegistration(id,registration);

    }

    // 1:many relationship removal
    @PutMapping("/{id}/removeRegistrations/{registration_id}")
    public Player removeRegistration(@PathVariable int id, @PathVariable int registration_id){
        Registration registration = regService.getRegistrationById(registration_id);

        System.out.println(registration);
        return pservice.removeRegistration(id,registration);
    }



}
