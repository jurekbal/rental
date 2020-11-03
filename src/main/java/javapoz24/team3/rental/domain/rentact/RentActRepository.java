package javapoz24.team3.rental.domain.rentact;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentActRepository extends JpaRepository<RentAct, Long> {

}
