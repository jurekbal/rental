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
    public Rental getAllRentalInfo(Long id) {
        Optional<Rental> optRental =  rentalRepository.findById(id);
        return optRental.orElse(null);
    }

    @Override
    public Rental saveRentalInfoData(Rental rental) {
        return rentalRepository.save(rental);
    }

    @Override
    public CompanyBranch saveBranch(CompanyBranch branch) {
        return branchRepository.save(branch);
    }

    @Override
    public List<CompanyBranch> getAllBranches() {
        return branchRepository.findAll();
    }

    @Override
    public Optional<CompanyBranch> getBranchById(Long id) {
        return branchRepository.findById(id);
    }

    @Override
    public Long getOpenBranchesCount() {
        return branchRepository.countAllByClosedFalse();
    }
}
