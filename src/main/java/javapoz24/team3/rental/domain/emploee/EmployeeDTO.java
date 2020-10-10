package javapoz24.team3.rental.domain.emploee;

import lombok.Value;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;
import java.util.stream.Collectors;

@Value
public class EmployeeDTO {

    Long id;
    @NotNull
    @Size(min = 2, max = 50)
    String firstName;
    @NotNull
    @Size(min = 2, max = 50)
    String lastName;
    @NotNull
    // TODO validacja ENUMA
    Positions position;
    @NotNull
    @Digits(integer = 10, fraction = 0)
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
