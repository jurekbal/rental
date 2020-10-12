package javapoz24.team3.rental.domain.customer;

import javapoz24.team3.rental.domain.base.BasePerson;
import javapoz24.team3.rental.domain.rental.Address;
import lombok.*;

import javax.persistence.Embedded;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends BasePerson {

    private String email;
    @Embedded
    private Address address;

    @Builder
    public Customer(Long id, String firstName, String lastName, String email, Address address) {
        super(firstName, lastName);
        setId(id);
        this.email = email;
        this.address = address;
    }
}
