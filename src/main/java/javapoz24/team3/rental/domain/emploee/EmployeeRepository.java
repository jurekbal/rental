package javapoz24.team3.rental.domain.emploee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    Set<Employee> findByCompanyBranchId(Long branchId);
}
