package javapoz24.team3.rental.application.api;

import javapoz24.team3.rental.application.RentalService;
import javapoz24.team3.rental.domain.rental.CompanyBranch;
import javapoz24.team3.rental.domain.rental.Rental;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RentalController {

    private final RentalService rentalService;

    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @GetMapping("/home")
    public Rental getRentalInfoData() {
        return rentalService.getRentalInfo();
    }

    @GetMapping("/branches")
    public List<CompanyBranch> getAllBranches() {
        return rentalService.getAllBranches();
    }

    @GetMapping("/branches/{id}")
    public CompanyBranch getBranchById(@PathVariable Long id) {
        return rentalService.getBranchById(id);
    }


}
