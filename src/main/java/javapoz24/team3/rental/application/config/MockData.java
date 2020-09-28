package javapoz24.team3.rental.application.config;

import javapoz24.team3.rental.application.RentalService;
import javapoz24.team3.rental.domain.rental.Address;
import javapoz24.team3.rental.domain.rental.CompanyBranch;
import javapoz24.team3.rental.domain.rental.Rental;
import javapoz24.team3.rental.domain.rental.RentalDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Service
public class MockData {

    @Autowired
    private RentalService rentalService;

    @Autowired
    private RentalDomainService rentalDomainService;

    @PostConstruct
    public void GenerateMockData() {

        Address addressOfBranch1 = new Address("Dąbrowskiego 345", "Poznań", "61-234");
        Address addressOfBranch2 = new Address("Trzebnicka 12", "Wrocław", "50-015");
        Address addressOfBranch3 = new Address("Domaniewska 44", "Warszawa", "00-122");

        Set<CompanyBranch> branches = new HashSet<>();

        Rental rental = new Rental(
                "Car Rental Company",
                "http://carrental.pl",
                "Stanisław Nowak",
                "http://carrental.pl/logo.gif",
                branches
        );

        CompanyBranch branch1 = new CompanyBranch(addressOfBranch1, rental);
        CompanyBranch branch2 = new CompanyBranch(addressOfBranch2, rental);
        CompanyBranch branch3 = new CompanyBranch(addressOfBranch3, rental);


        branches.add(branch1);
        branches.add(branch2);
//        branches.add(branch3);

        rentalService.saveRentalInfoData(rental);

        rentalService.saveBranch(branch3);

        System.out.println("Branches List From Mocked Object:");
        System.out.println(rental.getCompanyBranches());
        System.out.println("Rental Info From Mocked Object: (saved to DB)");
        System.out.println(rental);

        //Poniższy kod wywala apkę przy FetchType.LAZY - @Transactional nic nie zmienia
//        System.out.println("*** Rental Info From DB:");
//        Rental rentalFromDB = rentalDomainService.getRentalInfo();
//        System.out.println(rentalFromDB);
    }

}
