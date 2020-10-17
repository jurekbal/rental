package javapoz24.team3.rental.domain.customer;

import javapoz24.team3.rental.domain.base.BasePerson;
import javapoz24.team3.rental.domain.booking.Booking;
import javapoz24.team3.rental.domain.rental.Address;
import lombok.*;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

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

    @OneToMany(mappedBy = "customer")
    private List<Booking> bookings;

    @Builder
    public Customer(Long id, String firstName, String lastName, String email, Address address) {
        super(firstName, lastName);
        setId(id);
        this.email = email;
        this.address = address;
    }
}
