package javapoz24.team3.rental.domain.emploee;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface EmployeeDomainService {

    List<Employee> getAllEmployees();

    Optional<Employee> getEmployeeById(Long id);

    Set<Employee> getEmployeesByBranchId(Long branchId);

    Employee saveEmployee(Employee employee);
}
