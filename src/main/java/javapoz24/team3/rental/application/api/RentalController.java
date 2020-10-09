package javapoz24.team3.rental.application.api;

import javapoz24.team3.rental.application.RentalService;
import javapoz24.team3.rental.application.config.RentalId;
import javapoz24.team3.rental.domain.emploee.Employee;
import javapoz24.team3.rental.domain.emploee.EmployeeDTO;
import javapoz24.team3.rental.domain.rental.CompanyBranch;
import javapoz24.team3.rental.domain.rental.CompanyBranchDTO;
import javapoz24.team3.rental.domain.rental.RentalDTO;
import javapoz24.team3.rental.domain.rental.RentalInfo;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
public class RentalController {

    private final RentalService rentalService;

    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @GetMapping("/home")
    public RentalDTO getRentalInfoData() {
        return rentalService.getRentalInfo(RentalId.getInstance().getId());
    }

    @GetMapping("/branches")
    public List<CompanyBranchDTO> getAllBranches() {
        return rentalService.getAllBranches();
    }

    @GetMapping("/branches/{id}")
    public CompanyBranchDTO getBranchById(@PathVariable Long id) {
        Optional<CompanyBranch> optCompanyBranch = rentalService.getBranchById(id);
        return optCompanyBranch.map(CompanyBranchDTO::fromCompanyBranch).orElse(null);
    }

    @PutMapping("/home")
    public void updateRentalInfoData(@RequestBody @NotNull @Valid RentalInfo rentalInfo) {
        rentalService.updateRentalInfoData(rentalInfo);
    }

    @PutMapping("/branches")
    public void putBranchOffice(@RequestBody @NotNull @Valid CompanyBranchDTO companyBranchDTO) {
        rentalService.addOrUpdateBranch(companyBranchDTO);
    }

    @GetMapping("/employees")
    public Set<EmployeeDTO> getAllEmployees() {
       return rentalService.getAllEmployees();
    }

    @GetMapping("/employee")
    public EmployeeDTO getEmployeeById(@RequestParam(name = "id", required = false) Long id) {
        Optional<Employee> optEmployee = rentalService.getEmployeeById(id);
        return optEmployee.map(EmployeeDTO::fromEmployee).orElse(null);
    }

    @GetMapping("/employees/branch")
    public Set<EmployeeDTO> getEmployeesByBranchId(@RequestParam(name = "branchid", required = false) Long branchId) {
        return rentalService.getEmployeesByBranchId(branchId);
    }

    @PutMapping("/employee")
    public void putEmployee(@RequestBody @NotNull EmployeeDTO employeeDTO) {
        rentalService.addOrUpdateEmployee(employeeDTO);
    }



}
