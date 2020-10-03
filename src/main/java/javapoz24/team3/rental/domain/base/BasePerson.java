package javapoz24.team3.rental.domain.base;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.MappedSuperclass;

@Data
@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
public class BasePerson extends BaseEntity{
    private String firstName;
    private String lastName;
}


