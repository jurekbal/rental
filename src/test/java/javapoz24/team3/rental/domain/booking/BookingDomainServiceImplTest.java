package javapoz24.team3.rental.domain.booking;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BookingDomainServiceImplTest {

    BookingDomainService bookingDomainService;

    @Mock
    BookingRepository bookingRepository;

    @Before
    public void init() {
        bookingDomainService = new BookingDomainServiceImpl(bookingRepository);
    }

    @Test
    public void whenFindAllAndEmptyDBHaveToReturnEmptyList() {
//        when
        when(bookingRepository.findAll()).thenReturn(new ArrayList<>());
//        then
        assertThat(bookingDomainService.findAll()).isNotNull();
        assertThat(bookingDomainService.findAll()).isEmpty();
    }

    @Test
    public void whenFindAllReturnsNull() {
//        when
        when(bookingRepository.findAll()).thenReturn(null);
//        then
        assertThat(bookingDomainService.findAll()).isNull();
    }

    @Test
    public void whenFindByIdResultIsPresent() {
        when(bookingRepository.findById(1L)).thenReturn(Optional.of(new Booking()));
        Optional<Booking> bookingById = bookingDomainService.findById(1L);
        assertThat(bookingById).isNotNull();
        assertTrue(bookingById.isPresent());
    }

    @Test
    public void whenFindByIdResultIsNotPresent() {
        when(bookingRepository.findById(1L)).thenReturn(Optional.empty());
        Optional<Booking> bookingById = bookingDomainService.findById(1L);
        assertThat(bookingById).isNotNull();
        assertFalse(bookingById.isPresent());
    }

    @Test
    public void whenFindByIdGetsNullAsId() {
        when(bookingRepository.findById(any())).thenReturn(Optional.empty());
        Optional<Booking> bookingById = bookingDomainService.findById(null);
        assertThat(bookingById).isNotNull();
        assertFalse(bookingById.isPresent());
    }

    @Test
    public void whenAnyObjectIsPassedToAddOrUpdate() {
        when(bookingRepository.save(any())).thenReturn(new Booking());
        Booking booking = bookingDomainService.addOrUpdate(new Booking());
        assertThat(booking).isNotNull();
    }

    @Test
    public void whenNullIsPassedToAddOrUpdate() {
        when(bookingRepository.save(any())).thenReturn(new Booking());
        Booking booking = bookingDomainService.addOrUpdate(null);
        assertThat(booking).isNotNull();
    }
}
