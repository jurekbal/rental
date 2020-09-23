package javapoz24.team3.rental.domain.rental;

import javapoz24.team3.rental.domain.base.BaseEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class CompanyBranch extends BaseEntity {

    @OneToOne(mappedBy = "companyBranch")
    private Address address;

    @ManyToOne
    @ToString.Exclude
    private Rental rental;

    // TODO Lista pracowników, lista dostępnych aut

}
