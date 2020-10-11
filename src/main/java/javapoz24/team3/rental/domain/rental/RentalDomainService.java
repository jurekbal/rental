package javapoz24.team3.rental.domain.rental;

import java.util.List;
import java.util.Optional;

public interface RentalDomainService {

    Rental getAllRentalInfo(Long id);

    void saveRentalInfoData(Rental rental);

    CompanyBranch saveBranch(CompanyBranch branch);

    List<CompanyBranch> getAllBranches();

    Optional<CompanyBranch> getBranchById(Long id);
}
