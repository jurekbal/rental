package javapoz24.team3.rental.domain.customer;

import javapoz24.team3.rental.domain.base.BasePerson;
import javapoz24.team3.rental.domain.rental.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Embedded;
import javax.persistence.Entity;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends BasePerson {

    private String email;
    @Embedded
    private Address address;
}
