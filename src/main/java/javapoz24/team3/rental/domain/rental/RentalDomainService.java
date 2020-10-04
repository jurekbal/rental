package javapoz24.team3.rental.domain.rental;

import java.util.List;
import java.util.Optional;

public interface RentalDomainService {

    Rental getRentalInfo(Long id);

    void saveRentalInfoData(Rental rental);

    void saveBranch(CompanyBranch branch);

    List<CompanyBranch> getAllBranches();

    CompanyBranch getBranchById(Long id);
}
