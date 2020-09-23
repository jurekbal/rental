package javapoz24.team3.rental.application.config;

import javapoz24.team3.rental.application.RentalService;
import javapoz24.team3.rental.domain.rental.Address;
import javapoz24.team3.rental.domain.rental.CompanyBranch;
import javapoz24.team3.rental.domain.rental.Rental;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.net.URI;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Service
public class MockData {

    @Autowired
    private RentalService rentalService;

    @PostConstruct
    public void GenerateMockData() {

        Address addressOfBranch1 = new Address("Dąbrowskiego 345", "Poznań", "61-234", null);
        Address addressOfBranch2 = new Address("Trzebnicka 12", "Wrocław", "50-015", null);
        Address addressOfBranch3 = new Address("Domaniewska 44", "Warszawa", "00-122", null);
        CompanyBranch branch1 = new CompanyBranch(addressOfBranch1, null);
        CompanyBranch branch2 = new CompanyBranch(addressOfBranch2, null);
        CompanyBranch branch3 = new CompanyBranch(addressOfBranch3, null);

        Set<CompanyBranch> branches = new HashSet<>();
        branches.add(branch1);
        branches.add(branch2);
        branches.add(branch3);

        Rental rental = new Rental(
                "Car Rental Company",
                URI.create("http://carrental.pl"),
                "Stanisław Nowak",
                URI.create("http://carrental.pl/logo.gif"),
                branches
        );

        rentalService.saveRentalIndoData(rental);
        System.out.println("Break point here");
        System.out.println(rental.getCompanyBranches());
    }

}
