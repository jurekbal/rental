package javapoz24.team3.rental.domain.base;

import lombok.Data;

import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public class BasePerson extends BaseEntity{
    private String firstName;
    private String lastName;
}
