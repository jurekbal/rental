package javapoz24.team3.rental.domain.car;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarDomainServiceImpl implements CarDomainService {

    private CarRepository carRepository;

    public CarDomainServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public Optional<Car> getCarById(Long id) {
        return carRepository.findById(id);
    }

    @Override
    public List<Car> getCarByRegNumber(String regNumber) {
        return carRepository.findCarByRegNumber(regNumber);
    }

    @Override
    public Car saveCar(Car car) {
        return null;
    }
}
