package javapoz24.team3.rental.application.api;

import javapoz24.team3.rental.application.RentalService;
import javapoz24.team3.rental.domain.rental.CompanyBranchDTO;
import javapoz24.team3.rental.domain.rental.RentalDTO;
import javapoz24.team3.rental.domain.rental.RentalInfo;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public class RentalController {

    private final RentalService rentalService;

    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @GetMapping("/home")
    public RentalDTO getRentalInfoData() {
        return rentalService.getRentalInfo();
    }

    @GetMapping("/branches")
    public List<CompanyBranchDTO> getAllBranches() {
        return rentalService.getAllBranches();
    }

    @GetMapping("/branches/{id}")
    public CompanyBranchDTO getBranchById(@PathVariable Long id) {
        return rentalService.getBranchById(id);
    }

    @PutMapping("/home")
    public void updateRentalInfoData(@RequestBody @Validated RentalInfo rentalInfo) {
        rentalService.updateRentalInfoData(rentalInfo);
    }

    @PutMapping("/branches")
    public void addBranchOffice(@RequestBody @Validated CompanyBranchDTO companyBranchDTO) {
        rentalService.addBranch(companyBranchDTO);
    }


}
