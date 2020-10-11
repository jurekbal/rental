package javapoz24.team3.rental.application;

import javapoz24.team3.rental.application.config.RentalId;
import javapoz24.team3.rental.domain.car.CarDTO;
import javapoz24.team3.rental.domain.car.CarDomainService;
import javapoz24.team3.rental.domain.rental.*;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RentalService {

    private final RentalDomainService rentalDomainService;
    private final CarDomainService carDomainService;

    public RentalService(RentalDomainService rentalDomainService, CarDomainService carDomainService) {
        this.rentalDomainService = rentalDomainService;
        this.carDomainService = carDomainService;
    }

    public RentalAllDataDTO getAllRentalInfo(Long id) {
        return RentalAllDataDTO.fromRental(rentalDomainService.getAllRentalInfo(id));
    }

    public RentalBasicDataDTO getBasicRentalInfo(Long id) {
        return RentalBasicDataDTO.fromRental(rentalDomainService.getAllRentalInfo(id));
    }

    public void saveRentalInfoData(Rental rental) {
        rentalDomainService.saveRentalInfoData(rental);
    }

    public void saveBranch(CompanyBranch branch) {
        rentalDomainService.saveBranch(branch);
    }

    public void addOrUpdateBranch(CompanyBranchDTO branchDTO) {
        Rental rental = rentalDomainService.getAllRentalInfo(RentalId.getInstance().getId());
        CompanyBranch branch = CompanyBranch.fromDTO(branchDTO, rental);
        saveBranch(branch);
    }

    public List<CompanyBranchDTO> getAllBranches() {
        return rentalDomainService.getAllBranches().stream()
                .map(CompanyBranchDTO::fromCompanyBranch)
                .collect(Collectors.toList());
    }

    public Optional<CompanyBranch> getBranchById(Long id) {
        return rentalDomainService.getBranchById(id);
    }

    public void updateRentalInfoData(RentalInfo rentalInfo) {
        Rental rental = rentalDomainService.getAllRentalInfo(RentalId.getInstance().getId());
        rental.setName(rentalInfo.getName());
        rental.setWebDomain(rentalInfo.getWebDomain());
        rental.setAddress(rentalInfo.getAddress());
        rental.setOwner(rentalInfo.getOwner());
        rental.setLogoURL(rentalInfo.getLogoURL());

        rentalDomainService.saveRentalInfoData(rental);
    }

    public List<CarDTO> getCarsInBranch(Long branchId) {
        Optional<CompanyBranch> optBranch = getBranchById(branchId);
        return optBranch.map(companyBranch -> carDomainService.getCarsInBranch(companyBranch).stream()
                .map(CarDTO::fromCar)
                .collect(Collectors.toList())).orElse(Collections.emptyList());
    }
}
