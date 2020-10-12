package javapoz24.team3.rental.domain.car;

import javapoz24.team3.rental.domain.rental.CompanyBranch;

import java.util.List;
import java.util.Optional;

public interface CarDomainService {

    List<Car> getAllCars();
    Optional<Car> getCarById(Long id);
    List<Car> getCarByRegNumber(String regNumber);
    Car saveCar(Car car);
    List<Car> getCarsInBranch(CompanyBranch branch);
}
