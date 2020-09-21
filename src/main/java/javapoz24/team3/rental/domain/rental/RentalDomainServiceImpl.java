package javapoz24.team3.rental.domain.rental;

import org.springframework.stereotype.Service;

@Service
public class RentalDomainServiceImpl implements RentalDomainService {

    private final RentalRepository rentalRepository;

    public RentalDomainServiceImpl(RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }

    @Override
    public Rental getRentalInfo() {
        //for now we expect one and only Rental entry with correct data
        return rentalRepository.findAll().get(0);
    }

    @Override
    public void saveRentalInfoData(Rental rental) {
        rentalRepository.save(rental);
    }
}
