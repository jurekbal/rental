package javapoz24.team3.rental.application;

import javapoz24.team3.rental.application.config.RentalId;
import javapoz24.team3.rental.domain.rental.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RentalService {

    private final RentalDomainService rentalDomainService;

    public RentalService(RentalDomainService rentalDomainService) {
        this.rentalDomainService = rentalDomainService;
    }

    public RentalDTO getRentalInfo(Long id) {
        return RentalDTO.fromRental(rentalDomainService.getRentalInfo(id));
    }

    public void saveRentalInfoData(Rental rental) {
        rentalDomainService.saveRentalInfoData(rental);
    }

    public void saveBranch(CompanyBranch branch) {
        rentalDomainService.saveBranch(branch);
    }

    public void addBranch(CompanyBranchDTO branchDTO) {
        Rental rental = rentalDomainService.getRentalInfo(RentalId.getInstance().getId());
        CompanyBranch branch = CompanyBranch.fromDTO(branchDTO, rental);
        saveBranch(branch);
    }

    public List<CompanyBranchDTO> getAllBranches() {
        return rentalDomainService.getAllBranches().stream()
                .map(CompanyBranchDTO::fromCompanyBranch)
                .collect(Collectors.toList());
    }

    public CompanyBranchDTO getBranchById(Long id) {
        return CompanyBranchDTO.fromCompanyBranch(rentalDomainService.getBranchById(id));
    }

    public void updateRentalInfoData(RentalInfo rentalInfo) {
        Rental rental = rentalDomainService.getRentalInfo(RentalId.getInstance().getId());
        rental.setName(rentalInfo.getName());
        rental.setWebDomain(rentalInfo.getWebDomain());
        rental.setOwner(rentalInfo.getOwner());
        rental.setLogoURL(rentalInfo.getLogoURL());

        rentalDomainService.saveRentalInfoData(rental);
    }
}
