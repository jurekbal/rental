package javapoz24.team3.rental.domain.rental;

import javapoz24.team3.rental.domain.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.transaction.Transactional;
import java.net.URI;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Rental extends BaseEntity {

    private String name;
    private String webDomain;
    private String owner;
    private String logoURL;
    @OneToMany(mappedBy = "rental", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Set<CompanyBranch> companyBranches;
}
