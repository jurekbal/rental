package javapoz24.team3.rental.domain.emploee;

import lombok.Value;

import java.util.Set;
import java.util.stream.Collectors;

@Value
public class EmployeeDTO {

    Long id;
    String firstName;
    String lastName;
    Positions position;
    Long branchId;

    public static EmployeeDTO fromEmployee(Employee employee) {
        return new EmployeeDTO(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getPosition(),
                employee.getCompanyBranch().getId()
        );
    }

    public static Set<EmployeeDTO> fromEmployeesSet(Set<Employee> employeeSet) {
        return employeeSet.stream()
                .map(EmployeeDTO::fromEmployee)
                .collect(Collectors.toSet());
    }


}
