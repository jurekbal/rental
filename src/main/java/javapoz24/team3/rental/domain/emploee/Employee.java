package javapoz24.team3.rental.domain.emploee;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javapoz24.team3.rental.domain.base.BasePerson;
import javapoz24.team3.rental.domain.rental.CompanyBranch;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties("companyBranch")
public class Employee extends BasePerson {

    @Enumerated(value = EnumType.STRING)
    private Positions position;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private CompanyBranch companyBranch;

    @Builder
    public Employee(Long id, String firstName, String lastName, Positions position, CompanyBranch companyBranch) {
        super(firstName, lastName);
        setId(id);
        this.position = position;
        this.companyBranch = companyBranch;
    }
}
