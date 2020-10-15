package javapoz24.team3.rental.application.api;

import javapoz24.team3.rental.application.BookingService;
import javapoz24.team3.rental.domain.booking.Booking;
import javapoz24.team3.rental.domain.booking.BookingDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping
    public List<BookingDTO> getAll() {
        return bookingService.getAll();
    }

    @GetMapping("/{id}")
    public BookingDTO getById(@PathVariable(name = "id") Long id) {
        return bookingService.getById(id)
                .map(BookingDTO::fromBooking)
                .orElse(null);
    }

    @PutMapping
    public ResponseEntity<BookingDTO> addOrUpdate(@RequestBody BookingDTO bookingDTO) {
        return bookingService.addOrUpdate(bookingDTO);
    }


}
