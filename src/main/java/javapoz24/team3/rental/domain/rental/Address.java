package javapoz24.team3.rental.domain.rental;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
@Valid
public class Address {

    @NotNull
    @Size(min =3, max=50)
    private String streetWithNumber;

    @NotNull
    @Size(min =3, max=25)
    private String city;

    @NotNull
    @Size(min =3, max=50)
    private String postalCode;

}
