package javapoz24.team3.rental.domain.rental;

import javapoz24.team3.rental.domain.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Rental extends BaseEntity {

    private String name;
    private String webDomain;
    private String owner;
    private String logoURL;

    // TODO FetchType.LAZY
    @OneToMany(mappedBy = "rental", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude  // bez tego wysypuje się z "Set" (ale "List" działa!?)
    private Set<CompanyBranch> companyBranches;

}
