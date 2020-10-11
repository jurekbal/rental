package javapoz24.team3.rental.application.experimental;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class XController {

    private final XService xService;

    public XController(XService xService) {
        this.xService = xService;
    }


    @GetMapping("/xbco") //Experimental Open Branch Count
    public String getOpenBranchCount() {
        return "Open Branch Count: " + xService.getOpenBranchCount();
    }
}
