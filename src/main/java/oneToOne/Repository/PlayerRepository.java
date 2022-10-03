package oneToOne.Repository;

import oneToOne.Entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {


}
