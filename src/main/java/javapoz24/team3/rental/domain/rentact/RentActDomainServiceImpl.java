package javapoz24.team3.rental.domain.rentact;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RentActDomainServiceImpl implements RentActDomainService{

    public final RentActRepository rentActRepository;

    public RentActDomainServiceImpl(RentActRepository rentActRepository) {
        this.rentActRepository = rentActRepository;
    }

    @Override
    public Optional<RentAct> getRentActById(Long id) {
        return rentActRepository.findById(id);
    }

    @Override
    public List<RentAct> getAllRents() {
        return rentActRepository.findAll();
    }

    @Override
    public RentAct addOrUpdate(RentAct rentAct) {
        return rentActRepository.save(rentAct);
    }
}
