package javapoz24.team3.rental.domain.rental;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRepository extends JpaRepository<CompanyBranch, Long> {
}
