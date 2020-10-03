package javapoz24.team3.rental.domain.rental;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javapoz24.team3.rental.domain.base.BaseEntity;
import javapoz24.team3.rental.domain.emploee.Employee;
import lombok.*;

import javax.persistence.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class CompanyBranch extends BaseEntity {

    @Embedded
    private Address address;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private Rental rental;

    @OneToMany(mappedBy = "companyBranch", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    private Set<Employee> employees;


    // TODO lista dostępnych aut

    public static CompanyBranch fromDTO(CompanyBranchDTO companyBranchDTO, Rental rental) {

        return new CompanyBranch(
                companyBranchDTO.getAddress(),
                rental,
                Collections.EMPTY_SET  // to czy new HashSet<>()? - czy wywali przy add()?
        );
    }

}
