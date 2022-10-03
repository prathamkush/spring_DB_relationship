package oneToOne.Entity;

import javax.persistence.*;

@Entity
public class Player {

    @Id
    @GeneratedValue
    private int id;

    private String name;

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

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", playerProfile=" + playerProfile +
                '}';
    }
}
