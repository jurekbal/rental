package javapoz24.team3.rental.application;

import javapoz24.team3.rental.domain.car.Car;
import javapoz24.team3.rental.domain.car.CarDTO;
import javapoz24.team3.rental.domain.car.CarDomainService;
import javapoz24.team3.rental.domain.rental.CompanyBranch;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarService {

    private final CarDomainService carDomainService;
    private final RentalService rentalService;

    public CarService(CarDomainService carDomainService, RentalService rentalService) {
        this.carDomainService = carDomainService;
        this.rentalService = rentalService;
    }

   public List<CarDTO> getAll() {
        return carDomainService.getAllCars().stream()
                .map(CarDTO::fromCar)
                .collect(Collectors.toList());
   }

   public Optional<Car> getById(Long id) {
        return carDomainService.getCarById(id);
   }

   public List<CarDTO> getByRegNumber(String regNumber) {
        return carDomainService.getCarByRegNumber(regNumber).stream()
                .map(CarDTO::fromCar)
                .collect(Collectors.toList());
   }

   private void save(Car car) {
        carDomainService.saveCar(car);
   }

   public void addOrUpdate(CarDTO carDTO) {
       Optional<CompanyBranch> optBranch = rentalService.getBranchById(carDTO.getBranchId());
       if (optBranch.isPresent()) {
           Car car = new Car(
                   carDTO.getId(),
                   carDTO.getBrand(),
                   carDTO.getModel(),
                   carDTO.getRegNumber(),
                   carDTO.getBodyType(),
                   carDTO.getProductionYear(),
                   carDTO.getPaintColor(),
                   carDTO.getMileage(),
                   carDTO.getStatus(),
                   carDTO.getPricing(),
                   optBranch.get()
           );
           save(car);
       }
       // TODO zwrotka przy błędzie
   }
}
