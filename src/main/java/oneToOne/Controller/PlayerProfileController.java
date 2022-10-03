package oneToOne.Controller;

import oneToOne.Entity.PlayerProfile;
import oneToOne.Service.PlayerProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profiles")
public class PlayerProfileController {
    @Autowired
    PlayerProfileService ppservice;

    @GetMapping
    public List<PlayerProfile> getPlayerData(){
        return ppservice.getAllPlayerProfiles();
    }

    @GetMapping("/playerProfile/{id}")
    public PlayerProfile getPlayer(@PathVariable int id) {
        return ppservice.findPlayerProfileByID(id);
    }

    @PostMapping("/addPlayerProfile")
    public PlayerProfile addPlayer(@RequestBody PlayerProfile p){
        return ppservice.addPlayerProfile(p);
    }


    @DeleteMapping("/deletePlayerProfile/{id}")
    public void deletePlayer(@PathVariable int id){
        ppservice.deletePlayerProfile(id);
    }

}
