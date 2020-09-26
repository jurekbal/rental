package javapoz24.team3.rental.domain.rental;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Value;

import java.util.Set;

@Value
public class RentalDTO {
    // @Value - wszystkie pola są private final
    String name;
    String webDomain;
    String owner;
    String logoURL;
    @JsonIgnoreProperties("rental")
    Set<CompanyBranchDTO> companyBranches;

    public static RentalDTO fromRental(Rental rental) {
        return new RentalDTO(
                rental.getName(),
                rental.getWebDomain(),
                rental.getOwner(),
                rental.getLogoURL(),
                CompanyBranchDTO.fromCompanyBranchSet(rental.getCompanyBranches())
        );
    }
}
