package javapoz24.team3.rental.application.api;

import javapoz24.team3.rental.application.EmployeeService;
import javapoz24.team3.rental.domain.emploee.Employee;
import javapoz24.team3.rental.domain.emploee.EmployeeDTO;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Set;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public Set<EmployeeDTO> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public EmployeeDTO getEmployeeById(@PathVariable(name = "id") Long id) {
        return employeeService.getEmployeeById(id)
                .map(EmployeeDTO::fromEmployee)
                .orElse(null);
    }

    @GetMapping("/bybranch/{branchId}")
    public Set<EmployeeDTO> getEmployeesByBranchId(@PathVariable(name = "branchId") Long branchId) {
        return employeeService.getEmployeesByBranchId(branchId);
    }

    @PutMapping
    public void putEmployee(@RequestBody @NotNull @Valid EmployeeDTO employeeDTO) {
        employeeService.addOrUpdateEmployee(employeeDTO);
    }


}
