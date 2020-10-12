package javapoz24.team3.rental.application.api;

import javapoz24.team3.rental.application.CustomerService;
import javapoz24.team3.rental.domain.customer.CustomerDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<CustomerDTO> getAll(){
        return customerService.getAll();
    }

    @GetMapping("/{id}")
    public CustomerDTO getById(@PathVariable(name = "id") Long id) {
        return customerService.getById(id)
                .map(CustomerDTO::fromCustomer)
                .orElse(null);
    }

    @PutMapping
    public void addOrUpdate(@RequestBody CustomerDTO customerDTO) {
        customerService.addOrUpdate(customerDTO);
    }
}
