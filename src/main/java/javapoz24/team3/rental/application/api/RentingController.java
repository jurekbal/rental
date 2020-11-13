package javapoz24.team3.rental.application.api;

import javapoz24.team3.rental.application.RentingService;
import javapoz24.team3.rental.domain.rentact.RentActDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rents")
public class RentingController {

    private final RentingService rentingService;

    public RentingController(RentingService rentingService) {
        this.rentingService = rentingService;
    }

    @GetMapping
    public List<RentActDTO> getAllRents() {
        return rentingService.getAllRents();
    }

    @GetMapping("/{id}")
    public RentActDTO getRentById(@PathVariable Long id) {
        return rentingService.getRentActById(id)
                .map(RentActDTO::fromRentAct)
                .orElse(null);
    }

    @PostMapping
    public ResponseEntity<RentActDTO> addOrUpdate(@RequestBody RentActDTO rentActDTO) {
        return rentingService.addOrUpdate(rentActDTO);
    }


}
