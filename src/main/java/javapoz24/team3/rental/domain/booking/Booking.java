package javapoz24.team3.rental.domain.booking;

import javapoz24.team3.rental.domain.base.BaseEntity;
import javapoz24.team3.rental.domain.car.Car;
import javapoz24.team3.rental.domain.customer.Customer;
import javapoz24.team3.rental.domain.emploee.Employee;
import javapoz24.team3.rental.domain.rental.CompanyBranch;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@EntityListeners(AuditingEntityListener.class)
public class Booking extends BaseEntity {

    @CreatedDate
    private LocalDateTime createdTimestamp;
    @ManyToOne
    private Customer customer;
    @ManyToOne
    private Employee employee;
    @ManyToOne
    private Car car;
    private LocalDate rentalDay;
    private LocalDate returnDay;
    @ManyToOne
    private CompanyBranch rentBranch;
    @ManyToOne
    private CompanyBranch returnBranch;

//    @Formula(value = "(DATEDIFF(day, bookingFrom, bookingTo)) * car.pricing")
//    private BigDecimal totalCost;

    @Builder
    public Booking(Long id, Customer customer, Employee employee, Car car,
                   LocalDate rentalDay, LocalDate returnDay,
                   CompanyBranch rentBranch, CompanyBranch returnBranch
                   ) {
        this.setId(id);
        this.customer = customer;
        this.employee = employee;
        this.car = car;
        this.rentalDay = rentalDay;
        this.returnDay = returnDay;
        this.rentBranch = rentBranch;
        this.returnBranch = returnBranch;
    }
}
