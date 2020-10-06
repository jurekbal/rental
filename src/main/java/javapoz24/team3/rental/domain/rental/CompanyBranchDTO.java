package javapoz24.team3.rental.domain.rental;

import javapoz24.team3.rental.domain.emploee.EmployeeDTO;
import lombok.Value;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Set;
import java.util.stream.Collectors;

@Value
public class CompanyBranchDTO {

    Long id;
    @NotNull
    @Valid
    Address address;
    Set<EmployeeDTO> employees;

    // TODO lista dostępnych aut

    public static CompanyBranchDTO fromCompanyBranch(CompanyBranch companyBranch) {
        if (companyBranch != null) {
            return new CompanyBranchDTO(
                companyBranch.getId(),
                companyBranch.getAddress(),
                EmployeeDTO.fromEmployeesSet(companyBranch.getEmployees())
        );
        }
        return null;
    }

    public static Set<CompanyBranchDTO> fromCompanyBranchSet(Set<CompanyBranch> cbSet) {
        return cbSet.stream()
                .map(CompanyBranchDTO::fromCompanyBranch)
                .collect(Collectors.toSet());
    }

}
