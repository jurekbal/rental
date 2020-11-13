package javapoz24.team3.rental.application;

import javapoz24.team3.rental.domain.emploee.Employee;
import javapoz24.team3.rental.domain.emploee.EmployeeDTO;
import javapoz24.team3.rental.domain.emploee.EmployeeDomainService;
import javapoz24.team3.rental.domain.rental.CompanyBranch;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeDomainService employeeDomainService;
    private final RentalService rentalService;


    public EmployeeService(EmployeeDomainService employeeDomainService, RentalService rentalService) {
        this.employeeDomainService = employeeDomainService;
        this.rentalService = rentalService;
    }

    public Set<EmployeeDTO> getAllEmployees() {
        return employeeDomainService.getAllEmployees().stream()
                .map(EmployeeDTO::fromEmployee)
                .collect(Collectors.toSet());
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return employeeDomainService.getEmployeeById(id);
    }

    public Set<EmployeeDTO> getEmployeesByBranchId(Long branchId) {
        return employeeDomainService.getEmployeesByBranchId(branchId).stream()
                .map(EmployeeDTO::fromEmployee)
                .collect(Collectors.toSet());
    }

    public void addOrUpdateEmployee(EmployeeDTO employeeDTO) {
        Optional<CompanyBranch> optBranch = rentalService.getBranchById(employeeDTO.getBranchId());
        if (optBranch.isPresent()) {
            Employee employee = new Employee(
                    employeeDTO.getId(),
                    employeeDTO.getFirstName(),
                    employeeDTO.getLastName(),
                    employeeDTO.getPosition(),
                    optBranch.get()
            );
            employeeDomainService.saveEmployee(employee);
        }
    }
}
