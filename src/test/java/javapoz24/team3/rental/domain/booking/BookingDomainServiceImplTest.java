package javapoz24.team3.rental.domain.booking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class BookingDomainServiceImplTest {

    private BookingDomainService bookingDomainService;

    @Mock
    private BookingRepository bookingRepository;

    @BeforeEach
    public void init() {
        bookingDomainService = new BookingDomainServiceImpl(bookingRepository);
    }

    @Test
    void whenFindAllAndEmptyDBHaveToReturnEmptyList() {
//        when
        when(bookingRepository.findAll()).thenReturn(new ArrayList<>());
//        then
        bookingDomainService.findAll();

    }
}
