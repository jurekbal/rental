package javapoz24.team3.rental.domain.rentact;

import javapoz24.team3.rental.domain.base.BaseEntity;
import lombok.Value;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Value
public class RentActDTO {

    Long id;
    LocalDateTime createdTimeStamp;
    Long referenceBookingId;
    @NotNull
    @DecimalMin(value = "1")
    Long customerId;
    @NotNull
    @DecimalMin(value = "1")
    Long rentingEmployeeId;
    Long closingEmployeeId;
    @NotNull
    @DecimalMin(value = "1")
    Long carId;
    @NotNull
    @DecimalMin(value = "1")
    Long rentBranchId;
    @NotNull
    @DecimalMin(value = "1")
    Long returnBranchId;
    @NotNull
    LocalDate rentDay;
    LocalDate returnDay;
    @NotNull
    BigDecimal totalCost;
    boolean open;
    String note;

    public static RentActDTO fromRentAct(RentAct rentAct) {
        Long referenceBookingId = Optional.ofNullable(rentAct.getReferenceBooking())
                .map(BaseEntity::getId).orElse(null);
        Long closingEmployeeId = Optional.ofNullable(rentAct.getClosingEmployee())
                .map(BaseEntity::getId).orElse(null);
        // pozostałe parametry nie powinny być nullem;
        return new RentActDTO(
                rentAct.getId(),
                rentAct.getCreatedTimestamp(),
                referenceBookingId,
                rentAct.getCustomer().getId(),
                rentAct.getRentingEmployee().getId(),
                closingEmployeeId,
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
