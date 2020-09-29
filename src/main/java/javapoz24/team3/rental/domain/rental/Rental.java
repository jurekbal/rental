package javapoz24.team3.rental.domain.rental;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Rental extends BaseEntity {

    private String name;
    private String webDomain;
    private String owner;
    private String logoURL;

    @OneToMany(mappedBy = "rental", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    // bez tego wysypuje się z "Set" (ale "List" działa!?) / można zaimpl. też odpowiedni hashCode w CompanyBrnach
    private Set<CompanyBranch> companyBranches;

}
