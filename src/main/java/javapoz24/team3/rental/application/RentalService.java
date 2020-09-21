package javapoz24.team3.rental.application;

import javapoz24.team3.rental.domain.rental.Rental;
import javapoz24.team3.rental.domain.rental.RentalDomainService;
import org.springframework.stereotype.Service;

@Service
public class RentalService {

    private final RentalDomainService rentalDomainService;

    public RentalService(RentalDomainService rentalDomainService) {
        this.rentalDomainService = rentalDomainService;
    }

    public Rental getRentalInfo() {
        return rentalDomainService.getRentalInfo();
    }

    public void saveRentalIndoData(Rental rental) {
        rentalDomainService.saveRentalInfoData(rental);
    }
}
