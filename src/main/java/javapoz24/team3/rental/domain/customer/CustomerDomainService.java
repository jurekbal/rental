package javapoz24.team3.rental.domain.customer;

import java.util.List;
import java.util.Optional;

public interface CustomerDomainService {
    List<Customer> getAll();
    Optional<Customer> getById(Long id);
    Customer save(Customer customer);
}
