package javapoz24.team3.rental.domain.customer;

import javapoz24.team3.rental.domain.rental.Address;
import lombok.Value;

@Value
public class CustomerDTO {
    //TODO walidacja
    Long id;
    String firstName;
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

