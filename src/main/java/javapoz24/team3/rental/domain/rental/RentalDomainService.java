package javapoz24.team3.rental.domain.rental;

import java.util.List;

public interface RentalDomainService {

    Rental getRentalInfo();

    void saveRentalInfoData(Rental rental);

    void saveBranch(CompanyBranch branch);

    List<CompanyBranch> getAllBranches();

    CompanyBranch getBranchById(Long id);
}
