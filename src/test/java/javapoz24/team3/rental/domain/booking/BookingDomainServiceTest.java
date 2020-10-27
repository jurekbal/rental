package javapoz24.team3.rental.domain.booking;

import javapoz24.team3.rental.domain.car.Car;
import javapoz24.team3.rental.domain.car.CarBodyStyle;
import javapoz24.team3.rental.domain.car.CarRepository;
import javapoz24.team3.rental.domain.car.CarStatus;
import javapoz24.team3.rental.domain.customer.Customer;
import javapoz24.team3.rental.domain.customer.CustomerRepository;
import javapoz24.team3.rental.domain.emploee.Employee;
import javapoz24.team3.rental.domain.emploee.EmployeeRepository;
import javapoz24.team3.rental.domain.emploee.Positions;
import javapoz24.team3.rental.domain.rental.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

@DataJpaTest
class BookingDomainServiceTest {

    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private RentalRepository rentalRepository;
    @Autowired
    private BranchRepository branchRepository;
    @Autowired
    private CarRepository carRepository;

    @PersistenceContext
    private EntityManager entityManager;

    private void flushAndClear() {
        entityManager.flush();
        entityManager.clear();
    }

    @Test
    void should_save_and_get_object_and_calculate_cost_correctly(){
        //given
        BigDecimal costPerDay = new BigDecimal("120.23"); //used in Car
        LocalDate rentDate = LocalDate.of(2020, 11, 6); //used in Booking
        LocalDate returnDate = LocalDate.of(2020, 11, 9); //used in Booking
        long expectedRentDays = ChronoUnit.DAYS.between(rentDate,returnDate);
        BigDecimal expectedTotalCost = costPerDay.multiply(BigDecimal.valueOf(expectedRentDays));

        // dane testowe to praktycznie kopia funkcji @PostConstruct z MockData ale tutaj używam
        // implementacji interfejsów JpaRepository a nie jak w MockData serwisów
        // ** rozważyć przeniesienie ich do funkcji @BeforeEach czy @BeforeAll
        Address addressOfBranch1 = new Address("Dąbrowskiego 345", "Poznań", "61-234");
        Address customerAddress1 = new Address("Malinowa 1", "Poznań", "61-234");
        Address addressOfCompany = new Address("Złota 44", "Warszawa", "00-020");

        Rental rental = new Rental(
                "Car Rental Company",
                "http://carrental.pl",
                addressOfCompany,
                "Stanisław Nowak",
                "http://carrental.pl/logo.gif",
                new HashSet<>()
        );
        rentalRepository.save(rental);

        List<Rental> rentals = rentalRepository.findAll();
        CompanyBranch branch1 = new CompanyBranch(addressOfBranch1, rentals.get(0), new HashSet<>(), new HashSet<>(),
                false, new ArrayList<>(), new ArrayList<>());
        branchRepository.save(branch1);

        Employee e1 = Employee.builder()
                .firstName("Marian")
                .lastName("Modalski")
                .position(Positions.REGULAR)
                .companyBranch(branch1)
                .build();
        employeeRepository.save(e1);

        Customer cust1 = Customer.builder()
                .id(null)
                .firstName("Grzegorz")
                .lastName("Brzęczyszczykiewicz")
                .email("gb@wp.pl")
                .address(customerAddress1)
                .build();
        customerRepository.save(cust1);

        Car car1 = Car.builder()
                .id(null)
                .brand("Ford")
                .model("Focus")
                .regNumber("PO 12345")
                .bodyType(CarBodyStyle.HATCHBACK)
                .productionYear(2015)
                .paintColor("Oceanic blue")
                .mileage(125_250L)
                .status(CarStatus.AVAILABLE)
                .pricing(costPerDay)
                .companyBranch(branch1)
                .build();
        carRepository.save(car1);

        List<CompanyBranch> companyBranches = branchRepository.findAll();
        List<Customer> customers = customerRepository.findAll();
        List<Employee> employees = employeeRepository.findAll();
        List<Car> cars = carRepository.findAll();

        Booking booking1 = Booking.builder()
                .customer(customers.get(0))
                .employee(employees.get(0))
                .car(cars.get(0))
                .rentalDay(rentDate)
                .returnDay(returnDate)
                .rentBranch(companyBranches.get(0))
                .returnBranch(companyBranches.get(0))
                .build();
        bookingRepository.save(booking1);

        //when
        Booking booking;
        flushAndClear();

        List<Booking> bookings = bookingRepository.findAll();

        if (bookings.size() == 1) {
            booking = bookings.get(0);
        } else {
            fail("Bookings list size not equals to 1; Actual:" + bookings.size());
            return;
        }

        //then
        assertThat(booking.getTotalCost()).isEqualTo(expectedTotalCost);

        // *** test for same rental day as return day
        // (cost should be calculated for one day not zero)
        // when 2
        booking.setReturnDay(rentDate);
        bookingRepository.save(booking);
        flushAndClear();
        Booking bookingZeroDays = bookingRepository.getOne(booking.getId());
        long zeroRentDurationDays = ChronoUnit.DAYS.between(
                bookingZeroDays.getRentalDay(),bookingZeroDays.getReturnDay());

        // then 2
        assertThat(zeroRentDurationDays).isZero();
        assertThat(bookingZeroDays.getTotalCost())
                .isEqualTo(bookingZeroDays.getCar().getPricing());
    }
}
