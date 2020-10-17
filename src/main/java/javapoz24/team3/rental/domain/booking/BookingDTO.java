package javapoz24.team3.rental.domain.booking;

import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Value
public class BookingDTO {

    //TODO walidacje, totalCost
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


    public static BookingDTO fromBooking(Booking booking) {
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
                booking.getTotalCost()
        );
    }
}
