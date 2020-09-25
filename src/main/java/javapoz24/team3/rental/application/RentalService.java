package javapoz24.team3.rental.application;

import javapoz24.team3.rental.domain.rental.CompanyBranch;
import javapoz24.team3.rental.domain.rental.Rental;
import javapoz24.team3.rental.domain.rental.RentalDomainService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalService {

    private final RentalDomainService rentalDomainService;

    public RentalService(RentalDomainService rentalDomainService) {
        this.rentalDomainService = rentalDomainService;
    }

    public Rental getRentalInfo() {
        return rentalDomainService.getRentalInfo();
    }

    public void saveRentalInfoData(Rental rental) {
        rentalDomainService.saveRentalInfoData(rental);
    }

    public void saveBranch(CompanyBranch branch) {
        rentalDomainService.saveBranch(branch);
    }

    public List<CompanyBranch> getAllBranches() {
        return rentalDomainService.getAllBranches();
    }

    public CompanyBranch getBranchById(Long id) {
        return rentalDomainService.getBranchById(id);
    }
}
