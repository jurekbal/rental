package javapoz24.team3.rental.application;

import javapoz24.team3.rental.domain.booking.Booking;
import javapoz24.team3.rental.domain.car.Car;
import javapoz24.team3.rental.domain.customer.Customer;
import javapoz24.team3.rental.domain.emploee.Employee;
import javapoz24.team3.rental.domain.rentact.RentAct;
import javapoz24.team3.rental.domain.rentact.RentActDTO;
import javapoz24.team3.rental.domain.rentact.RentActDomainService;
import javapoz24.team3.rental.domain.rental.CompanyBranch;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RentingService {

    private final RentActDomainService rentActDomainService;
    private final BookingService bookingService;
    private final CustomerService customerService;
    private final EmployeeService employeeService;
    private final CarService carService;
    private final RentalService rentalService;

    public RentingService(RentActDomainService rentActDomainService,
                          @Lazy BookingService bookingService,
                          CustomerService customerService, EmployeeService employeeService,
                          CarService carService, RentalService rentalService) {
        this.rentActDomainService = rentActDomainService;
        this.bookingService = bookingService;
        this.customerService = customerService;
        this.employeeService = employeeService;
        this.carService = carService;
        this.rentalService = rentalService;
    }

    public Optional<RentAct> getRentActById(Long id) {
        return rentActDomainService.getRentActById(id);
    }

    public List<RentActDTO> getAllRents() {
        return rentActDomainService.getAllRents().stream()
                .map(RentActDTO::fromRentAct)
                .collect(Collectors.toList());
    }

    public ResponseEntity<RentActDTO> addOrUpdate(RentActDTO rentActDTO) {
        Optional<Customer> optCustomer = customerService.getById(rentActDTO.getCustomerId());
        Optional<Employee> optRentingEmployee = employeeService.getEmployeeById(rentActDTO.getRentingEmployeeId());
        Optional<Employee> optClosingEmployee = Optional.empty();
        if (rentActDTO.getClosingEmployeeId() != null) {
            optClosingEmployee = employeeService.getEmployeeById(rentActDTO.getClosingEmployeeId());
        }
        Optional<Car> optCar = carService.getById(rentActDTO.getCarId());
        Optional<CompanyBranch> optRentBranch = rentalService.getBranchById(rentActDTO.getRentBranchId());
        Optional<CompanyBranch> optReturnBranch = rentalService.getBranchById(rentActDTO.getReturnBranchId());
        Optional<Booking> optBookingId = Optional.empty();
        if (rentActDTO.getReferenceBookingId() != null){
            optBookingId = bookingService.getById(rentActDTO.getReferenceBookingId());
        }

        if (optCustomer.isPresent() && optRentingEmployee.isPresent() && optCar.isPresent()
                && optRentBranch.isPresent() && optReturnBranch.isPresent()) {
            RentAct rentAct = new RentAct(
                    rentActDTO.getId(),
                    optBookingId.orElse(null),
                    optCustomer.get(),
                    optRentingEmployee.get(),
                    optClosingEmployee.orElse(null),
                    optCar.get(),
                    rentActDTO.getRentDay(),
                    rentActDTO.getReturnDay(),
                    optRentBranch.get(),
                    optReturnBranch.get(), //Actual or Predicted return office have to be stated (not null)
                    rentActDTO.getTotalCost(),
                    rentActDTO.isOpen(),
                    rentActDTO.getNote()
            );
            RentAct savedRentAct = rentActDomainService.addOrUpdate(rentAct);
            return ResponseEntity
                    .accepted()
                    .body(RentActDTO.fromRentAct(savedRentAct));
        }
        return ResponseEntity
                .unprocessableEntity().build();
    }
}
