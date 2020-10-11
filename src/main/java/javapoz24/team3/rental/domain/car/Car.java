package javapoz24.team3.rental.domain.car;

import javapoz24.team3.rental.domain.base.BaseEntity;
import javapoz24.team3.rental.domain.rental.CompanyBranch;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Car extends BaseEntity {

    private String brand; //marka
    private String model;
    private String regNumber;
    @Enumerated(value = EnumType.STRING)
    private CarBodyStyle bodyType;
    private Integer productionYear;
    private String paintColor;
    private Long mileage; // przebieg
    @Enumerated(value = EnumType.STRING)
    private CarStatus status;
    private BigDecimal pricing;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private CompanyBranch companyBranch;

    @Builder
    public Car(Long id, String brand, String model, String regNumber,
               CarBodyStyle bodyType, Integer productionYear,
               String paintColor, Long mileage, CarStatus status,
               BigDecimal pricing, CompanyBranch companyBranch) {
        setId(id);
        this.brand = brand;
        this.model = model;
        this.regNumber = regNumber;
        this.bodyType = bodyType;
        this.productionYear = productionYear;
        this.paintColor = paintColor;
        this.mileage = mileage;
        this.status = status;
        this.pricing = pricing;
        this.companyBranch = companyBranch;
    }
}
