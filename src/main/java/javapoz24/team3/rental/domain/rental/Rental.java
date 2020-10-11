package javapoz24.team3.rental.domain.rental;

import javapoz24.team3.rental.domain.base.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Rental extends BaseEntity {

    private String name;
    private String webDomain;
    @Embedded
    private Address address;
    private String owner;
    private String logoURL;

    @OneToMany(mappedBy = "rental", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    private Set<CompanyBranch> companyBranches;

}
