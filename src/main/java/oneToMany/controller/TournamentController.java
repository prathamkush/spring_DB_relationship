package oneToMany.controller;

import oneToMany.entity.Registration;
import oneToMany.entity.Tournament;
import oneToMany.service.RegistrationService;
import oneToMany.service.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/tournament")
public class TournamentController {

    @Autowired
    TournamentService tourService;
    @Autowired
    RegistrationService regService;

    @GetMapping
    public List<Tournament> getTournaments(){
        return tourService.getAllTournaments();
    }

    @GetMapping("/{id}")
    public Tournament getTournamentById(@PathVariable int id) {
        return tourService.getTournamentById(id);
    }

    @PostMapping
    public Tournament addPlayer(@RequestBody Tournament t){
        return tourService.addTournament(t);
    }


    @DeleteMapping("/{id}")
    public void deleteTournament(@PathVariable int id){
        tourService.deleteTournamentById(id);
    }


    // 1:many relationship addition
    @PutMapping("/{id}/addRegistrations/{registration_id}")
    public Tournament assignDetails(@PathVariable int id, @PathVariable int registration_id){
        Registration registration = regService.getRegistrationById(registration_id);

        System.out.println(registration);
        return tourService.addRegistration(id,registration);

    }

    // 1:many relationship deletion
    @PutMapping("/{id}/removeRegistrations/{registration_id}")
    public Tournament removeDetails(@PathVariable int id, @PathVariable int registration_id){
        Registration registration = regService.getRegistrationById(registration_id);

        System.out.println(registration);
        return tourService.removeRegistration(id,registration);


    }


}
