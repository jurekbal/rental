package javapoz24.team3.rental.domain.emploee;

import java.util.List;
import java.util.Optional;

public interface EmployeeDomainService {

    List<Employee> getAllEmployees();

    Optional<Employee> findEmployeeById(Long id);

    List<Employee> getEmployeesByBranchId(Long branchId);
}
