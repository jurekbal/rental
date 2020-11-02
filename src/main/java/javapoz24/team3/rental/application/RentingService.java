package javapoz24.team3.rental.application;

import javapoz24.team3.rental.domain.rentact.RentAct;
import javapoz24.team3.rental.domain.rentact.RentActDomainService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RentingService {

    private final RentActDomainService rentActDomainService;

    public RentingService(RentActDomainService rentActDomainService) {
        this.rentActDomainService = rentActDomainService;
    }

    public Optional<RentAct> getRentActById(Long id) {
        return rentActDomainService.getRentActById(id);
    }
}
