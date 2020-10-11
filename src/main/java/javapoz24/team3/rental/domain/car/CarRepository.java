package javapoz24.team3.rental.domain.car;

import javapoz24.team3.rental.domain.rental.CompanyBranch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car,Long> {

    List<Car> findCarByRegNumber(String regNumber);
    List<Car> findCarByCompanyBranch(CompanyBranch branch);

}
