package javapoz24.team3.rental.application.api;

import javapoz24.team3.rental.application.RentalService;
import javapoz24.team3.rental.application.config.RentalId;
import javapoz24.team3.rental.domain.rental.CompanyBranchDTO;
import javapoz24.team3.rental.domain.rental.RentalAllDataDTO;
import javapoz24.team3.rental.domain.rental.RentalBasicDataDTO;
import javapoz24.team3.rental.domain.rental.RentalInfo;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
public class RentalController {

    private final RentalService rentalService;

    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @GetMapping("/alldata")
    public RentalAllDataDTO getRentalWithBranches() {
        return rentalService.getAllRentalInfo(RentalId.getInstance().getId());
    }

    @GetMapping("/home")
    public RentalBasicDataDTO getRentalInfo() {
        return rentalService.getBasicRentalInfo(RentalId.getInstance().getId());
    }

    @GetMapping("/branches")
    public List<CompanyBranchDTO> getAllBranches() {
        return rentalService.getAllBranches();
    }

    @GetMapping("/branches/{id}")
    public CompanyBranchDTO getBranchById(@PathVariable Long id) {
        return rentalService.getBranchById(id)
                .map(CompanyBranchDTO::fromCompanyBranch)
                .orElse(null);
    }

    @PutMapping("/home")
    public void updateRentalInfoData(@RequestBody @NotNull @Valid RentalInfo rentalInfo) {
        rentalService.updateRentalInfoData(rentalInfo);
    }

    @PutMapping("/branches")
    public void putBranchOffice(@RequestBody @NotNull @Valid CompanyBranchDTO companyBranchDTO) {
        rentalService.addOrUpdateBranch(companyBranchDTO);
    }

}
