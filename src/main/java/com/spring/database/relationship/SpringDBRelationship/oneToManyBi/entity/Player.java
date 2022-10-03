package com.spring.database.relationship.SpringDBRelationship.oneToManyBi.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    // Registration Table
    // => id: 1 | player_id:alice | tournamnet_id: 1
    // => id: 2 | player_id:alice | tournament_id: 2


    // Player table => One to Many => Registrations

    // id



    // One player having many registrations
    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL)
    private List<Registration> registrationList;

    public List<Registration> getRegistrationList() {
        return registrationList;
    }

    public void setRegistrationList(List<Registration> registrationList) {
        this.registrationList = registrationList;
    }

    // Building unidirectional (one-to-one) relationship with playerProfile object into player
    // and we are setting profile id with referenced column id of playerProfile
    // One profile will have one player only
    //building 1:1 relationship with other entity
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_id",referencedColumnName = "id")
    private PlayerProfile playerProfile;


    public Player(){}

    public Player(int id, String name, PlayerProfile playerProfile){
        this.id = id;
        this.name = name;
        this.playerProfile = playerProfile;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public PlayerProfile getPlayerProfile() {
        return playerProfile;
    }

    public void setPlayerProfile(PlayerProfile playerProfile) {
        this.playerProfile = playerProfile;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Setting bi-directional relationship with Registration class
    public void registerPlayer(Registration registration){
        // add registration to the list
        registrationList.add(registration);

        // setting the player filed in registration
        registration.setPlayer(this);
        //registration.getPlayer().setRegistrationList(registrationList);
    }


    // Removing the registration
    public void removeRegistration(Registration registration){
        if(registrationList!=null) {
            registrationList.remove(registration);
            registration.setPlayer(null);
            //registration.getPlayer().setRegistrationList(registrationList);
        }
    }





    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", playerProfile=" + playerProfile +
                '}';
    }
}
