package javapoz24.team3.rental.domain.car;

import javapoz24.team3.rental.domain.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Car extends BaseEntity {

    private String brand; //marka
    private String model;
    @Enumerated(value = EnumType.STRING)
    private CarBodyStyle bodyType;
    private Integer productionYear;
    private String paintColor;
    private Long mileage; // przebieg
    @Enumerated(value = EnumType.STRING)
    private CarStatus status;
    private BigDecimal pricing;
}
