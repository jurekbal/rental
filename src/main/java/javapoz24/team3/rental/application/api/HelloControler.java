package javapoz24.team3.rental.application.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloControler {

    @GetMapping("/hello")
    private String helloSpring() {
        return "Hello - rental app!";
    }
}
