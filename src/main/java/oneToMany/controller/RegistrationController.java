package oneToMany.controller;

import oneToMany.entity.Registration;
import oneToMany.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    RegistrationService regService;

    @GetMapping
    public List<Registration> getRegistrations(){
        return regService.findAllRegistrations();
    }

    @GetMapping("/{id}")
    public Registration getRegistration(@PathVariable int id) {
        return regService.getRegistrationById(id);
    }

    @PostMapping
    public Registration addPlayer(@RequestBody Registration r){
        return regService.addRegistration(r);
    }


    @DeleteMapping("/{id}")
    public void deleteRegistration(@PathVariable int id){
        regService.deleteRegistration(id);
    }


}
