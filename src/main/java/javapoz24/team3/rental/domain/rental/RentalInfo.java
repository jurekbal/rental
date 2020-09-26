package javapoz24.team3.rental.domain.rental;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RentalInfo {
    String name;
    String webDomain;
    String owner;
    String logoURL;
}
