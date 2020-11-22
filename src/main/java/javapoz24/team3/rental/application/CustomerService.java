package javapoz24.team3.rental.application;

import javapoz24.team3.rental.domain.customer.Customer;
import javapoz24.team3.rental.domain.customer.CustomerDTO;
import javapoz24.team3.rental.domain.customer.CustomerDomainService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private final CustomerDomainService customerDomainService;

    public CustomerService(CustomerDomainService customerDomainService) {
        this.customerDomainService = customerDomainService;
    }

    public List<CustomerDTO> getAll() {
        return customerDomainService.getAll().stream()
                .map(CustomerDTO::fromCustomer)
                .collect(Collectors.toList());
    }

    public Optional<Customer> getById(Long id) {
        return customerDomainService.getById(id);
    }

    public Customer addOrUpdate(CustomerDTO customerDTO) {
        Customer customer = new Customer(
                customerDTO.getId(),
                customerDTO.getFirstName(),
                customerDTO.getLastName(),
                customerDTO.getEmail(),
                customerDTO.getAddress()
        );
        return customerDomainService.save(customer);
    }
}
