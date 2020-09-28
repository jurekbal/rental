package javapoz24.team3.rental.domain.rental;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RentalInfo {

    // Czy potrzebujemy tu id? Nasz rental ma zawsze id 1 - ale jeśli baza nada inny???

    @NotBlank(message = "Nazwa nie może być pusta!")
    @Size(min = 2, max = 50)
    String name;

    @Size(max = 50)
    String webDomain;


    @NotBlank(message = "Nazwa właściciela nie może być pusta")
    @Size(min = 1, max = 50)
    String owner;

    @Size(max = 50)
    String logoURL;
}
