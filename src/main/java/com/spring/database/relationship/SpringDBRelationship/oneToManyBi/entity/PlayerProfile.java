package com.spring.database.relationship.SpringDBRelationship.oneToManyBi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PlayerProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String insta;

    public PlayerProfile(){}

    public PlayerProfile(int id, String insta) {
        this.id = id;
        this.insta = insta;
    }

    public int getId() {
        return id;
    }

    public String getInsta() {
        return insta;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setInsta(String insta) {
        this.insta = insta;
    }

    @Override
    public String toString() {
        return "PlayerProfile{" +
                "id=" + id +
                ", insta='" + insta + '\'' +
                '}';
    }
}
