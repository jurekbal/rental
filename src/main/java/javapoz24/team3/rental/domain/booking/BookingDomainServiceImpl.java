package javapoz24.team3.rental.domain.booking;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingDomainServiceImpl implements BookingDomainService{

    private final BookingRepository bookingRepository;

    public BookingDomainServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }

    @Override
    public Optional<Booking> findById(Long id) {
        return bookingRepository.findById(id);
    }

    @Override
    public Booking addOrUpdate(Booking booking) {
        return bookingRepository.save(booking);
    }
}
