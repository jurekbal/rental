package javapoz24.team3.rental.domain.rental;

import javapoz24.team3.rental.domain.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class CompanyBranch extends BaseEntity {

    @Embedded
    private Address address;

    @ManyToOne
    @ToString.Exclude
    private Rental rental;

    // TODO Lista pracowników, lista dostępnych aut

}
