package javapoz24.team3.rental.domain.rental;

import javapoz24.team3.rental.domain.base.BaseEntity;
import javapoz24.team3.rental.domain.booking.Booking;
import javapoz24.team3.rental.domain.car.Car;
import javapoz24.team3.rental.domain.emploee.Employee;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class CompanyBranch extends BaseEntity {

    @Embedded
    private Address address;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private Rental rental;

    @OneToMany(mappedBy = "companyBranch", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    private Set<Employee> employees;

    @OneToMany(mappedBy = "companyBranch", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    private Set<Car> cars;

    private boolean closed;

    @OneToMany(mappedBy = "rentBranch")
    private List<Booking> rentBookings;
    @OneToMany(mappedBy = "returnBranch")
    private List<Booking> returnBookings;

    public static CompanyBranch fromDTO(CompanyBranchDTO companyBranchDTO, Rental rental) {

        return new CompanyBranch(
                companyBranchDTO.getAddress(),
                rental,
                new HashSet<>(),
                new HashSet<>(),
                companyBranchDTO.isClosed(),
                new ArrayList<>(),
                new ArrayList<>()
        );
    }

}
