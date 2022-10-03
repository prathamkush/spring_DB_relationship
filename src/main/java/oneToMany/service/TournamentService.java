package oneToMany.service;

import oneToMany.entity.Registration;
import oneToMany.entity.Tournament;
import oneToMany.repository.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TournamentService {

    @Autowired
    TournamentRepository tourRepo;

    public List<Tournament> getAllTournaments(){
        return tourRepo.findAll();
    }

    public Tournament getTournamentById(int id){
        Optional<Tournament> tempTournament = tourRepo.findById(id);

        if(tempTournament.isEmpty()) throw new RuntimeException("Tournament with id : "+id+" NOT FOUND !!");

        return tempTournament.get();
    }

    public Tournament addTournament(Tournament tournament){
        return tourRepo.save(tournament);
    }

    public void deleteTournamentById(int id){
        tourRepo.deleteById(id);
    }

    // for 1:many adding
    public Tournament addRegistration(int id, Registration registration){
        Tournament tempTournament = tourRepo.findById(id).get();

        tempTournament.addRegistrations(registration);

        return tourRepo.save(tempTournament);

    }

    // for 1:many removal
    public Tournament removeRegistration(int id, Registration registration){
        Tournament tempTournament = tourRepo.findById(id).get();
        tempTournament.removeRegistration(registration);
        return tourRepo.save(tempTournament);
    }

}
