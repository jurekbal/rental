package javapoz24.team3.rental.domain.rentact;

import javapoz24.team3.rental.domain.base.BaseEntity;
import javapoz24.team3.rental.domain.booking.Booking;
import javapoz24.team3.rental.domain.car.Car;
import javapoz24.team3.rental.domain.customer.Customer;
import javapoz24.team3.rental.domain.emploee.Employee;
import javapoz24.team3.rental.domain.rental.CompanyBranch;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@EntityListeners(AuditingEntityListener.class)
public class RentAct extends BaseEntity {

    @CreatedDate
    private LocalDateTime createdTimestamp;
    @OneToOne(fetch = FetchType.LAZY)
    private Booking referenceBooking;
    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;
    @ManyToOne(fetch = FetchType.LAZY)
    private Employee rentingEmployee;
    @ManyToOne(fetch = FetchType.LAZY)
    private Employee closingEmployee;
    @ManyToOne
    private Car car;
    @ManyToOne
    private CompanyBranch rentBranch;
    @ManyToOne
    private CompanyBranch returnBranch;
    private LocalDate rentDay;
    private LocalDate returnDay;

    /* not calculated like in booking, persisted,
    may differ from (days * cost/day) for some reasons (discounts, extra services etc.)
     */
    private BigDecimal totalCost;

    private boolean open;
    private String note;

    @Builder
    public RentAct(Long id, Booking referenceBooking, Customer customer,
                   Employee rentingEmployee, Employee closingEmployee, Car car,
                   LocalDate rentDay, LocalDate returnDay,
                   CompanyBranch rentBranch, CompanyBranch returnBranch,
                   BigDecimal totalCost, boolean open, String note) {
        this.setId(id);
        this.referenceBooking = referenceBooking;
        this.customer = customer;
        this.rentingEmployee = rentingEmployee;
        this.closingEmployee = closingEmployee;
        this.car = car;
        this.rentDay = rentDay;
        this.returnDay = returnDay;
        this.rentBranch = rentBranch;
        this.returnBranch = returnBranch;
        this.totalCost = totalCost;
        this.open = open;
        this.note = note;
    }
}
