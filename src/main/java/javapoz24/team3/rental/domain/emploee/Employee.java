package javapoz24.team3.rental.domain.emploee;

import javapoz24.team3.rental.domain.base.BasePerson;
import javapoz24.team3.rental.domain.rental.CompanyBranch;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Employee extends BasePerson {

    @Enumerated(value = EnumType.STRING)
    private Positions position;

    @ManyToOne(fetch = FetchType.LAZY)
    private CompanyBranch companyBranch;
}
