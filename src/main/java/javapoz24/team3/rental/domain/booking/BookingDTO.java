package javapoz24.team3.rental.domain.booking;

import javapoz24.team3.rental.domain.base.BaseEntity;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Value
public class BookingDTO {

    //TODO walidacje
    Long id;
    LocalDateTime createdTimestamp;
    Long customerId;
    Long employeeId;
    Long carId;
    LocalDate rentalDay;
    LocalDate returnDay;
    Long rentBranchId;
    Long returnBranchId;
    BigDecimal totalCost;
    Long rentActId;


    public static BookingDTO fromBooking(Booking booking) {
        Long rentActId = Optional.ofNullable(booking.getRentAct())
                .map(BaseEntity::getId).orElseGet(()->null);
        return new BookingDTO(
                booking.getId(),
                booking.getCreatedTimestamp(),
                booking.getCustomer().getId(),
                booking.getEmployee().getId(),
                booking.getCar().getId(),
                booking.getRentalDay(),
                booking.getReturnDay(),
                booking.getRentBranch().getId(),
                booking.getReturnBranch().getId(),
                booking.getTotalCost(),
                rentActId
        );
    }
}
