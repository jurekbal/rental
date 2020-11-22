package javapoz24.team3.rental.application;

import javapoz24.team3.rental.domain.rental.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class RentalServiceTest {

    @Autowired
    RentalService rentalService;

    @Test
    public void rentalServiceMustBeInjected() {
        assertThat(rentalService).isNotNull();
    }

    @Test
    @Transactional
    public void whenBranchSavedMustExistInDB() {
//        given
        Rental rental = new Rental();
        Address address = new Address("Wiśniowa 2", "Kołtuny", "32-867");
        CompanyBranch branch = new CompanyBranch(address, rental, false);
        CompanyBranchDTO branchDTO = CompanyBranchDTO.fromCompanyBranch(branch);

        //        when
        CompanyBranch savedCB = rentalService.addOrUpdateBranch(branchDTO);
        Optional<CompanyBranch> CBfromDB = rentalService.getBranchById(savedCB.getId());

        //then
        assertThat(CBfromDB.isPresent()).isTrue();
        assertThat(savedCB).isEqualTo(CBfromDB.get());
    }

    @Test
    @Transactional
    public void getBasicRentalInfo() {
//      given
        Address addressOfCompany = new Address("Złota 44", "Warszawa", "00-020");
        Rental rental = new Rental(
                "CCC",
                "http://carrental.pl",
                addressOfCompany,
                "Stanisław Nowak",
                "http://carrental.pl/logo.gif",
                new HashSet<>()
        );
//when
        Rental savedRental = rentalService.saveRentalInfoData(rental);
        RentalBasicDataDTO rentalInfo = rentalService.getBasicRentalInfo(savedRental.getId());
//then
        assertThat(rentalInfo).isNotNull();
        assertThat(rentalInfo.getName()).isEqualTo("CCC");
    }
}
