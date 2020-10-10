package javapoz24.team3.rental.application;

import javapoz24.team3.rental.application.config.RentalId;
import javapoz24.team3.rental.domain.emploee.Employee;
import javapoz24.team3.rental.domain.emploee.EmployeeDTO;
import javapoz24.team3.rental.domain.emploee.EmployeeDomainService;
import javapoz24.team3.rental.domain.rental.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RentalService {

    private final RentalDomainService rentalDomainService;
    private final EmployeeDomainService employeeDomainService;

    public RentalService(RentalDomainService rentalDomainService, EmployeeDomainService employeeDomainService) {
        this.rentalDomainService = rentalDomainService;
        this.employeeDomainService = employeeDomainService;
    }

    public RentalDTO getRentalInfo(Long id) {
        return RentalDTO.fromRental(rentalDomainService.getRentalInfo(id));
    }

    public void saveRentalInfoData(Rental rental) {
        rentalDomainService.saveRentalInfoData(rental);
    }

    public void saveBranch(CompanyBranch branch) {
        rentalDomainService.saveBranch(branch);
    }

    public void addOrUpdateBranch(CompanyBranchDTO branchDTO) {
        Rental rental = rentalDomainService.getRentalInfo(RentalId.getInstance().getId());
        CompanyBranch branch = CompanyBranch.fromDTO(branchDTO, rental);
        saveBranch(branch);
    }

    public List<CompanyBranchDTO> getAllBranches() {
        return rentalDomainService.getAllBranches().stream()
                .map(CompanyBranchDTO::fromCompanyBranch)
                .collect(Collectors.toList());
    }

    public Optional<CompanyBranch> getBranchById(Long id) {
        return rentalDomainService.getBranchById(id);
    }

    public void updateRentalInfoData(RentalInfo rentalInfo) {
        Rental rental = rentalDomainService.getRentalInfo(RentalId.getInstance().getId());
        rental.setName(rentalInfo.getName());
        rental.setWebDomain(rentalInfo.getWebDomain());
        rental.setAddress(rentalInfo.getAddress());
        rental.setOwner(rentalInfo.getOwner());
        rental.setLogoURL(rentalInfo.getLogoURL());

        rentalDomainService.saveRentalInfoData(rental);
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
        Optional<CompanyBranch> optBranch = getBranchById(employeeDTO.getBranchId());
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
        //TODO Zwrócić odpowiedni kod/rzucić wyjątkiem w zależności od rezultatu?
    }
}
