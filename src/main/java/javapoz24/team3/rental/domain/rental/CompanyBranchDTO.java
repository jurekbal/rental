package javapoz24.team3.rental.domain.rental;

import lombok.Value;

import java.util.Set;
import java.util.stream.Collectors;

@Value
public class CompanyBranchDTO {

    Address address;

    // TODO Lista pracowników, lista dostępnych aut

    public static CompanyBranchDTO fromCompanyBranch(CompanyBranch companyBranch) {
        return new CompanyBranchDTO(companyBranch.getAddress());
    }

    public static Set<CompanyBranchDTO> fromCompanyBranchSet(Set<CompanyBranch> cbSet) {
        return cbSet.stream()
                .map(CompanyBranchDTO::fromCompanyBranch)
                .collect(Collectors.toSet());
    }

}
