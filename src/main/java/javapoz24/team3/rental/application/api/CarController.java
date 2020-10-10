package javapoz24.team3.rental.application.api;

import javapoz24.team3.rental.application.CarService;
import javapoz24.team3.rental.domain.car.Car;
import javapoz24.team3.rental.domain.car.CarDTO;
import javapoz24.team3.rental.domain.car.CarDomainService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public List<CarDTO> getAll() {
        return carService.getAll();
    }

    @GetMapping("/{id}")
    public CarDTO getById(@PathVariable(name = "id") Long id) {
        Optional<Car> optCar = carService.getById(id);
        return optCar.map(CarDTO::fromCar).orElse(null);
    }

    @GetMapping("/byregnumber/{regnum}")
    public List<CarDTO> getByRegNumber(@PathVariable(name = "regnum") String regNum) {
        return carService.getByRegNumber(regNum);
    }

    @PutMapping
    public void adOrUpdate(CarDTO carDTO) {
        carService.addOrUpdate(carDTO);
    }
}
