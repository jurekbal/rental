package javapoz24.team3.rental.application.config;

import javapoz24.team3.rental.application.BookingService;
import javapoz24.team3.rental.application.CarService;
import javapoz24.team3.rental.application.CustomerService;
import javapoz24.team3.rental.application.RentalService;
import javapoz24.team3.rental.domain.booking.Booking;
import javapoz24.team3.rental.domain.booking.BookingDTO;
import javapoz24.team3.rental.domain.car.*;
import javapoz24.team3.rental.domain.customer.Customer;
import javapoz24.team3.rental.domain.customer.CustomerDTO;
import javapoz24.team3.rental.domain.customer.CustomerDomainService;
import javapoz24.team3.rental.domain.emploee.Employee;
import javapoz24.team3.rental.domain.emploee.EmployeeDomainService;
import javapoz24.team3.rental.domain.emploee.Positions;
import javapoz24.team3.rental.domain.rental.Address;
import javapoz24.team3.rental.domain.rental.CompanyBranch;
import javapoz24.team3.rental.domain.rental.Rental;
import javapoz24.team3.rental.domain.rental.RentalDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* Provides test data */
@Service
public class MockData {

    @Autowired
    private RentalService rentalService;
    @Autowired
    private RentalDomainService rentalDomainService;
    @Autowired
    private CarService carService;
    @Autowired
    private CarDomainService carDomainService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerDomainService customerDomainService;
    @Autowired
    private BookingService bookingService;
    @Autowired
    private EmployeeDomainService employeeDomainService;

    @PostConstruct
    public void GenerateMockData() {

        Address addressOfBranch1 = new Address("Dąbrowskiego 345", "Poznań", "61-234");
        Address addressOfBranch2 = new Address("Trzebnicka 12", "Wrocław", "50-015");
        Address addressOfBranch3 = new Address("Domaniewska 44", "Warszawa", "00-122");
        Address customerAddress1 = new Address("Malinowa 1", "Poznań", "61-234");
        Address customerAddress2 = new Address("Selerowa 12", "Wrocław", "50-015");
        Address customerAddress3 = new Address("Brzozowa 78", "Warszawa", "00-122");

        Set<CompanyBranch> branches = new HashSet<>();

        Address addressOfCompany = new Address("Złota 44", "Warszawa", "00-020");
        Rental rental = new Rental(
                "Car Rental Company",
                "http://carrental.pl",
                addressOfCompany,
                "Stanisław Nowak",
                "http://carrental.pl/logo.gif",
                branches
        );

        CompanyBranch branch1 = new CompanyBranch(addressOfBranch1, rental, false);
        CompanyBranch branch2 = new CompanyBranch(addressOfBranch2, rental, false);
        CompanyBranch branch3 = new CompanyBranch(addressOfBranch3, rental, true);

        Employee e1 = Employee.builder()
                .firstName("Marian")
                .lastName("Modalski")
                .position(Positions.REGULAR)
                .companyBranch(branch1)
                .build();
        Employee e2 = Employee.builder()
                .firstName("Adam")
                .lastName("Mickiewicz")
                .position(Positions.REGULAR)
                .companyBranch(branch2)
                .build();
        Employee e3 = Employee.builder()
                .firstName("Roman")
                .lastName("Baraniecki")
                .position(Positions.REGULAR)
                .companyBranch(branch3)
                .build();
        Employee e4 = Employee.builder()
                .firstName("Witold")
                .lastName("Aramowski")
                .position(Positions.MANAGER)
                .companyBranch(branch3)
                .build();

        branch1.getEmployees().add(e1);
        branch2.getEmployees().add(e2);
        branch3.getEmployees().add(e3);
        branch3.getEmployees().add(e4);

        branches.add(branch1);
        branches.add(branch2);
//        branches.add(branch3);

        rentalService.saveRentalInfoData(rental);
        RentalId.getInstance().setId(rental.getId());
        System.out.println("RentalId Id:" + RentalId.getInstance().getId());

        rentalService.saveBranch(branch3);

//        CARs data
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
                .pricing(BigDecimal.valueOf(120L))
                .companyBranch(branch1)
                .build();

        Car car2 = Car.builder()
                .id(null)
                .brand("Kia")
                .model("Rio")
                .regNumber("PO 984LT")
                .bodyType(CarBodyStyle.HATCHBACK)
                .productionYear(2018)
                .paintColor("Racing Red")
                .mileage(86_750L)
                .status(CarStatus.AVAILABLE)
                .pricing(BigDecimal.valueOf(105L))
                .companyBranch(branch1)
                .build();

        Car car3 = Car.builder()
                .id(null)
                .brand("Volkswagen")
                .model("Passat")
                .regNumber("PO 546KR")
                .bodyType(CarBodyStyle.KOMBI)
                .productionYear(2016)
                .paintColor("Dark Oak")
                .mileage(170_128L)
                .status(CarStatus.AVAILABLE)
                .pricing(BigDecimal.valueOf(190L))
                .companyBranch(branch2)
                .build();

        carService.addOrUpdate(CarDTO.fromCar(car1));
        carService.addOrUpdate(CarDTO.fromCar(car2));
        carService.addOrUpdate(CarDTO.fromCar(car3));

        Customer cust1 = Customer.builder()
                .id(null)
                .firstName("Grzegorz")
                .lastName("Brzęczyszczykiewicz")
                .email("gb@wp.pl")
                .address(customerAddress1)
                .build();

        Customer cust2 = Customer.builder()
                .id(null)
                .firstName("Rafał")
                .lastName("Anielewicz")
                .email("ra@op.pl")
                .address(customerAddress2)
                .build();

        Customer cust3 = Customer.builder()
                .id(null)
                .firstName("Paweł")
                .lastName("Jędzejewski")
                .email("pj@gmail.com")
                .address(customerAddress3)
                .build();

        customerService.addOrUpdate(CustomerDTO.fromCustomer(cust1));
        customerService.addOrUpdate(CustomerDTO.fromCustomer(cust2));
        customerService.addOrUpdate(CustomerDTO.fromCustomer(cust3));

        /*
        Booking
        */
        List<Customer> customers = customerDomainService.getAll();
        List<Employee> employees = employeeDomainService.getAllEmployees();
        List<Car> cars = carDomainService.getAllCars();
        List<CompanyBranch> companyBranches = rentalDomainService.getAllBranches();

        Booking booking1 = Booking.builder()
                .customer(customers.get(0))
                .employee(employees.get(0))
                .car(cars.get(0))
                .rentalDay(LocalDate.of(2020, 11, 6))
                .returnDay(LocalDate.of(2020, 11, 9))
                .rentBranch(companyBranches.get(0))
                .returnBranch(companyBranches.get(1))
                .build();

        bookingService.addOrUpdate(BookingDTO.fromBooking(booking1));

//        System.out.println("Branches List From Mocked Object:");
//        System.out.println(rental.getCompanyBranches());
//        System.out.println("Rental Info From Mocked Object: (saved to DB)");
//        System.out.println(rental);

        //Poniższy kod wywala apkę przy FetchType.LAZY - @Transactional nic nie zmienia
        // NAPRAWIONE - Lombok Data robi problemy (dokładnie lombokowy ToString), ale teraz nic nie wyświetli...
//        System.out.println("*** Rental Info From DB:");
//        Rental rentalFromDB = rentalDomainService.getRentalInfo();
//        System.out.println(rentalFromDB);
    }

}
