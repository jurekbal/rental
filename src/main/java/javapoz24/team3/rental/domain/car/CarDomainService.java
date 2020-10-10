package javapoz24.team3.rental.domain.car;

import java.util.List;
import java.util.Optional;

public interface CarDomainService {

    List<Car> getAllCars();
    Optional<Car> getCarById(Long id);
    List<Car> getCarByRegNumber(String regNumber);
    Car saveCar(Car car);
}
