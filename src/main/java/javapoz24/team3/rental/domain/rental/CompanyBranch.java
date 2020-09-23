package javapoz24.team3.rental.domain.rental;

import javapoz24.team3.rental.domain.base.BaseEntity;
import lombok.*;

import javax.persistence.*;
import javax.transaction.Transactional;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class CompanyBranch extends BaseEntity {

    @Embedded
    private Address address;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private Rental rental;

    // TODO Lista pracowników, lista dostępnych aut

}
