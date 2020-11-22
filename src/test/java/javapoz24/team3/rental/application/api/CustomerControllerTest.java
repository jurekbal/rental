package javapoz24.team3.rental.application.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import javapoz24.team3.rental.application.CustomerService;
import javapoz24.team3.rental.domain.customer.Customer;
import javapoz24.team3.rental.domain.customer.CustomerDTO;
import javapoz24.team3.rental.domain.rental.Address;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
/*
Ten test nie odpala całego kontekstu
podajemy tylko controller i mock serwisu
 */
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = CustomerController.class)
public class CustomerControllerTest {

    @MockBean
    CustomerService customerService;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void getAll() throws Exception {
        Address address = new Address("Junacka 7", "Bąblewice", "25-780");
        Customer customer1 = Customer.builder()
                .id(1L)
                .firstName("Mirosław")
                .lastName("Nowak")
                .address(address)
                .email("mail@server.pl")
                .build();
        Customer customer2 = Customer.builder()
                .id(2L)
                .firstName("Leszek")
                .lastName("Adamski")
                .address(address)
                .email("leszek@server.pl")
                .build();

        when(customerService.getAll())
                .thenReturn(Arrays.asList(
                        CustomerDTO.fromCustomer(customer1),
                        CustomerDTO.fromCustomer(customer2)
                ));

        mockMvc.perform(get("/customers"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$[0].firstName", is("Mirosław")))
                .andExpect(jsonPath("$[1].firstName", is("Leszek")));
    }

    @Test
    public void getById() throws Exception {
        Address address = new Address("Junacka 7", "Bąblewice", "25-780");
        Customer customer = Customer.builder()
                .id(1L)
                .firstName("Mirosław")
                .lastName("Nowak")
                .address(address)
                .email("mail@server.pl")
                .build();

        when(customerService.getById(1L)).thenReturn(Optional.of(customer));

        mockMvc.perform(get("/customers/1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.firstName", is("Mirosław")));
    }

    @Test
    public void addOrUpdate() throws Exception{
        Address address = new Address("Junacka 7", "Bąblewice", "25-780");
        Customer customer1 = Customer.builder()
                .id(1L)
                .firstName("Mirosław")
                .lastName("Nowak")
                .address(address)
                .email("mail@server.pl")
                .build();
        CustomerDTO customerDTO = CustomerDTO.fromCustomer(customer1);

        when(customerService.addOrUpdate(any())).thenReturn(customer1);

        ObjectMapper om = new ObjectMapper();

        mockMvc.perform(put("/customers")
                .contentType(MediaType.APPLICATION_JSON)
                .content(om.writeValueAsString(customerDTO)))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.firstName", is("Mirosław")));
    }
}
