package javapoz24.team3.rental.application;

import javapoz24.team3.rental.domain.booking.Booking;
import javapoz24.team3.rental.domain.booking.BookingDTO;
import javapoz24.team3.rental.domain.booking.BookingDomainService;
import javapoz24.team3.rental.domain.car.Car;
import javapoz24.team3.rental.domain.customer.Customer;
import javapoz24.team3.rental.domain.emploee.Employee;
import javapoz24.team3.rental.domain.rental.CompanyBranch;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookingService {

    private final BookingDomainService bookingDomainService;
    private final CustomerService customerService;
    private final EmployeeService employeeService;
    private final CarService carService;
    private final RentalService rentalService;

    public BookingService(BookingDomainService bookingDomainService,
                          CustomerService customerService,
                          EmployeeService employeeService,
                          CarService carService,
                          RentalService rentalService) {
        this.bookingDomainService = bookingDomainService;
        this.customerService = customerService;
        this.employeeService = employeeService;
        this.carService = carService;
        this.rentalService = rentalService;
    }

    public List<BookingDTO> getAll() {
        return bookingDomainService.findAll().stream()
                .map(BookingDTO::fromBooking)
                .collect(Collectors.toList());
    }

    public Optional<Booking> getById(Long id) {
        return bookingDomainService.findById(id);
    }

    public ResponseEntity<BookingDTO> addOrUpdate(BookingDTO bookingDTO) {
        Optional<Customer> optCustomer = customerService.getById(bookingDTO.getCustomerId());
        Optional<Employee> optEmployee = employeeService.getEmployeeById(bookingDTO.getEmployeeId());
        Optional<Car> optCar = carService.getById(bookingDTO.getCarId());
        Optional<CompanyBranch> optRentBranch = rentalService.getBranchById(bookingDTO.getRentBranchId());
        Optional<CompanyBranch> optReturnBranch = rentalService.getBranchById(bookingDTO.getReturnBranchId());

        if (optCustomer.isPresent() && optEmployee.isPresent() && optCar.isPresent()
                && optRentBranch.isPresent() && optReturnBranch.isPresent()) {
            Booking booking = new Booking(
                    bookingDTO.getId(),
                    optCustomer.get(),
                    optEmployee.get(),
                    optCar.get(),
                    bookingDTO.getRentalDay(),
                    bookingDTO.getReturnDay(),
                    optRentBranch.get(),
                    optReturnBranch.get()
            );
            Booking savedBooking = bookingDomainService.addOrUpdate(booking);
            return ResponseEntity
                    .accepted()
                    .body(BookingDTO.fromBooking(savedBooking));
        }
        //TODO załączyć komunikat błędu z wskazaniem problemu (ew. odpowiedni wyjątek)
        return ResponseEntity
                .unprocessableEntity().build();

    }
}
