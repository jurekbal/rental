package javapoz24.team3.rental.domain.base;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.MappedSuperclass;

@Data
@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
public class BasePerson extends BaseEntity{
    private String firstName;
    private String lastName;
}
