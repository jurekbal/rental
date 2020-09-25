package javapoz24.team3.rental.domain.rental;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RentalDomainServiceImpl implements RentalDomainService {

    private final RentalRepository rentalRepository;
    private final BranchRepository branchRepository;

    public RentalDomainServiceImpl(RentalRepository rentalRepository, BranchRepository branchRepository) {
        this.rentalRepository = rentalRepository;
        this.branchRepository = branchRepository;
    }

    @Override
    public Rental getRentalInfo() {
        //for now we expect one and only Rental entry with correct data
        return rentalRepository.findAll().get(0);
    }

    @Override
    public void saveRentalInfoData(Rental rental) {
        rentalRepository.save(rental);
    }

    @Override
    public void saveBranch(CompanyBranch branch) {
        branchRepository.save(branch);
    }

    @Override
    public List<CompanyBranch> getAllBranches() {
        return branchRepository.findAll();
    }

    @Override
    public CompanyBranch getBranchById(Long id) {
        Optional<CompanyBranch> optBranch = branchRepository.findById(id);
        return optBranch.orElse(null);
    }
}
