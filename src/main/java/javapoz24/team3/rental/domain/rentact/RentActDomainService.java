package javapoz24.team3.rental.domain.rentact;

import org.springframework.stereotype.Service;

import java.util.Optional;

public interface RentActDomainService {
    Optional<RentAct> getRentActById(Long id);
}
