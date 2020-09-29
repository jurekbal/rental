package javapoz24.team3.rental.domain.rental;

import javapoz24.team3.rental.domain.emploee.Employee;
import lombok.Value;

import java.util.Set;
import java.util.stream.Collectors;

@Value
public class CompanyBranchDTO {

    Long id;
    Address address;
    Set<Employee> employees;

    // TODO Lista pracowników - DTO!, lista dostępnych aut

    public static CompanyBranchDTO fromCompanyBranch(CompanyBranch companyBranch) {
        return new CompanyBranchDTO(
                companyBranch.getId(),
                companyBranch.getAddress(),
                companyBranch.getEmployees()
        );
    }

    public static Set<CompanyBranchDTO> fromCompanyBranchSet(Set<CompanyBranch> cbSet) {
        return cbSet.stream()
                .map(CompanyBranchDTO::fromCompanyBranch)
                .collect(Collectors.toSet());
    }

}
