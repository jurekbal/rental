package javapoz24.team3.rental.application.experimental;

import javapoz24.team3.rental.domain.rental.RentalDomainService;
import org.springframework.stereotype.Service;

@Service
public class XService {

    private final RentalDomainService rentalDomainService;

    public XService(RentalDomainService rentalDomainService) {
        this.rentalDomainService = rentalDomainService;
    }

    public Long getOpenBranchCount() {
        return rentalDomainService.getOpenBranchesCount();
    }
}
