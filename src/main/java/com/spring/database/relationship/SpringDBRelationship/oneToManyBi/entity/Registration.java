package com.spring.database.relationship.SpringDBRelationship.oneToManyBi.entity;

import javax.persistence.*;

@Entity
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // one to many(bidirectional)
    // multiple registrations can be done by one player
    @ManyToOne(cascade = {CascadeType.PERSIST,
                            CascadeType.MERGE,
                            CascadeType.DETACH,
                            CascadeType.REFRESH})
    @JoinColumn(name="player_id", referencedColumnName = "id")
    private Player player;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Registration(){}

    public Registration(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Registration{" +
                "id=" + id +
                ", player=" + player +
                '}';
    }
}
