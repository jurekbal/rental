package javapoz24.team3.rental.domain.booking;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

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
        bookingDomainService.findAll();

    }
}
