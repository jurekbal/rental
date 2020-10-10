package javapoz24.team3.rental.domain.car;

import lombok.Value;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;

@Value
public class CarDTO {
    
    Long id;
    
    //TODO walidacja
     String brand; //marka
     String model;
     String regNumber;
    @Enumerated(value = EnumType.STRING)
     CarBodyStyle bodyType;
     Integer productionYear;
     String paintColor;
     Long mileage; // przebieg
    @Enumerated(value = EnumType.STRING)
     CarStatus status;
     BigDecimal pricing;

     Long branchId;

     public static CarDTO fromCar(Car car){
         return new CarDTO(
                 car.getId(),
                 car.getBrand(),
                 car.getModel(),
                 car.getRegNumber(),
                 car.getBodyType(),
                 car.getProductionYear(),
                 car.getPaintColor(),
                 car.getMileage(),
                 car.getStatus(),
                 car.getPricing(),
                 car.getCompanyBranch().getId()
         );
     }
}
