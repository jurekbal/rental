package javapoz24.team3.rental.domain.booking;

import java.util.List;
import java.util.Optional;

public interface BookingDomainService {
    List<Booking> findAll();
    Optional<Booking> findById(Long id);
    Booking addOrUpdate(Booking booking);
}
