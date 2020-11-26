package javapoz24.team3.rental.domain.customer;

import javapoz24.team3.rental.domain.rental.Address;
import lombok.Value;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Value
public class CustomerDTO {

    Long id;
    @NotNull
    @Size(min = 2, max = 50)
    String firstName;
    @NotNull
    @Size(min = 2, max = 50)
    String lastName;
    String email;
    Address address;

    public static CustomerDTO fromCustomer(Customer customer) {
        return new CustomerDTO(
                customer.getId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail(),
                customer.getAddress()
        );
    }
}

