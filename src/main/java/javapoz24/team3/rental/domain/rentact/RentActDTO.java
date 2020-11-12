package javapoz24.team3.rental.domain.rentact;

import javapoz24.team3.rental.domain.booking.Booking;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Value
public class RentActDTO {

    Long id;
    LocalDateTime createdTimeStamp;
    Long referenceBookingId;
    Long customerId;
    Long rentingEmployeeId;
    Long closingEmployeeId;
    Long carId;
    Long rentBranchId;
    Long returnBranchId;
    LocalDate rentDay;
    LocalDate returnDay;
    BigDecimal totalCost;
    boolean open;
    String note;

    public static RentActDTO fromRentAct(RentAct rentAct) {
        Optional<Booking> optBooking = Optional.ofNullable(rentAct.getReferenceBooking());
        Long referenceBookingId = null;
        if (optBooking.isPresent()) {
            referenceBookingId = optBooking.get().getId();
        }
        // pozostałe parametry nie powinny być nullem;
        //TODO Nieprawda: ClosingEmployee może być nullem!
        return new RentActDTO(
                rentAct.getId(),
                rentAct.getCreatedTimestamp(),
                referenceBookingId,
                rentAct.getCustomer().getId(),
                rentAct.getRentingEmployee().getId(),
                rentAct.getClosingEmployee().getId(),
                rentAct.getCar().getId(),
                rentAct.getRentBranch().getId(),
                rentAct.getReturnBranch().getId(),
                rentAct.getRentDay(),
                rentAct.getReturnDay(),
                rentAct.getTotalCost(),
                rentAct.isOpen(),
                rentAct.getNote()
        );
    }


}
