package javapoz24.team3.rental.domain.emploee;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class EmployeeDomainServiceImpl implements EmployeeDomainService{

    private final EmployeeRepository employeeRepository;

    public EmployeeDomainServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Set<Employee> getEmployeesByBranchId(Long branchId) {
        return employeeRepository.findByCompanyBranchId(branchId);
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
}
