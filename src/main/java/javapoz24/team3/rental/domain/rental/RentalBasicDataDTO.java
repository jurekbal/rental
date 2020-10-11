package javapoz24.team3.rental.domain.rental;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Value;

import java.util.Set;
import java.util.stream.Collectors;

@Value
public class RentalBasicDataDTO {
    Long id;
    String name;
    String webDomain;
    Address address;
    String owner;
    String logoURL;
    Integer branchesCount;

    public static RentalBasicDataDTO fromRental(Rental rental) {
        return new RentalBasicDataDTO(
                rental.getId(),
                rental.getName(),
                rental.getWebDomain(),
                rental.getAddress(),
                rental.getOwner(),
                rental.getLogoURL(),
                rental.getCompanyBranches().size()
        );
    }
}
