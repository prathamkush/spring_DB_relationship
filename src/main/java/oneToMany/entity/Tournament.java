package oneToMany.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Tournament {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String location;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "tournament_id", referencedColumnName = "id")
    private List<Registration> registrations = new ArrayList<>();

    public Tournament(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Registration> getRegistrations() {
        return registrations;
    }

    public void setRegistrations(List<Registration> registrations) {
        this.registrations = registrations;
    }


    // Setup one to many relationship
    public void addRegistrations(Registration reg){
        this.registrations.add(reg);
    }

    public void removeRegistration(Registration reg){
        //this.registrations.removeIf(r -> r.equals(reg));
        if(this.registrations!=null) {
            this.registrations.remove(reg);
        }

    }

    @Override
    public String toString() {
        return "Tournament{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", registrations=" + registrations +
                '}';
    }



}
